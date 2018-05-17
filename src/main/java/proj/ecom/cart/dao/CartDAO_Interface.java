package proj.ecom.cart.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import proj.ecom.cart.domain.CartDTO;

public interface CartDAO_Interface {

	List<CartDTO> cartList(String user_id);

	void modifyCart(Map<String, Object> map);

	void deleteCart(Map<String, Object> map);

	void updateStatus(String user_id);

}
