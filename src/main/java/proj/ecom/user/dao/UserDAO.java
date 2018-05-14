package proj.ecom.user.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import proj.ecom.user.domain.UserDTO;

@Repository
public class UserDAO implements UserDAO_Interface{
	static final String NAMESPACE = "UserMapper";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void register(UserDTO udto) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".insertUser", udto);
	}

	@Override
	public UserDTO loginCheck(UserDTO udto) {
		// TODO Auto-generated method stub
		UserDTO user_dto = sqlSession.selectOne(NAMESPACE+".selectUser",udto);
		return user_dto;
	}

	@Override
	public void modify(UserDTO udto) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".updateUser", udto);
	}

	@Override
	public UserDTO selectUser(UserDTO udto) {
		// TODO Auto-generated method stub
		
		UserDTO user_dto = sqlSession.selectOne(NAMESPACE+".selectModify", udto);
		return user_dto;
	}
	
}
