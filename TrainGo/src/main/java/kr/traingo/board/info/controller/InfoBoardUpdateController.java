package kr.traingo.board.info.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

import kr.traingo.board.info.domain.InfoBoardCommand;
import kr.traingo.board.info.service.InfoBoardService;

@Controller
@SessionAttributes("command")
public class InfoBoardUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private InfoBoardService infoBoardService;
	
	@RequestMapping(value="/board/informationBoard/infoupdate.do",method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("num")int num){
		InfoBoardCommand infoBoardCommand = infoBoardService.selectInfoBoard(num);
		return new ModelAndView("infoBoardModify", "command", infoBoardCommand);
	}
	
	@RequestMapping(value="/board/informationBoard/infoupdate.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
						@Valid InfoBoardCommand infoBoardCommand,
						BindingResult result,
						SessionStatus status,
						HttpServletRequest request,
						HttpSession session) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("<<infoBoardCommand>> : " + infoBoardCommand);
		}
		
		String userId = (String)session.getAttribute("userId");
		
		if(!userId.equals(infoBoardCommand.getId())){
			throw new Exception("로그인한 아이디로 작성한 글이 아니기 때문에 수정할 수 없습니다.");
		}
		
		//유효성 체크
		if(result.hasErrors()){
			return "infoBoardModify";
		}
		
		//전송된 파일이 없는 경우
		if(infoBoardCommand.getUpload01().isEmpty()){
			//기존정보 셋팅
			InfoBoardCommand board = infoBoardService.selectInfoBoard(infoBoardCommand.getNum());
			infoBoardCommand.setInfo_image01(board.getInfo_image01());
			infoBoardCommand.setInfo_filename01(board.getInfo_filename01());
		}
		if(infoBoardCommand.getUpload02().isEmpty()){
			//기존정보 셋팅
			InfoBoardCommand board = infoBoardService.selectInfoBoard(infoBoardCommand.getNum());
			infoBoardCommand.setInfo_image02(board.getInfo_image02());
			infoBoardCommand.setInfo_filename02(board.getInfo_filename02());
		}
		if(infoBoardCommand.getUpload03().isEmpty()){
			//기존정보 셋팅
			InfoBoardCommand board = infoBoardService.selectInfoBoard(infoBoardCommand.getNum());
			infoBoardCommand.setInfo_image03(board.getInfo_image03());
			infoBoardCommand.setInfo_filename03(board.getInfo_filename03());
		}
		if(infoBoardCommand.getUpload04().isEmpty()){
			//기존정보 셋팅
			InfoBoardCommand board = infoBoardService.selectInfoBoard(infoBoardCommand.getNum());
			infoBoardCommand.setInfo_image04(board.getInfo_image04());
			infoBoardCommand.setInfo_filename04(board.getInfo_filename04());
		}
		if(infoBoardCommand.getUpload05().isEmpty()){
			//기존정보 셋팅
			InfoBoardCommand board = infoBoardService.selectInfoBoard(infoBoardCommand.getNum());
			infoBoardCommand.setInfo_image05(board.getInfo_image05());
			infoBoardCommand.setInfo_filename05(board.getInfo_filename05());
		}
		if(infoBoardCommand.getUpload06().isEmpty()){
			//기존정보 셋팅
			InfoBoardCommand board = infoBoardService.selectInfoBoard(infoBoardCommand.getNum());
			infoBoardCommand.setInfo_image06(board.getInfo_image06());
			infoBoardCommand.setInfo_filename06(board.getInfo_filename06());
		}
		if(infoBoardCommand.getUpload07().isEmpty()){
			//기존정보 셋팅
			InfoBoardCommand board = infoBoardService.selectInfoBoard(infoBoardCommand.getNum());
			infoBoardCommand.setInfo_image07(board.getInfo_image07());
			infoBoardCommand.setInfo_filename07(board.getInfo_filename07());
		}
		if(infoBoardCommand.getUpload08().isEmpty()){
			//기존정보 셋팅
			InfoBoardCommand board = infoBoardService.selectInfoBoard(infoBoardCommand.getNum());
			infoBoardCommand.setInfo_image08(board.getInfo_image08());
			infoBoardCommand.setInfo_filename08(board.getInfo_filename08());
		}
		if(infoBoardCommand.getUpload09().isEmpty()){
			//기존정보 셋팅
			InfoBoardCommand board = infoBoardService.selectInfoBoard(infoBoardCommand.getNum());
			infoBoardCommand.setInfo_image09(board.getInfo_image09());
			infoBoardCommand.setInfo_filename09(board.getInfo_filename09());
		}
		if(infoBoardCommand.getUpload10().isEmpty()){
			//기존정보 셋팅
			InfoBoardCommand board = infoBoardService.selectInfoBoard(infoBoardCommand.getNum());
			infoBoardCommand.setInfo_image10(board.getInfo_image10());
			infoBoardCommand.setInfo_filename10(board.getInfo_filename10());
		}
				
		//글 수정
		infoBoardService.update(infoBoardCommand);
		status.setComplete();
		
		session = request.getSession();
		session.setAttribute("code", infoBoardCommand.getCode());
		
		return "redirect:/board/informationBoard/infolist.do";
		
	}
}
