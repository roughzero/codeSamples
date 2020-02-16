/*
 * Created on 2015年6月18日
 */
package sample.jdk.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

public class SampleOfHsqldb {
    public static void main(String[] args) throws Exception {
        Connection conn = JdbcUtils.createConnection("org.hsqldb.jdbc.JDBCDriver", "jdbc:hsqldb:mem:mymemdb", "SA", "");
        String sql = "CREATE TABLE TEST_CHAR(SID BIGINT NOT NULL PRIMARY KEY, TEST_COL VARCHAR(10))";
        Statement st = conn.createStatement();
        st.execute(sql);
        st.execute("INSERT INTO TEST_CHAR(SID, TEST_COL) VALUES (1, '周贇ABC')");
        ResultSet rs = st.executeQuery("SELECT CHARACTER_LENGTH(TEST_COL), TO_DATE('1991-04-14', 'YYYY-MM-DD') FROM TEST_CHAR");
        while (rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getDate(2));
        }
        DatabaseMetaData metaData = conn.getMetaData();
        rs = metaData.getTables(null, "PUBLIC", "%", null);
        while (rs.next()) {
            System.out.println("Schema: " + rs.getString("TABLE_SCHEM"));
            System.out.println("Table name: " + rs.getString("TABLE_NAME"));
            System.out.println("Table type: " + rs.getString("TABLE_TYPE"));
        }
    }
}
