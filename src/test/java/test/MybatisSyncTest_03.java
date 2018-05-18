package test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class MybatisSyncTest_03 {

//	 01. mybatis-config.xml 생성
//	 02. mybatis SqlsessionFactoryBean 설정 추가  	 
	@Autowired
	private SqlSessionFactory sqlFactory;	// mybatis의 sqlsessionfactory 연동 모듈 (스프링 트렌젝션에 따른 클래스)
											//	즉  mybatis가 의존성 주입이 진행되어야 함
	
	
	
	
	/* My batis 연동 확인 */
	@Test
	public void TestMyBatisSync() throws Exception{
		System.out.println("==="+sqlFactory+"==="); 	// 출력값 : org.apache.ibatis.session.defaults.DefaultSqlSessionFactory~~~
		 	
	}
	
	/* SQL session 연동 확인 */
	@Test
	public void testSession() throws Exception{
		SqlSession session = null;
		
		try {
			session = sqlFactory.openSession();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(session!=null)session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
}

