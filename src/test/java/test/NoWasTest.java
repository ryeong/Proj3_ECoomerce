package test;


import javax.inject.Inject;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // 톰캣 없이 사용하는 것
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class NoWasTest {

	
	@Inject
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	/*MockMvc : ajax나 client(browser)에서 요청 내용을 
	controller에서 받아 처리하는것과 같은 테스트를 진행할 수 있는것.*/
		

	
	
	
	@Before /*Test 메소드 실행전 실행되는 객체*/
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		// 빌드란 객체가 mockMvc에 넘겨주는 상태 (순서 mockMvc → Tomcat)
	}
	
}
