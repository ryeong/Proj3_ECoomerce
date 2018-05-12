package proj.ecom.cart.service;

import java.util.List;

import proj.ecom.cart.domain.CartDTO;

public interface CartService_Interface {

	List<CartDTO> cartList(String user_id);

}
