package proj.ecom.payment.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDAO implements PaymentDAO_Interface{
	static final String NAMESPACE = "PaymentMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	public void insertProduct(HashMap<String, Object> payment_map) {
		sqlSession.insert(NAMESPACE + ".",payment_map);
	}
}
