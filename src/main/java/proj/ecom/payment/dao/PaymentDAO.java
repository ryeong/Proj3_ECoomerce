package proj.ecom.payment.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import proj.ecom.cart.domain.CartDTO;

@Repository
public class PaymentDAO implements PaymentDAO_Interface{
	static final String NAMESPACE = "PaymentMapper";
	
	@Inject
	private SqlSession sqlSession;

	public void insertProduct(List<CartDTO> payment_list, String payment_orderNum) {
		int i = 1;
		for(CartDTO payment_dto: payment_list) {
			HashMap<String, Object> payment_map = new HashMap<String,Object>();
			int cart_id = payment_dto.getCart_id();
			payment_map.put("payment_cart_id", cart_id);
			System.out.println(payment_dto);
			System.out.println();
			System.out.println();
			payment_map.put("payment_ordernum",payment_orderNum);
			payment_map.put("i",i);
			sqlSession.insert(NAMESPACE + ".insertProduct",payment_map);
			
			payment_map.remove("payment_cart_id");
			payment_map.remove("payment_ordernum");
			i++;
		}
	}
}
