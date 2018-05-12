package proj.ecom.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("payment")
public class PaymentController {
	@RequestMapping(value = "/orderProduct", method = RequestMethod.GET)
	public String orderProductGet(Model m ) {
		m.addAttribute("content", "../views//payment/orderProductView.jsp");
		return "main";
	}
	
	@RequestMapping(value = "/orderProduct", method = RequestMethod.POST)
	public String orderProductPost() {
		return "";
	}
}
