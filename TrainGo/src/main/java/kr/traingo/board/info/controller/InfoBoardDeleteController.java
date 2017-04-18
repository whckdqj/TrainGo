package kr.traingo.board.info.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import kr.traingo.board.info.domain.InfoBoardCommand;
import kr.traingo.board.info.service.InfoBoardService;

@Controller
public class InfoBoardDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private InfoBoardService infoBoardService;
	
	@RequestMapping("/board/informationBoard/infodelete.do")
	public String submit(@RequestParam("num")int num,
						 SessionStatus status,
						 HttpServletRequest request,
			             HttpSession session) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("<<num>> : " + num);
		}
		
		InfoBoardCommand infoBoardCommand = infoBoardService.selectInfoBoard(num);
		
		String userId = (String)session.getAttribute("userId");
		
		if(!userId.equals(infoBoardCommand.getId())){
			throw new Exception("�α����� ���̵�� �ۼ��� ���� �ƴϱ⶧���� ������ �� �����ϴ�.");
		}
		
		//�� ����
		infoBoardService.delete(infoBoardCommand.getNum());
		status.setComplete();
		
		session = request.getSession();
		session.setAttribute("code", infoBoardCommand.getCode());
		
		
		return "redirect:/board/informationBoard/infolist.do";
	}
	
	
	
	
}
