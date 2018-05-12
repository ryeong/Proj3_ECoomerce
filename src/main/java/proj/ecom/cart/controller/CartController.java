package proj.ecom.cart.controller;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import proj.ecom.cart.service.CartService_Interface;

@Controller
@RequestMapping("cart")
public class CartController {
	@Inject
	private CartService_Interface cart_service;
	
	@RequestMapping("cartList")
	public String cartList(String user_id, Model m) {
		m.addAttribute("cart_list",cart_service.cartList(user_id));
		return "cart/cartListView";
	}
}
