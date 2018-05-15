package proj.ecom.cart.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import proj.ecom.cart.dao.CartDAO_Interface;
import proj.ecom.cart.domain.CartDTO;

@Service
public class CartService implements CartService_Interface{
	@Inject
	private CartDAO_Interface cart_dao;
	
	@Override
	public List<CartDTO> cartList(String user_id) {
		return cart_dao.cartList(user_id);
	}

	@Override
	public void modifyCart(Map<String, Object> map) {
		cart_dao.modifyCart(map);
	}
	
	@Override
	public void deleteCart(Map<String, Object> map) {
		cart_dao.deleteCart(map);	
	}

}
