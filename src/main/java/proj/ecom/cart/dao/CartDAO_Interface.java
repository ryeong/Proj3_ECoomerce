package proj.ecom.cart.dao;

import java.util.List;

import proj.ecom.cart.domain.CartDTO;

public interface CartDAO_Interface {

	List<CartDTO> cartList(String user_id);

}
