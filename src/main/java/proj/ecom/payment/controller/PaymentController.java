package proj.ecom.payment.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import proj.ecom.cart.domain.CartDTO;
import proj.ecom.cart.service.CartService_Interface;
import proj.ecom.payment.service.PaymentService_Interface;

@Controller
@RequestMapping("payment")
public class PaymentController {
	@Inject
	private PaymentService_Interface paymentService;
	
	@Inject
	private CartService_Interface cartService;
	
	@RequestMapping(value = "/orderProduct", method = RequestMethod.GET)
	public String orderProductGet(Model m, HttpSession session ) {
		//UserDTO user_dto = (UserDTO)session.getAttribute("login");
		//String user_id = user_dto.getUser_id();
		String user_id = "test1";
		m.addAttribute("cart_list",cartService.cartList(user_id));
		m.addAttribute("content", "../views/payment/orderProductView.jsp");
		return "main";
	}
	
	@RequestMapping(value = "/orderProduct", method = RequestMethod.POST)
	public String orderProductPost(Model m, HttpSession session) {
		//UserDTO user_dto = (UserDTO)session.getAttribute("login");
		//String user_id = user_dto.getUser_id();
		String user_id = "test1";
		String payment_orderNum = null; //주문번호: 날짜 + 10자리 무작위 숫자,영어
		List<CartDTO> payment_list;
		HashMap<String, Object> payment_map = new HashMap<String,Object>();
		
		//트랜잭션, AOP적용하기//
		payment_list = cartService.cartList(user_id);
	/*	payment_map.put("payment_list", payment_list);
		payment_map.put("payment_orderNum",payment_orderNum);
		paymentService.insertProduct(payment_map);*/
		m.addAttribute("cart_list",payment_list);
		//트랜잭션, AOP적용하기//
		m.addAttribute("content", "../views/payment/orderCompleteView.jsp");
		return "main";
	}
}
