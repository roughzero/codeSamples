/*
 * Created on 2020年8月10日
 */
package sample.jdk.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class SampleOfOracleClob {
    private final Connection conn;

    public SampleOfOracleClob(Connection conn) {
        this.conn = conn;
    }

    public void save(Long id, String content) throws Exception {
        String sql = "INSERT INTO TEST_CLOB VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, id);
        pstmt.setString(2, content);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public static void main(String[] args) throws Exception {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:demo";
        Connection conn = JdbcUtils.createConnection(driver, url, "rough", "rough");

        SampleOfOracleClob sampleOfOracleClob = new SampleOfOracleClob(conn);
        log.info("Test begin.....");
        sampleOfOracleClob.save(1L, "Test content: 中文测试");
        log.info("Test end.....");

        conn.close();
    }
}
