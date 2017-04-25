package kr.traingo.board.faq.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.traingo.board.faq.domain.FAQBoardCommand;
import kr.traingo.board.faq.service.FAQBoardService;

@Controller
@SessionAttributes("faqBoardCommandId")
public class FAQBoardWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private FAQBoardService faqBoardService;
	
	@RequestMapping(value="/board/faqBoard/faqwrite.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model, HttpServletRequest request){
		String id = (String)session.getAttribute("userId");
		String ip = request.getRemoteAddr();
		
		FAQBoardCommand faqBoardCommandId = new FAQBoardCommand();
		faqBoardCommandId.setId(id);
		faqBoardCommandId.setIp(ip);
		model.addAttribute("faqBoardCommandId", faqBoardCommandId);
		
		return "faqBoardWrite";
	}
	@RequestMapping(value="/board/faqBoard/faqwrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("faqBoardCommandId")
	                     @Valid FAQBoardCommand faqBoardCommand,
	                     BindingResult result,
	                     SessionStatus status){
		//System.out.println("<<faqBoardCommand>> : " + faqBoardCommand);
		if(log.isDebugEnabled()){
			log.debug("<<faqBoardCommand>> : " + faqBoardCommand);
		}
		//System.out.println("<<faqBoardCommand>> : " + faqBoardCommand);
	
		//유효성 체크
		if(result.hasErrors()){
			return "faqBoardWrite";
		}
		
		//글쓰기 작업
		
		faqBoardService.insert(faqBoardCommand);
		status.setComplete();
		
		return "redirect:/board/faqBoard/faqlist.do";
		
	}
	
	
	
	
}
