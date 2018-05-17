package proj.ecom.payment.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import proj.ecom.cart.domain.CartDTO;
import proj.ecom.cart.service.CartService_Interface;
import proj.ecom.payment.service.PaymentService_Interface;
import proj.ecom.user.domain.UserDTO;

@Controller
@RequestMapping("payment")
public class PaymentController {
	@Inject
	private PaymentService_Interface paymentService;
	
	@Inject
	private CartService_Interface cartService;
	
	@RequestMapping(value = "/orderProduct", method = RequestMethod.GET)
	public String orderProductGet(Model m, HttpSession session ) {
		UserDTO user_dto = (UserDTO)session.getAttribute("login");
		String user_id = user_dto.getUser_id();
		m.addAttribute("cart_list",cartService.cartList(user_id));
		m.addAttribute("content", "../views/payment/orderProductView.jsp");
		return "main";
	}
	
	@RequestMapping(value = "/orderProduct", method = RequestMethod.POST)
	public String orderProductPost(Model m, HttpSession session) {
		UserDTO user_dto = (UserDTO)session.getAttribute("login");
		String user_id = user_dto.getUser_id();
		String payment_orderNum = createOrderDate(); //주문번호: yyMMddhhmmsssss 년원일시분초밀리초
		
		List<CartDTO> payment_list;
		
		//트랜잭션, AOP적용하기//
		payment_list = cartService.cartList(user_id); //트랜잭션 적용 메소드1
		//장바구니 테이블에 있는 상품목록의 정보와 주문번호를 넣어준다.
		paymentService.insertProduct(payment_list, payment_orderNum); //트랜잭션 적용 메소드2: 장바구니 테이블에 있는 결제할 상품목록의 정보를 결제 페이블로 삽입한다.
		cartService.updateStatus(user_id); //트랜잭션 적용 메소드3: 장바구니 테이블에 있는 결제할 상품목록들의 상태를 0 -> 1로 변환한다. 	
		m.addAttribute("cart_list",payment_list);
		//트랜잭션, AOP적용하기//
		m.addAttribute("content", "../views/payment/orderCompleteView.jsp");
		return "main";
	}
	
	//주문번호 생성 메소드
	public String createOrderDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmsssss");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
	
	//자세히보기로 이동(장바구니에 넣기 구현하기 위한 코드)
	@RequestMapping(value="addToCart", method=RequestMethod.GET)
	public String addToCartGet(Model model) {
		model.addAttribute("content", "../views/product/productDetailEx.jsp");	
		return "main";
	}
	
	//장바구니 테이블에 상품 정보 넣는 메소드
	@RequestMapping(value="addToCart", method=RequestMethod.POST)
	public ResponseEntity<String> addToCartPost(CartDTO cart_dto) {
		ResponseEntity<String> entity;
		try {
			//cartService.insertCart(cart_dto);
			entity = new ResponseEntity<String>("ADDTOCART_SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//결제창으로 이동시켜주는 메소드
		@RequestMapping(value="moveToOrderPage", method=RequestMethod.POST)
		public String moveToOrderPage(CartDTO cart_dto) {
			//cartService.insertCart(cart_dto);
			
			return "redirect:/payment/orderProduct";
		}
}
