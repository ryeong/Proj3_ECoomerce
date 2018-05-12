package proj.ecom.user.dao;

import proj.ecom.user.domain.UserDTO;

public interface UserDAO_Interface {

	//	회원가입
	public void register(UserDTO udto);
	//로그인 아이디 비밀번호 체크
	public UserDTO loginCheck(UserDTO udto);

}
