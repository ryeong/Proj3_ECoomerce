package proj.ecom.cart.dao;

import java.util.List;
import java.util.Map;

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

	@Override
	public void modifyCart(Map<String, Object> map) {
		sqlSession.update(NAMESPACE + ".updateCart",map);
	}
	
	@Override
	public void deleteCart(Map<String, Object> map) {
		sqlSession.update(NAMESPACE + ".deleteCart",map);
	}
}
