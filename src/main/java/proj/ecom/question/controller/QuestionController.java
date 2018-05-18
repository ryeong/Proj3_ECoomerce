package proj.ecom.question.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import proj.ecom.question.domain.QuestionDTO;
import proj.ecom.question.service.QuestionService_Interface;


@Controller
@RequestMapping("question")
public class QuestionController {
	
	@Inject
	private QuestionService_Interface questionService;
	
	
	/*	@RequestMapping(value="test", method=RequestMethod.GET)
	public String writeGet() {
	return "question/test";
	}
*/
	
	/*글 전체목록 보기*/
	@RequestMapping(value="listall", method=RequestMethod.GET)
	public String listAll(Model model) {
		model.addAttribute("content", "../views/question/listQuestionView.jsp");
		model.addAttribute("qlist", questionService.listAll());
		
	return "main";
	}
   
	
	/*글 작성 UI*/
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String createGet(Model model) {
	 model.addAttribute("content", "../views/question/writeQuestionView.jsp");
		
	return "main";
	}
	
	/*글 작성 save*/
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String createPost(QuestionDTO dto) {
		questionService.create(dto);
		
	return "redirect:/question/listall";
	}


}
