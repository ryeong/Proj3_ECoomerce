package proj.ecom.question.service;

import java.util.List;

import proj.ecom.question.domain.QuestionDTO;

public interface QuestionService_Interface {

	void create(QuestionDTO dto);
	
	QuestionDTO read(int bno);
	
	List<QuestionDTO> listAll();
	
	void update(QuestionDTO dto);
	
	void delete(int bno);
	
}
