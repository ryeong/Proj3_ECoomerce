package proj.ecom.cart.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import proj.ecom.cart.domain.CartDTO;

@Repository
public class CartDAO implements CartDAO_Interface{
	static final String NAMESPACE = "CartMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	public List<CartDTO> cartList(String user_id) {
		return sqlSession.selectList(NAMESPACE + ".selectCartList",user_id);
	}

	@Override
	public void modifyCart(Map<String, Object> map) {
		System.out.println(map.get("user_id"));
		System.out.println(map.get("cart_id"));
		System.out.println(map.get("product_quantity"));
		sqlSession.update(NAMESPACE + ".modifyCart",map);
	}
	
	@Override
	public void deleteCart(Map<String, Object> map) {
		sqlSession.update(NAMESPACE + ".deleteCart",map);
	}

	//
	@Override
	public void updateStatus(String user_id) {
		sqlSession.update(NAMESPACE + ".updateStatus",user_id); 
	}

	@Override
	public void insertCart(CartDTO cart_dto) {
		sqlSession.insert(NAMESPACE +".insertCart",cart_dto);
	}

}
