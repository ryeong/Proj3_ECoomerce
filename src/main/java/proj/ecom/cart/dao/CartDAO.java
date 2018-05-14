package proj.ecom.cart.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import proj.ecom.cart.domain.CartDTO;

@Repository
public class CartDAO implements CartDAO_Interface{
	static final String NAMESPACE = "CartMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	public List<CartDTO> cartList(String user_id) {
		return sqlSession.selectList(NAMESPACE + ".",user_id);
	}
}
