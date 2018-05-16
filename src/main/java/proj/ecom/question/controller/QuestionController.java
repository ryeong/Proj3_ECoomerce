package proj.ecom.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("question")
public class QuestionController {
	
	@RequestMapping("test")
	public void testController() {
		System.out.println("----test Controller---");
	}

}
