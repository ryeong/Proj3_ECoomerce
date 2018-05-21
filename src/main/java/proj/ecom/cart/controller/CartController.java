package proj.ecom.cart.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import proj.ecom.cart.domain.CartDTO;
import proj.ecom.cart.service.CartService_Interface;
import proj.ecom.user.domain.UserDTO;

@Controller
@RequestMapping("cart")
public class CartController {
	@Inject
	private CartService_Interface cart_service;
	
	/*장바구니 리스트 보기(model사용)*/
	@RequestMapping("/cartList")
	public String cartList(HttpSession session, Model m) {
		m.addAttribute("content", "../views/cart/cartListView.jsp");
		
		UserDTO user_dto = (UserDTO)session.getAttribute("login");
		if(user_dto == null) {
			return "main";
		}
		m.addAttribute("cart_list",cart_service.cartList(user_dto.getUser_id()));
		
		return "main";
	}
	
	/*장바구니 리스트 보기(Ajax)*/
	@RequestMapping("/getAllCartList")
	public ResponseEntity<List<CartDTO>> cartList(HttpSession session) {	
		UserDTO user_dto = (UserDTO)session.getAttribute("login");
		String user_id = user_dto.getUser_id();
		ResponseEntity<List<CartDTO>> entity;
		try {	
			 entity = new ResponseEntity<List<CartDTO>>(cart_service.cartList(user_id), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<List<CartDTO>>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	/*장바구니 수정*/
	@RequestMapping("/modifyCart")
	public ResponseEntity<String> modifyCart(HttpSession session, String cart_id, String product_num) {	
		ResponseEntity<String> entity;
		System.out.println(cart_id);
		System.out.println(product_num);
		try {	
			cart_service.modifyCart(returnUserIdAndCartId(session,cart_id,product_num));
			 entity = new ResponseEntity<String>("MODIFY_CART_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	/*장바구니 삭제*/
	@RequestMapping("/deleteCart")
	public ResponseEntity<String> deleteCart(HttpSession session, String cart_id) {
		ResponseEntity<String> entity;
		System.out.println(cart_id);
		try {
			cart_service.deleteCart(returnUserIdAndCartId(session,cart_id));
			entity = new ResponseEntity<String>("DELETE_CART_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();		
		}	
		return entity;
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
	public HashMap<String, Object> returnUserIdAndCartId(HttpSession session, String cart_id, String product_quantity){
		UserDTO user_dto = (UserDTO)session.getAttribute("login"); //나중에 static으로 바꾸기
		String user_id = user_dto.getUser_id();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("user_id", user_id);
		map.put("cart_id", cart_id);
		map.put("product_quantity", product_quantity);
		return (HashMap<String, Object>) map;
	}
}