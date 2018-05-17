package proj.ecom.question.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import proj.ecom.question.domain.QuestionDTO;

@Repository
public class QuestionDAO implements QuestionDAO_Interface{
	static final String NAMESPACE = "QuestionMapper";

	@Inject
	private SqlSession sqlSession;
	
	
	@Override
	public void create(QuestionDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QuestionDTO read(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuestionDTO> listAll() {
		return sqlSession.selectList(NAMESPACE+".listAll");
	}

	@Override
	public void update(QuestionDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getBno() {
		// TODO Auto-generated method stub
		return null;
	}
}
