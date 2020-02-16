/*
 * Created on 2019年9月23日
 */
package sample.jdk.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SamplesOfH2 {
    protected static Log logger = LogFactory.getLog(SamplesOfH2.class);

    public static void main(String[] args) throws SQLException {

        Connection c = null;
        try {
            logger.info("Try to connect database in memory.");
            Class.forName("org.h2.Driver");
            c = DriverManager.getConnection("jdbc:h2:mem:h2mem;DB_CLOSE_DELAY=-1");
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
        sql.append(" create table TEST_TABLE (SID INTEGER, COL01 VARCHAR(20))");
        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        pstmt.execute();
        pstmt.close();
    }

    private static void process(Connection conn) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql = new StringBuffer();
        sql.append(" INSERT INTO TEST_TABLE VALUES (1, '1')");

        PreparedStatement preparedStatement = conn.prepareStatement(sql.toString());
        preparedStatement.executeUpdate();
        preparedStatement.close();

        sql = new StringBuffer();
        sql.append("SELECT COUNT(1) FROM TEST_TABLE");

        preparedStatement = conn.prepareStatement(sql.toString());
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        logger.info("There is " + rs.getInt(1) + " lines int table TEST_TABLE.");
        preparedStatement.execute();
        rs.close();
        preparedStatement.close();
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
