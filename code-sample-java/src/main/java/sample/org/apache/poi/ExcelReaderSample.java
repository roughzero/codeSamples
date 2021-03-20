/*
 * Created on 2012-6-29
 */
package sample.org.apache.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

// TODO: upgrade to newest poi.
public class ExcelReaderSample {
    public static void main(String[] args) throws Exception {
        writeToXls();
        writeToXlsx();
        readFromXls();
        readFromXlsx();
    }

    static void readFromXls() throws Exception {
        File file = new File("test-file/mso/in_001.xls");
        POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream(file));
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        HSSFSheet sheet = workbook.getSheetAt(0);

        int rowStart = sheet.getFirstRowNum();
        int rowEnd = sheet.getLastRowNum();

        System.out.println("Read from xls file start.");

        for (int i = rowStart; i <= rowEnd; i++) {
            HSSFRow row = sheet.getRow(i);
            if (null == row) continue;

            int cellStart = row.getFirstCellNum();
            int cellEnd = row.getLastCellNum();

            for (int k = cellStart; k <= cellEnd; k++) {
                HSSFCell cell = row.getCell(k);
                if (null == cell) continue;

                switch (cell.getCellType()) {
                    case NUMERIC: // 数字
                        System.out.print(cell.getNumericCellValue() + " ");
                        break;
                    case STRING: // 字符串
                        System.out.print(cell.getStringCellValue() + " ");
                        break;
                    case BOOLEAN: // Boolean
                        System.out.println(cell.getBooleanCellValue() + " ");
                        break;
                    case FORMULA: // 公式
                        System.out.print(cell.getCellFormula() + " ");
                        System.out.print(cell.getNumericCellValue() + " ");
                        break;
                    case BLANK: // 空值
                        System.out.print(" ");
                        break;
                    case ERROR: // 故障
                        System.out.print("ERROR ");
                        break;
                    default:
                        System.out.print("未知类型 ");
                        break;
                }
            }
            System.out.print("\n");
        }
        System.out.println("Read from xls file end.");
    }

    static void readFromXlsx() throws Exception {
        File file = new File("test-file/mso/in_001.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        int rowStart = xssfSheet.getFirstRowNum();
        int rowEnd = xssfSheet.getLastRowNum();

        System.out.println("Read from xlsx file start.");
        for (int i = rowStart; i <= rowEnd; i++) {
            XSSFRow row = xssfSheet.getRow(i);
            if (null == row) continue;

            int cellStart = row.getFirstCellNum();
            int cellEnd = row.getLastCellNum();

            for (int k = cellStart; k <= cellEnd; k++) {
                XSSFCell cell = row.getCell(k);
                if (null == cell) continue;

                switch (cell.getCellType()) {
                    case NUMERIC: // 数字
                        System.out.print(cell.getNumericCellValue() + " ");
                        break;
                    case STRING: // 字符串
                        System.out.print(cell.getStringCellValue() + " ");
                        break;
                    case BOOLEAN: // Boolean
                        System.out.println(cell.getBooleanCellValue() + " ");
                        break;
                    case FORMULA: // 公式
                        System.out.print(cell.getCellFormula() + " ");
                        System.out.print(cell.getNumericCellValue() + " ");
                        break;
                    case BLANK: // 空值
                        System.out.print(" ");
                        break;
                    case ERROR: // 故障
                        System.out.print("ERROR ");
                        break;
                    default:
                        System.out.print("未知类型 ");
                        break;
                }
            }
            System.out.print("\n");
        }
        System.out.println("Read from xlsx file end.");
    }

    static void writeToXlsx() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Test");
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("Test");
        cell = row.createCell(1);
        cell.setCellValue(1);
        cell = row.createCell(2);
        cell.setCellValue("中文测试");

        File outputFile = new File("test-file/mso/001.xlsx");
        if (!outputFile.exists())
            outputFile.createNewFile();
        OutputStream os = new FileOutputStream(outputFile);

        workbook.write(os);
        os.close();
    }

    static void writeToXls() throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Test");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Test");
        cell = row.createCell(1);
        cell.setCellValue(1);
        cell = row.createCell(2);
        cell.setCellValue("中文测试");

        File outputFile = new File("test-file/mso/001.xls");
        if (!outputFile.exists())
            outputFile.createNewFile();
        OutputStream os = new FileOutputStream(outputFile);

        workbook.write(os);
        os.close();
    }
}
