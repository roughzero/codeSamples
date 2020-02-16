package sample.jdk.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class JdbcUtils {
    private static Log logger = LogFactory.getLog(JdbcUtils.class);

    public static Connection createConnection(String driver, String url, String userName,
            String password) throws Exception {
        Class.forName(driver);

        Connection result = DriverManager.getConnection(url, userName, password);

        return result;
    }

    public static void closeResultSetSilently(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error(e, e);
            }
        }
    }

    public static void closeStatementSilently(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                logger.error(e, e);
            }
        }
    }

    public static void closePreparedStatementSilently(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e, e);
            }
        }
    }
    
    public static void closeConnectionSilently(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error(e, e);
            }
        }
    }
}
