package proj.ecom.cart.service;

import java.util.List;

import javax.inject.Inject;

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
}
