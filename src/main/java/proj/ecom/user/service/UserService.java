package proj.ecom.user.service;

import javax.inject.Inject;

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

}
