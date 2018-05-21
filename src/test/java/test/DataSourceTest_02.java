package test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class DataSourceTest_02 {

//	 01. RootContext dataSource 설정 
	@Autowired
	private DataSource dataSource;
	
	
	@Test
	public void TestDataSource() throws Exception{
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
 	
	
	
}

/*
	 ※ @RunWith() 에 대해서
	 - 스프링의 테스트 Context 프래임워크 JUnit 확장 기능 지정
	 - JUnit은 각각의 테스트가 서로 영향을 주지 않고 독립적 실행을 원칙으로 하여 @Test 마다 객체 생성
			→ 이로인한 ApplicationContext 도 매번 새로 생성되기 때문에 테스트가 느려지는 단점 발생
	 - 이에반하여 @RunWith은 각각의 테스트별로 객체가 생성되더라도 싱글톤의 ApplicationContext 보장
	 
	 
	 ※ 싱글톤?(Singleton Pattern)
	  - DataBase Connection Pool 처럼 공통된 객체를 여러개 생성해서 사용해야하는 상황에서 많이 사용 
	  - app시작될 때 어떤 클래스가 최초한번만 메모리를 할당하고(Static)그 메모리에 인스턴스를 만들어 사용하는
	  	디자인 패턴.
	  - 생성자가 여러차례 호출되더라도 실제로 생성되는 객체는 하나이며 최초 생성 이후에 호출된 생성자는
	  	최초에 생성한 객체를 반환
	   => 즉 싱글톤 패턴은 단 하나의 인스턴스를 생성해 사용하는 패턴
	   
	   - 사용이유
	   	-- 고정된 메모리 영역을 얻으면서 한번의 new로 인스턴스를 사용하여 메모리 낭비 방지
	   	-- 싱글톤으로 만든 클래스의 객체는 전역객체이므로 다른 클래스의 객체들이 데이터를 공유하기 쉽다.
	   
	   - 문제점
	    -- 다른 클래스의 인스턴스간의 결합도 비중이 높아져 객체지향설계에 위배됨
	    -- 멀티쓰레드환경내 동기화처리를 안할 시 인스턴스가 두개가 생성되는 등 문제가 발생함
	    -- 전역객체는 최대한 지양해야 한다고 들어서 정확하게는 잘 모르겠다!..
	    

		- 멀티쓰레드 내에서의 싱글톤 클래스 생성법 (복붙 해온것 그냥 이런것이 있다고 참고 정도로 생각해볼 문제)
			출처  : https://blog.seotory.com/post/2016/03/java-singleton-pattern
	
		 -- initialization on demand holder idiom 
		 	(holder에 의한 초기화 / 클래스 안에 클래스(Holder)를 두어 JVM의 Class loader 매커니즘과 Class가 로드되는
		 	시점을 이용한 방법)
		 
			미국 메릴랜드 대학의 컴퓨터 과학 연구원인 Bill pugh 가 기존의 java singleton pattern이 가지고 있는 
			문제들을 해결 하기 위해 새로운 singleton pattern을 제시하였다. Initialization on demand holder idiom기법이다.
			이것은 jvm 의 class loader의 매커니즘과 class의 load 시점을 이용하여 내부 class를 생성시킴으로 thread 간의 
			동기화 문제를 해결한다.

=========================================================================================================
			public class InitializationOnDemandHolderIdiom {
					
					private InitializationOnDemandHolderIdiom () {
					}
					
					private static class Singleton {
						private static final InitializationOnDemandHolderIdiom instance = new InitializationOnDemandHolderIdiom();
					}
					
					public static InitializationOnDemandHolderIdiom getInstance () {
						System.out.println("create instance");
						return Singleton.instance;
					}
				}
			
			-- JVM의 클래스 초기화 과정에서 보장되는 원자적 특성을 이용하여 싱글턴의 초기화 문제에 대한 책임을 JVM에 떠넘긴다.
=========================================================================================================
			
		  initialization on demand holder idiom 역시 lazy initialization이 가능하며 모든 java 버젼과, jvm에서 사용이 가능하다. 
		  현재 java 에서 singleton 을 생성시킨다고 하면 거의 위의 방법을 사용한다고 보면 된다.
		  
		  
		-- enum initialization
			Joshua Bloch가 작성한 effective java 책에서 enum singleton 방법이 소개 되었다.

=========================================================================================================
			public enum EnumInitialization {
				INSTANCE;
				static String test = "";
				public static EnumInitialization getInstance() {
					test = "test";
					return INSTANCE;
				}
			}
=========================================================================================================
			enum 이 singleton pattern 으로 사용될 수 있는 이유는 아래와 같다.
			
			INSTANCE 가 생성될 때, multi thread 로 부터 안전하다. (추가된 methed 들은 safed 하지 않을 수도 있다.)
			단 한번의 인스턴스 생성을 보장한다.
			사용이 간편하다.
			enum value는 자바 프로그램 전역에서 접근이 가능하다.
			using reflection to destroy singleton
			위에서 여러 방법으로 singleton을 만들어 보았으니 이번엔 java의 reflection을 이용하여 singleton을 깨뜨려 보는법도 배워보자.
			누군가 작성한 코드를 원본 수정없이 작업해야 할때 이용될 수 있을 것이다.

=========================================================================================================
			public class UsingReflectionToDestroySingleton {
				
				public static void main (String[] args) {
					EagerInitialization instance = EagerInitialization.getInstance();
					EagerInitialization instance2 = null;
					
					try {
						Constructor[] constructors = EagerInitialization.class.getDeclaredConstructors();
						for ( Constructor constructor : constructors ) {
							constructor.setAccessible(true);
							instance2 = (EagerInitialization)constructor.newInstance();
						}
					} catch (Exception e) {
						
					}
					
					System.out.println(instance.hashCode());
					System.out.println(instance2.hashCode());
					
				}
			}
=========================================================================================================
	위의 코드를 실행해보면 아래 System.out.println();의 두 라인에서 찍히는 hachCode()값이 다른 것을 확인 할 수 있다.
 	java의 reflection은 매우 강력하다. 설령 class 의 생성자가 private 일지라도 강제로 가져와서 새로운 인스턴스 생성이
 	가능하다.
 	결국 singleton pattern을 깨뜨리는 것이다.
    
	@ContextConfiguration()
	
	spring bean 메타 설정 파일의 위치를 지정할 때 사용되는 @이며 경로를 지정하지 않으면 테스트 클래스 파일이 있는 
	패키지 내 다음의 설정 파일을 사용한다.
	
	ContextConfigLocationTest-context.xml   ->  대소문자 구분 없음

*/