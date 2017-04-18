package kr.traingo.board.faq.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import kr.traingo.board.faq.domain.FAQBoardCommand;
import kr.traingo.board.faq.service.FAQBoardService;

@Controller
public class FAQBoardDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private FAQBoardService faqBoardService;
	
	@RequestMapping("/board/faqBoard/faqdelete.do")
	public String submit(@RequestParam("num")int num,
						 SessionStatus status,
			             HttpSession session) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("<<num>> : " + num);
		}
		
		FAQBoardCommand faqBoardCommand = faqBoardService.selectFAQBoard(num);
		
		String userId = (String)session.getAttribute("userId");
		
		if(!userId.equals(faqBoardCommand.getId())){
			throw new Exception("로그인한 아이디로 작성된 글이 아니기때문에 삭제할 수 없습니다.");
		}
		
		//글 삭제
		faqBoardService.delete(faqBoardCommand.getNum());
		status.setComplete();
		
		return "redirect:/board/faqBoard/faqlist.do";
	}
	
	
	
}
