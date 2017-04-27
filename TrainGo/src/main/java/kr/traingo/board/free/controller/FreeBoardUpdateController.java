package kr.traingo.board.free.controller;

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

import kr.traingo.board.free.domain.FreeBoardCommand;
import kr.traingo.board.free.service.FreeBoardService;

@Controller
@SessionAttributes("command")
public class FreeBoardUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private FreeBoardService freeBoardService;
	
	@RequestMapping(value="/board/freeBoard/freeupdate.do",method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("num")int num){
		FreeBoardCommand freeBoardCommand = freeBoardService.selectFreeBoard(num);
		return new ModelAndView("freeBoardModify", "command", freeBoardCommand);
	}
	
	@RequestMapping(value="/board/freeBoard/freeupdate.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
	                     @Valid FreeBoardCommand freeBoardCommand,
	                     BindingResult result,
	                     SessionStatus status,
	                     HttpSession session) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("<<freeBoardCommand>> : " + freeBoardCommand);
		}

		String userId = (String)session.getAttribute("userId");

		if(!userId.equals(freeBoardCommand.getId())){
			throw new Exception("로그인한 아이디로 작성한 글이 아니기 때문에 수정할 수 없습니다.");
		}
		
		//유효성 체크
		if(result.hasErrors()){
			return "freeBoardModify";
		}
		
		//전송된 파일이 없는 경우
		if(freeBoardCommand.getUpload01().isEmpty()){
			//기존정보 셋팅
			FreeBoardCommand board = freeBoardService.selectFreeBoard(freeBoardCommand.getNum());
			freeBoardCommand.setFree_image01(board.getFree_image01());
			freeBoardCommand.setFree_filename01(board.getFree_filename01());
		}
		if(freeBoardCommand.getUpload02().isEmpty()){
			//기존정보 셋팅
			FreeBoardCommand board = freeBoardService.selectFreeBoard(freeBoardCommand.getNum());
			freeBoardCommand.setFree_image02(board.getFree_image02());
			freeBoardCommand.setFree_filename02(board.getFree_filename02());
		}
		if(freeBoardCommand.getUpload03().isEmpty()){
			//기존정보 셋팅
			FreeBoardCommand board = freeBoardService.selectFreeBoard(freeBoardCommand.getNum());
			freeBoardCommand.setFree_image03(board.getFree_image03());
			freeBoardCommand.setFree_filename03(board.getFree_filename03());
		}
		if(freeBoardCommand.getUpload04().isEmpty()){
			//기존정보 셋팅
			FreeBoardCommand board = freeBoardService.selectFreeBoard(freeBoardCommand.getNum());
			freeBoardCommand.setFree_image04(board.getFree_image04());
			freeBoardCommand.setFree_filename04(board.getFree_filename04());
		}
		if(freeBoardCommand.getUpload05().isEmpty()){
			//기존정보 셋팅
			FreeBoardCommand board = freeBoardService.selectFreeBoard(freeBoardCommand.getNum());
			freeBoardCommand.setFree_image05(board.getFree_image05());
			freeBoardCommand.setFree_filename05(board.getFree_filename05());
		}
		if(freeBoardCommand.getUpload06().isEmpty()){
			//기존정보 셋팅
			FreeBoardCommand board = freeBoardService.selectFreeBoard(freeBoardCommand.getNum());
			freeBoardCommand.setFree_image06(board.getFree_image06());
			freeBoardCommand.setFree_filename06(board.getFree_filename06());
		}
		if(freeBoardCommand.getUpload07().isEmpty()){
			//기존정보 셋팅
			FreeBoardCommand board = freeBoardService.selectFreeBoard(freeBoardCommand.getNum());
			freeBoardCommand.setFree_image07(board.getFree_image07());
			freeBoardCommand.setFree_filename07(board.getFree_filename07());
		}
		if(freeBoardCommand.getUpload08().isEmpty()){
			//기존정보 셋팅
			FreeBoardCommand board = freeBoardService.selectFreeBoard(freeBoardCommand.getNum());
			freeBoardCommand.setFree_image08(board.getFree_image08());
			freeBoardCommand.setFree_filename08(board.getFree_filename08());
		}
		if(freeBoardCommand.getUpload09().isEmpty()){
			//기존정보 셋팅
			FreeBoardCommand board = freeBoardService.selectFreeBoard(freeBoardCommand.getNum());
			freeBoardCommand.setFree_image09(board.getFree_image09());
			freeBoardCommand.setFree_filename09(board.getFree_filename09());
		}
		if(freeBoardCommand.getUpload10().isEmpty()){
			//기존정보 셋팅
			FreeBoardCommand board = freeBoardService.selectFreeBoard(freeBoardCommand.getNum());
			freeBoardCommand.setFree_image10(board.getFree_image10());
			freeBoardCommand.setFree_filename10(board.getFree_filename10());
		}
		
		
		
		//글 수정
		freeBoardService.update(freeBoardCommand);
		status.setComplete();
		
		return "redirect:/board/freeBoard/freelist.do";
		
	}
	
}
