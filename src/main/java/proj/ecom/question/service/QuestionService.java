package proj.ecom.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.ecom.question.dao.QuestionDAO_Interface;
import proj.ecom.question.domain.QuestionDTO;

@Service
public class QuestionService implements QuestionService_Interface{

	@Autowired
	private QuestionDAO_Interface questionDao;
	
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
		// TODO Auto-generated method stub
		return questionDao.listAll();
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
