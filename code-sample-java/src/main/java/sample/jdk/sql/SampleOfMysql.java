/*
 * Created on 2015年8月13日
 */
package sample.jdk.sql;

import java.sql.Connection;
import java.sql.ResultSet;

public class SampleOfMysql {
    public static void main(String[] args) throws Exception {
        //        Connection conn = JdbcUtils
        //                .createConnection("com.mysql.jdbc.Driver", "jdbc:mysql://rough-mysql/test", "rough", "rough");
//        Connection conn = JdbcUtils.createConnection("com.mysql.jdbc.Driver", "jdbc:mysql://rough-server/demo", "rough",
//                "rough");
        Connection conn = JdbcUtils.createConnection("com.mysql.jdbc.Driver", "jdbc:mysql://10.56.80.228/huarui", "huar_test",
                "huar_test");
        System.out.println(conn);
        ResultSet rs = conn.getMetaData().getTables(null, "rough", "%", null);
        while (rs.next()) {
            System.out.println(rs.getString("TABLE_NAME"));
        }
    }
}