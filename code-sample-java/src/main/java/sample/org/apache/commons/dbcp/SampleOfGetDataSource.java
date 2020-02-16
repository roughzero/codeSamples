/*
 * Created on 2012-10-8
 */
package sample.org.apache.commons.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Assert;

public class SampleOfGetDataSource {

    public void testGetDataSource() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:demo");
        dataSource.setUsername("rough");
        dataSource.setPassword("rough");
        Connection connection1 = dataSource.getConnection();
        Connection connection2 = dataSource.getConnection();
        Assert.assertNotNull(connection1);
        Assert.assertNotNull(connection2);
        Assert.assertNotSame(connection1, connection2);
    }
}
