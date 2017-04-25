package kr.traingo.board.info.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
/*import javax.servlet.http.HttpServletResponse;*/
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.traingo.board.info.domain.InfoBoardCommand;
import kr.traingo.board.info.service.InfoBoardService;

@Controller
@SessionAttributes("infoBoardCommandId")
public class InfoBoardWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private InfoBoardService infoBoardService;
	
	@RequestMapping(value="/board/informationBoard/infowrite.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model, HttpServletRequest request, @RequestParam("code")int code){
		String id = (String)session.getAttribute("userId");
		String ip = request.getRemoteAddr();
		
		if(log.isDebugEnabled()){
			log.debug("code : " + code);
		}
		
		InfoBoardCommand infoBoardCommandId = new InfoBoardCommand();
		infoBoardCommandId.setId(id);
		infoBoardCommandId.setIp(ip);
		infoBoardCommandId.setCode(code);
		model.addAttribute("infoBoardCommandId", infoBoardCommandId);
		return "infoBoardWrite";
	}
	
	@RequestMapping(value="/board/informationBoard/infowrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("infoBoardCommandId")
	                     @Valid InfoBoardCommand infoBoardCommand,
	                     BindingResult result,
	                     SessionStatus status,
	                     HttpServletRequest request){
		
		if(log.isDebugEnabled()){
			log.debug("<<infoBoardCommand>> : " + infoBoardCommand);
		}

		//유효성 체크
		if(result.hasErrors()){
			return "infoBoardWrite";
		}
		//글쓰기 작업
		infoBoardService.insert(infoBoardCommand);
		status.setComplete();
		
		//System.out.println(infoBoardCommand);
		
		//세션에 코드 부여
		HttpSession session = request.getSession();
		session.setAttribute("code", infoBoardCommand.getCode());
		//session.setAttribute("userId", infoBoardCommand.getId());
		
		return "redirect:/board/informationBoard/infolist.do";
	}
}
