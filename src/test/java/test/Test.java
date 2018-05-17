package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import proj.ecom.cart.domain.CartDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Test {
	@Inject
	private SqlSession sqlSession;
	
	@org.junit.Test
	public void test() {
		int i = 1;
		List<CartDTO> payment_list = new ArrayList<CartDTO>();
		CartDTO dto = new CartDTO();
		String payment_orderNum = "2222222222";
		dto.setCart_id(2);
		payment_list.set(0, dto);
		for(CartDTO payment_dto: payment_list) {
			System.out.println(i);
			HashMap<String, Object> payment_map = new HashMap<String,Object>();
			int cart_id = payment_dto.getCart_id();
			payment_map.put("payment_cart_id", cart_id);
			System.out.println(payment_dto);
			System.out.println();
			System.out.println();
			payment_map.put("payment_ordernum",payment_orderNum);
			payment_map.put("i",i);
			sqlSession.insert("PaymentMapper" + ".insertProduct",payment_map);
			
			payment_map.remove("payment_cart_id");
			payment_map.remove("payment_ordernum");
			i++;
		}
	}
}
