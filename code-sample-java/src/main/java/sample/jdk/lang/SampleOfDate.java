/*
 * Created on 2015年4月30日
 */
package sample.jdk.lang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleOfDate {

    public static void main(String[] args) throws Exception {
        //TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
        //        String URL = "jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = ghlisdb1)(PORT = 1521)) (ADDRESS = (PROTOCOL = TCP)(HOST = ghlisdb2)(PORT = 1521))) (LOAD_BALANCE = yes) (FAILOVER = ON) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = lisdb)))";
        //        URL = "jdbc:oracle:thin:@rough-db:1521:demo";
        //        Connection conn = null;
        //        for (int i = 0; i < 1; i++) {
        //            conn = JdbcUtils.createConnection("oracle.jdbc.driver.OracleDriver", URL, "rough", "rough");
        //        }
        //        String sql = "select date '1991-04-14' from dual";
        //        Statement st = conn.createStatement();
        //        ResultSet rs = st.executeQuery(sql);
        //        rs.next();
        //        System.out.println(rs.getDate(1));

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = format.parse("2012-06-30");
        Date d2 = format.parse("2012-07-01");
        System.out.println(d2.getTime() - d1.getTime());

        Date d3 = format.parse("1989-06-21");
        System.out.println(d3);

        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date d4 = new Date();
        System.out.println(format.format(d4));
    }
}
//-Duser.timezone=gmt+8