package proj.ecom.user.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String registerGet(UserDTO udto) {
		return "/user/registerView";
	}
	
	/*회원 가입*/
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(UserDTO udto) {
		userService.register(udto);
		return "redirect:/";
		
	}
	
}
