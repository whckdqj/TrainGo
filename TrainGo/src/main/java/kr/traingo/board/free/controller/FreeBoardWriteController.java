package kr.traingo.board.free.controller;

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

import kr.traingo.board.free.domain.FreeBoardCommand;
import kr.traingo.board.free.service.FreeBoardService;

@Controller
@SessionAttributes("freeBoardCommandId")
public class FreeBoardWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private FreeBoardService freeBoardService;
	
	@RequestMapping(value="/board/freeBoard/freewrite.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model, HttpServletRequest request){
		String id = (String)session.getAttribute("userId");
		String ip = request.getRemoteAddr();
		
		FreeBoardCommand freeBoardCommandId = new FreeBoardCommand();
		freeBoardCommandId.setId(id);
		freeBoardCommandId.setIp(ip);
		model.addAttribute("freeBoardCommandId", freeBoardCommandId);
		
		return "freeBoardWrite";
	}
	
	@RequestMapping(value="/board/freeBoard/freewrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("freeBoardCommandId")
	                     @Valid FreeBoardCommand freeBoardCommand,
	                     BindingResult result,
	                     SessionStatus status){
		if(log.isDebugEnabled()){
			log.debug("<<freeBoardCommand>> : " + freeBoardCommand);
		}
		
		//유효성 체크
		if(result.hasErrors()){
			return "freeBoardWrite";
		}
		//글쓰기 작업
		freeBoardService.insert(freeBoardCommand);
		status.setComplete();
		
		return "redirect:/board/freeBoard/freelist.do";
	}
}
