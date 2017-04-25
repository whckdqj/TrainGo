package kr.traingo.board.free.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import kr.traingo.board.free.domain.FreeBoardCommand;
import kr.traingo.board.free.service.FreeBoardService;

@Controller
public class FreeBoardDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/board/freeBoard/freedelete.do")
	public String submit(@RequestParam("num")int num,
			SessionStatus status,
			HttpSession session) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("<<num>> : " + num);
		}
		
		FreeBoardCommand freeBoardCommand = freeBoardService.selectFreeBoard(num);
		
		String userId = (String)session.getAttribute("userId");
		
		if(!userId.equals(freeBoardCommand.getId())){
			throw new Exception("�α����� ���̵�� �ۼ��� ���� �ƴϱ⶧���� ������ �� �����ϴ�.");
		}
		
		//�� ����
		freeBoardService.delete(freeBoardCommand.getNum());
		status.setComplete();
		
		return "redirect:/board/freeBoard/freelist.do";
	}
}
