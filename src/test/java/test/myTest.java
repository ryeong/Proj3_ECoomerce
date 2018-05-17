package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import proj.ecom.product.service.ProductService_Interface;
import proj.ecom.util.Criteria;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class myTest {
	@Autowired
	private ProductService_Interface productService;
	
	@Test
	public void productDetail() throws Exception{
		try {
			//메소드에 들어가야 할 값 임의로 지정
			int product_id=1;
			
			
			productService.productDetail(product_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
