package test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DataBaseConnectTest_01 {

	
	/* 01. Db datasource 설정 */
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String uri  = "jdbc:oracle:thin:@211.183.7.23:1522:orcl";
	private String user = "proj";
	private String pass = "proj";
	
	
	/* 02. test 설정 */
	@Test			// 테스팅 하는 메소드에는 @Test 를 붙여야 함
	public void testDBConnect() throws Exception{
		
		Class.forName(driver);
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(uri, user, pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
