package proj.ecom.user.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String loginCheck(UserDTO udto,HttpSession session, Model model, RedirectAttributes rttr) {
		UserDTO user_dto = userService.loginCheck(udto);
		if(user_dto == null) { //로그인 실패
			rttr.addFlashAttribute("isSuccess", "false");
			return"redirect:/";
			
		} else {//로그인 성공
			session.setAttribute("login",user_dto);
			return "main" ;
		}

		
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
	public String modifyGet(HttpSession session, Model model) {
		
		model.addAttribute("login1", userService.selectUser((UserDTO) session.getAttribute("login")));
		model.addAttribute("content","../views/user/modifyView.jsp");
		//model.addAttribute("session",session.getAttribute("login"));
		
		return "main";
	}
	
	/*회원 수정*/
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(HttpSession session, Model model,UserDTO udto) {
		
		userService.modify(udto);
		session.setAttribute("login", udto);
		return "redirect:/";
		
	}
	
	/*회원 탈퇴*/
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(HttpSession session,UserDTO udto) {
		System.out.println("탈퇴");
		System.out.println((UserDTO)session.getAttribute("login"));
		userService.delete((UserDTO)session.getAttribute("login"));
		session.removeAttribute("login");
		session.invalidate();
		return "main";
	}
}
