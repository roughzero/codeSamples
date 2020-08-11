/*
 * Created on 2020年8月10日
 */
package sample.jdk.sql;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.extern.apachecommons.CommonsLog;
import oracle.sql.BLOB;

@CommonsLog
public class SampleOfOracleBlob {
    private final Connection conn;

    public SampleOfOracleBlob(Connection conn) {
        this.conn = conn;
    }

    public void saveFileToBlobAsByte(Long id, String fileName) throws Exception {
        String insertSql = "INSERT INTO TEST_BLOB VALUES (?, EMPTY_BLOB())";
        String updateSql = "SELECT COL_BLOB FROM TEST_BLOB WHERE TEST_BLOB_ID = ? FOR UPDATE";

        PreparedStatement insertPstmt = conn.prepareStatement(insertSql);
        insertPstmt.setLong(1, id);
        insertPstmt.executeUpdate();
        PreparedStatement updatePstmt = conn.prepareStatement(updateSql);
        updatePstmt.setLong(1, id);
        ResultSet rs = updatePstmt.executeQuery();
        if (rs.next()) {
            BLOB blob = (BLOB) rs.getBlob(1);
            OutputStream out = blob.setBinaryStream(0);
            File file = new File(fileName);
            InputStream is = new FileInputStream(file);
            byte[] buff = new byte[is.available()];
            if (is.read(buff) > 0) {
                out.write(buff);
            }
            is.close();
            out.close();
            log.info("Saving file to database succeeded.");
        }
        rs.close();
        updatePstmt.close();
        insertPstmt.close();
    }

    public void saveFileToBlob(Long id, String fileName) throws Exception {
        String insertSql = "INSERT INTO TEST_BLOB VALUES (?, EMPTY_BLOB())";
        String updateSql = "SELECT COL_BLOB FROM TEST_BLOB WHERE TEST_BLOB_ID = ? FOR UPDATE";

        PreparedStatement insertPstmt = conn.prepareStatement(insertSql);
        insertPstmt.setLong(1, id);
        insertPstmt.executeUpdate();
        PreparedStatement updatePstmt = conn.prepareStatement(updateSql);
        updatePstmt.setLong(1, id);
        ResultSet rs = updatePstmt.executeQuery();
        if (rs.next()) {
            BLOB blob = (BLOB) rs.getBlob(1);
            OutputStream out = blob.setBinaryStream(0);
            File file = new File(fileName);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buff = new byte[2048];
            while (true) {
                //在这里执行写入，如写入到文件的BufferedOutputStream里
                int bytesRead = bis.read(buff, 0, buff.length);
                if (bytesRead > 0) {
                    out.write(buff, 0, bytesRead);
                } else {
                    break;
                }
            }
            bis.close();
            out.close();
            log.info("Saving file to database succeeded.");
        }
        rs.close();
        updatePstmt.close();
        insertPstmt.close();
    }

    @SuppressWarnings({"ResultOfMethodCallIgnored", "UnusedReturnValue"})
    public File readToFile(Long id, String fileName) throws Exception {
        String sql = "SELECT COL_BLOB FROM TEST_BLOB WHERE TEST_BLOB_ID = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, id);
        ResultSet rs = pstmt.executeQuery();
        File file = new File(fileName);
        if (rs.next()) {
            BLOB blob = (BLOB) rs.getBlob(1);
            InputStream is = blob.getBinaryStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            if (file.exists()) {
                file.delete();
            }
            OutputStream out = new FileOutputStream(file);
            byte[] buff = new byte[2048];
            while (true) {
                //在这里执行写入，如写入到文件的BufferedOutputStream里
                int bytesRead = bis.read(buff, 0, buff.length);
                if (bytesRead > 0) {
                    out.write(buff, 0, bytesRead);
                } else {
                    break;
                }
            }
            bis.close();
            out.close();
            log.info("Saving blob to file succeeded.");
        }
        rs.close();
        pstmt.close();
        return file;
    }

    public static void main(String[] args) throws Exception {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:demo";
        Connection conn = JdbcUtils.createConnection(driver, url, "rough", "rough");

        SampleOfOracleBlob sampleOfOracleBlob = new SampleOfOracleBlob(conn);
        log.info("Test begin.....");
        sampleOfOracleBlob.saveFileToBlobAsByte(1L, "d:\\data\\rough\\tmp\\test_in.txt");
        sampleOfOracleBlob.saveFileToBlob(2L, "d:\\data\\rough\\tmp\\test_in.txt");
        sampleOfOracleBlob.readToFile(1L, "d:\\data\\rough\\tmp\\test_out.txt");
        log.info("Test end.....");

        conn.close();
    }
}
