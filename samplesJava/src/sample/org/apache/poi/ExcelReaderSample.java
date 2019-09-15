/*
 * Created on 2012-6-29
 */
package sample.org.apache.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReaderSample {
    public static void main(String[] args) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Test");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Test");
        cell = row.createCell(1);
        cell.setCellValue(1);
        cell = row.createCell(2);
        cell.setCellValue("中文测试");

        File outputFile = new File("testfile/mso/001.xls");
        if (!outputFile.exists())
            outputFile.createNewFile();
        OutputStream os = new FileOutputStream(outputFile);

        workbook.write(os);
        os.close();
    }
}
