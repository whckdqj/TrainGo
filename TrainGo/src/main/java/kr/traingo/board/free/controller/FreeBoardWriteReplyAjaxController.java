package kr.traingo.board.free.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.traingo.board.free.domain.FreeBoardReplyCommand;
import kr.traingo.board.free.service.FreeBoardService;

@Controller
public class FreeBoardWriteReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/board/freeBoard/freeWriteReplyAjax.do")
	@ResponseBody
	public Map<String,String> process(
			                   FreeBoardReplyCommand freeBoardReplyCommand,
			                   HttpServletRequest request,
			                   HttpSession session){
		String re_ip = request.getRemoteAddr();
		
		if(log.isDebugEnabled()){
			log.debug("<<freeBoardReplyCommand>> : " + freeBoardReplyCommand);
		}
		
		freeBoardReplyCommand.setRe_ip(re_ip);
		
		Map<String,String> map = new HashMap<String,String>();
		
		try{
			String userId = (String)session.getAttribute("userId");
			if(userId==null){
				//·Î±×ÀÎ ¾ÈµÊ
				map.put("result", "logout");
				
			}else{
				//·Î±×ÀÎ µÊ, ´ñ±Û µî·Ï
				freeBoardService.insertReply(freeBoardReplyCommand);
				map.put("result", "success");
			}
		}catch(Exception e){
			log.error(e);
			map.put("result", "failure");
		}
		return map;
	}
}
