package proj.ecom.user.service;

import javax.servlet.http.HttpSession;

import proj.ecom.user.domain.UserDTO;

public interface UserService_Interface {

	//회원 가입
	public void register(UserDTO udto);
	//아이디 비밀번호 체크
	public UserDTO loginCheck(UserDTO udto);
	//회원수정
	public void modify(UserDTO udto);
	
}
