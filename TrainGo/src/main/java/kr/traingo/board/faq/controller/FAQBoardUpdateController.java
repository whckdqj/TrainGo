package kr.traingo.board.faq.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.traingo.board.faq.domain.FAQBoardCommand;
import kr.traingo.board.faq.service.FAQBoardService;

@Controller
@SessionAttributes("command")
public class FAQBoardUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private FAQBoardService faqBoardService;

	@RequestMapping(value="/board/faqBoard/faqupdate.do",method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("num")int num){
		FAQBoardCommand faqBoardCommand = faqBoardService.selectFAQBoard(num);
		return new ModelAndView("faqBoardModify", "command", faqBoardCommand);
	}

	@RequestMapping(value="/board/faqBoard/faqupdate.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
	@Valid FAQBoardCommand faqBoardCommand,
	BindingResult result,
	SessionStatus status,
	HttpSession session) throws Exception{

		if(log.isDebugEnabled()){
			log.debug("<<faqBoardCommand>> : " + faqBoardCommand);
		}

		String userId = (String)session.getAttribute("userId");

		if(!userId.equals(faqBoardCommand.getId())){
			throw new Exception("로그인한 아이디로 작성한 글이 아니기 때문에 수정할 수 없습니다.");
		}

		//유효성 체크
		if(result.hasErrors()){
			return "faqBoardModify";
		}

		//전송된 파일이 없는 경우
		if(faqBoardCommand.getUpload01().isEmpty()){
			//기존정보 셋팅
			FAQBoardCommand board = faqBoardService.selectFAQBoard(faqBoardCommand.getNum());
			faqBoardCommand.setFaq_image01(board.getFaq_image01());
			faqBoardCommand.setFaq_filename01(board.getFaq_filename01());
		}
		if(faqBoardCommand.getUpload02().isEmpty()){
			//기존정보 셋팅
			FAQBoardCommand board = faqBoardService.selectFAQBoard(faqBoardCommand.getNum());
			faqBoardCommand.setFaq_image02(board.getFaq_image02());
			faqBoardCommand.setFaq_filename02(board.getFaq_filename02());
		}
		if(faqBoardCommand.getUpload03().isEmpty()){
			//기존정보 셋팅
			FAQBoardCommand board = faqBoardService.selectFAQBoard(faqBoardCommand.getNum());
			faqBoardCommand.setFaq_image03(board.getFaq_image03());
			faqBoardCommand.setFaq_filename03(board.getFaq_filename03());
		}
		if(faqBoardCommand.getUpload04().isEmpty()){
			//기존정보 셋팅
			FAQBoardCommand board = faqBoardService.selectFAQBoard(faqBoardCommand.getNum());
			faqBoardCommand.setFaq_image04(board.getFaq_image04());
			faqBoardCommand.setFaq_filename04(board.getFaq_filename04());
		}
		
		//글 수정
		faqBoardService.update(faqBoardCommand);
		status.setComplete();

		return "redirect:/board/faqBoard/faqlist.do";
		
	}

}
