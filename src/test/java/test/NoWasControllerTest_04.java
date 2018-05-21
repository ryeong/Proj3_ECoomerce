package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;							// slf4j-api  의존성
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration				//	Tomcat server 없이 연동 테스트 확인해보기
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*,xml")
public class NoWasControllerTest_04 {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	
	Logger logger = LoggerFactory.getLogger(NoWasControllerTest_04.class); 
	
	
	@Before
	public void setTest() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); // build 객체가 mockMvc에 톰캣보다 우선 전송 (즉 톰캣보다 우선 구동)
		
		logger.info("---------------------------------------------------------");
	}
	
	
	@Test
	public void testController() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.get("/question/test"));
	}

}





/* 
 SpringJUnit4ClassRunner 에 대해서
   - spring-test 에 즉 메이븐 의존성객체에서 제공하는 단위테스트를 위한 클래스러너!
  
 @ContextConfiguration 어노테이션
   - 스프링 빈 설정, 데이터베이스 설정 등이 있는 servlet-context.xml과 같은 xml 설정을 읽어 
	 스프링 테스트 시작 전에 빈을 초기화 하여 @Autowired 를 통해 빈 팩토리에서 미리 생성한 빈들을 
     읽어 들일 수 있고 그 밖의 spring 프레임워크 설정들을 읽어 들일 수 있다.
 
 	출처 : http://thswave.github.io/java/2015/03/02/spring-mvc-test.html
 	
  - 테스트 클래스는 각 객체에서 사용된 컨트롤러의 진행흐름을 판단하기 위한 수단으로 사용하고 있으며
  	상태만을 확인하기 위한 수단이 아닌것으로 생각하자!
  	

  WebApplicationContext
  
   -org.springframework.web.context.WebApplicationContext 인터페이스는 웹 어플리케이션을 위한 
    Applicationcontext 로서 하나의 웹 어플리케이션(즉, 하나의 ServletContext) 마다 한 개의 WebApplicationContext가 존재
    WebApplicationContext인터페이스는 웹 어플리케이션을 위해 추가적으로 제공되는 빈 영역(bean scope) 을 정의함.
  
   - 어떤 클래스 패키지의 경로 내부에 다양한 클래스 파일이 있다고 가정 할 때 여기서 모든 클래스파일이 
   	 WebApplicationContext부분에 올려지는것이 아니라 @Controller 또는 @Component 등과 같은 
   	 어노테이션이 붙은 클래스파일만 모두 찾아서 WebApplicationContext에 업로드 되어 객체가 생성

   - 출처 : http://blog.daum.net/lesay/8030450
   			https://blog.naver.com/duddnddl9/220635404425
   			
   			
   logger(org.slf4j.Logger) 사용하는 사유
   
   - 일 log4j를 걷어내고 logback으로 교체하는 업무가 주어졌다고 가정 해봅니다.
   	 우리는 우선 maven이나 gradle에서 log4j의 dependency를 exclude하고 다시 logback을 추가를 합니다.
   	 와 IDE에 시뻘건 불이 수백개가 번쩍 거리네요!!
   	 요렇게 기존에 import했던 log4j의 수백개의 클래스가 뻘건줄을 내뿜기 시작했습니다.
   	 import org.apache.log4j.Logger;
   	 import org.apache.log4j.spi.LoggerFactory;
	 /// 생략 ///
	 Logger log = Logger.getLogger(this.getClass());
	 /// 생략 ///
	 log.info("blah blah log")
	 하지만 이정도로는 당황하지 않습니다. 다행히도 우리의 Eclipse와 Intellij는 한꺼번에 파일 텍스트를 
	 replace해줄 수 있는 기능이 있습니다. 아주 간단히 모든 import와 구문을 한꺼번에 바꿨습니다!! 
	 그리고 이제 commit을 해야겠죠… 수백개의 파일이 한꺼번에 커밋이 됩니다… 심지어 다른 사람이 지금 
	 작성중인 소스들까지 모두 교체가 됩니다. 수십개의 내가 모르는 파일이 Conflict가 납니다. 
	 하나하나 파일을 손보지 않으면 방법이 없습니다. 이건 IDE도 어찌할 방법이 없습니다.


 */