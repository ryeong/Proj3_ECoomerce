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
	public Integer getBno() {
		Integer bno = sqlSession.selectOne(NAMESPACE+".getBno");
		
		if(bno != null) bno = bno+1;
		else bno = 1;
		
		return bno;
	}
	
	@Override
	public void create(QuestionDTO dto) {
		dto.setBno(getBno());
		sqlSession.insert(NAMESPACE+".insert", dto);
		
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


}
