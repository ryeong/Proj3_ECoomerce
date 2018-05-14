package proj.ecom.user.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proj.ecom.user.dao.UserDAO_Interface;
import proj.ecom.user.domain.UserDTO;

@Service
public class UserService implements UserService_Interface{
	
	@Inject
	private UserDAO_Interface udao;

	@Transactional
	@Override
	public void register(UserDTO udto) {
		// TODO Auto-generated method stub
		udao.register(udto);
	}

	@Override
	public UserDTO loginCheck(UserDTO udto) {
		// TODO Auto-generated method stub
		UserDTO user_dto = udao.loginCheck(udto);
		return user_dto;
	}

	@Override
	public void modify(UserDTO udto) {
		// TODO Auto-generated method stub
		udao.modify(udto);
	}

	@Override
	public UserDTO selectUser(UserDTO udto) {
		UserDTO user_dto=udao.selectUser(udto);
		return user_dto;
	}

}
