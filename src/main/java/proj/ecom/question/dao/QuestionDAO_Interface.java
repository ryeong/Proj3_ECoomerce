package proj.ecom.question.dao;

import java.util.List;

import proj.ecom.question.domain.QuestionDTO;

public interface QuestionDAO_Interface {
	
	void create(QuestionDTO dto);
	
	QuestionDTO read(int bno);
	
	List<QuestionDTO> listAll();
	
	void update(QuestionDTO dto);
	
	void delete(int bno);
	
	Integer getBno();
}