package test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MyOracleConnectionTest {
	private String driver ="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@211.183.7.23:1522:orcl";
	private String user="proj";
	private String pass="proj";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(driver);
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(url,user,pass);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
				
			
		}
	}
	
	
	
}
