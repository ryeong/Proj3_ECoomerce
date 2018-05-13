package proj.ecom.user.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import proj.ecom.user.dao.UserDAO_Interface;
import proj.ecom.user.domain.UserDTO;
import proj.ecom.user.service.UserService_Interface;


@Controller
@RequestMapping("user")
public class UserController {
	
	@Inject
	private UserService_Interface userService;
	
	/*회원 가입 폼*/
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet(UserDTO udto, Model model) {
		model.addAttribute("content", "../views/user/registerView.jsp");
		return "main";
	}
	
	/*회원 가입*/
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(UserDTO udto) {
		
		userService.register(udto);
		return "redirect:/";
		
	}
	
	/*로그인*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginCheck(UserDTO udto,HttpSession session, Model model) {
		UserDTO user_dto = userService.loginCheck(udto);
		
		if(user_dto.getUser_id() != null) {
			session.setAttribute("login",user_dto);
		} 
		System.out.println("login_start!!!!");
		System.out.println(user_dto.getUser_id());
		//System.out.println((String) session.getAttribute("user_id"));
		//System.out.println(user_id);
		return "main" ;
		
		
	}
	
	/*로그아웃*/
	@RequestMapping(value="/logout", method= RequestMethod.POST)
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		session.invalidate();
		
		return "redirect:/";
		
	}
	
	/*회원 수정 폼*/
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyGet(HttpSession session, Model model, UserDTO udto) {

		
		model.addAttribute("content","../views/user/modifyView.jsp");
		model.addAttribute("udto",udto);
		
		return "main";
	}
	
	/*회원 수정*/
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(HttpSession session, Model model,UserDTO udto) {
		//String user_id;
		udto=(UserDTO) session.getAttribute("login");
		//user_id=udto.getUser_id();
		System.out.println("=-=-=-=-=-=-");
		System.out.println(udto.getUser_id());
		userService.modify(udto);
		
		return "redirect:/";
		
	}
}
