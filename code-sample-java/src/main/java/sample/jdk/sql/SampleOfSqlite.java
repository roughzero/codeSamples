/*
 * Created on 2017年6月20日
 */
package sample.jdk.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SampleOfSqlite {
    protected static Log logger = LogFactory.getLog(SampleOfSqlite.class);

    public static void main(String[] args) throws SQLException {

        Connection c = null;
        try {
            logger.info("Try to connect database test.db.");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            logger.info("Opened database successfully");

            init(c);

            process(c);

            clean(c);

            c.close();
        } catch (Exception e) {
            logger.error(e, e);
            System.exit(0);
        }
    }

    private static void init(Connection conn) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql.append(" create table TEST_TABLE (SID INTEGER, COL01 VARCHAR2(20))");
        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        pstmt.execute();
        pstmt.close();
    }

    private static void process(Connection conn) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql = new StringBuffer();
        sql.append(" INSERT INTO TEST_TABLE VALUES (1, '1')");

        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        pstmt.executeUpdate();
        pstmt.close();

        sql = new StringBuffer();
        sql.append("SELECT COUNT(1) FROM TEST_TABLE");

        pstmt = conn.prepareStatement(sql.toString());
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        logger.info("Thers is " + rs.getInt(1) + " lines int table TEST_TABLE.");
        pstmt.execute();
        rs.close();
        pstmt.close();
    }

    private static void clean(Connection conn) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql = new StringBuffer();
        sql.append("DROP TABLE TEST_TABLE");
        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        pstmt.execute();
        logger.info("Table TEST_TABLE dropped.");
    }
}
