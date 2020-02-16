/*
 * Created on 2015年7月7日
 */
package sample.jdk.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SampleOfLocal {
    public static void main(String[] args) throws Exception {
        Connection conn = JdbcUtils.createConnection("oracle.jdbc.driver.OracleDriver",
                "jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = ghlisdb1-vip)(PORT = 1521)) (ADDRESS = (PROTOCOL = TCP)(HOST = ghlisdb2-vip)(PORT = 1521))) (LOAD_BALANCE = no) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = lisdb)))",
                "lis2014", "lis2014");
        System.out.println(conn);
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT DISTINCT TRIM(PAYNO) PAYNO");
        sql.append(" FROM LJAPAYPERSON A");
        sql.append(" WHERE 1 = 1");
        sql.append(" AND PAYTYPE = 'ZC'");
        sql.append(" AND CONFDATE >= DATE '2019-08-10'");
        sql.append(" AND CONFDATE <= DATE '2019-08-11'");
        sql.append(" AND GRPPOLNO = '00000000000000000000'");
        sql.append(" AND EXISTS");
        sql.append(" (SELECT 1");
        sql.append(" FROM V_BC_LCCONT B");
        sql.append(" WHERE A.CONTNO = B.CONTNO");
        sql.append(" AND (B.SALECHNL = '03' OR");
        sql.append(" B.SALECHNL || B.SALECHNLDETAIL IN ('0803', '0812')))");
        sql.append(" AND NOT EXISTS (SELECT 1");
        sql.append(" FROM lis.LA_COMMISSION_BANK_MAIN LCBM");
        sql.append(" WHERE LCBM.BUSINESS_TYPE = 'Premium'");
        sql.append(" AND LCBM.BUSINESS_ID = TRIM(A.PAYNO))");

        Statement stmt = conn.createStatement();

        System.out.println("Start...");

        ResultSet rs = stmt.executeQuery(sql.toString());
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }

        rs.close();
        stmt.close();

        System.out.println("finished...");
    }
}
