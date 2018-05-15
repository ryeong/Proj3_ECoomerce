package proj.ecom.cart.controller;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import proj.ecom.cart.service.CartService_Interface;
import proj.ecom.user.domain.UserDTO;

@Controller
@RequestMapping("cart")
public class CartController {
	@Inject
	private CartService_Interface cart_service;
	
	/*장바구니 리스트 보기*/
	@RequestMapping("/cartList")
	public String cartList(HttpSession session, Model m) {
		//UserDTO user_dto = (UserDTO)session.getAttribute("login");		
		//m.addAttribute("cart_list",cart_service.cartList(user_dto.getUser_id()));
		/*test용 id*/
		String user_id = "test1";
		m.addAttribute("cart_list",cart_service.cartList(user_id));
		m.addAttribute("content", "../views/cart/cartListView.jsp");
		return "main";
	}
	
	/*장바구니 수정*/
	@RequestMapping("/modifyCart")
	public ResponseEntity<String> modifyCart(HttpSession session, String cart_id, String product_num) {	
		cart_service.modifyCart(returnUserIdAndCartId(session,cart_id,product_num));
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	/*장바구니 삭제*/
	@RequestMapping("/deleteCart")
	public ResponseEntity<String> deleteCart(HttpSession session, String cart_id) {
		cart_service.deleteCart(returnUserIdAndCartId(session,cart_id));
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	/*user_id와 cart_id를 가지고 있는 map객체 반환*/
	public HashMap<String, Object> returnUserIdAndCartId(HttpSession session, String cart_id){
		UserDTO user_dto = (UserDTO)session.getAttribute("login"); //나중에 static으로 바꾸기
		String user_id = user_dto.getUser_id();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("cart_id", cart_id);
		return (HashMap<String, Object>) map;
	}
	
	/*user_id와 cart_id, product_num를 가지고 있는 map객체 반환*/
	public HashMap<String, Object> returnUserIdAndCartId(HttpSession session, String cart_id, String product_num){
		UserDTO user_dto = (UserDTO)session.getAttribute("login"); //나중에 static으로 바꾸기
		String user_id = user_dto.getUser_id();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("cart_id", cart_id);
		map.put("product_num", product_num);
		return (HashMap<String, Object>) map;
	}
}