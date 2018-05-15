package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Test {
	@Inject
	private DataSource dataSource;
	
	@org.junit.Test
	public void test() {
		try {
			dataSource.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
