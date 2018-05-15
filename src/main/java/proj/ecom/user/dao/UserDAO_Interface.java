package proj.ecom.user.dao;

import proj.ecom.user.domain.UserDTO;

public interface UserDAO_Interface {

	//	회원가입
	public void register(UserDTO udto);
	//로그인 아이디 비밀번호 체크
	public UserDTO loginCheck(UserDTO udto);
	//회원수정
	public void modify(UserDTO udto);
	//수정한 회원의 정보 가져오기
	public UserDTO selectUser(UserDTO udto);
	//회원 탈퇴
	public void delete(UserDTO udto);

}
