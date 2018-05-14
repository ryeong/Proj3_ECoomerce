package proj.ecom.user.service;

import proj.ecom.user.domain.UserDTO;

public interface UserService_Interface {

	//회원 가입
	public void register(UserDTO udto);
	//아이디 비밀번호 체크
	public UserDTO loginCheck(UserDTO udto);
	//회원수정
	public void modify(UserDTO udto);
	//수정한 회원의 정보 가져오기
	public UserDTO selectUser(UserDTO udto);
	
	
}
