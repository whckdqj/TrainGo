package kr.traingo.board.free.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.traingo.board.free.domain.FreeBoardReplyCommand;
import kr.traingo.board.free.service.FreeBoardService;

@Controller
public class FreeBoardUpdateReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private FreeBoardService freeBoardService;
	@RequestMapping("/board/freeBoard/freeUpdateReplyAjax.do")
	@ResponseBody
	public Map<String,String> process(
					FreeBoardReplyCommand freeBoardReplyCommand,
					HttpSession session){
		Map<String,String> map = new HashMap<String,String>();
		if(log.isDebugEnabled()){
			log.debug("<<freeBoardReplyCommand>> : " + freeBoardReplyCommand);
		}
		
		try{
			String userId = (String)session.getAttribute("userId");
			if(userId==null){
				map.put("result", "logout");
				
			}else if(userId!=null && userId.equals(freeBoardReplyCommand.getId())){
				//´ñ±Û ¼öÁ¤
				freeBoardService.updateReply(freeBoardReplyCommand);
				map.put("result", "success");
			}else{
				map.put("result", "wrongAccess");
			}
		}catch(Exception e){
			log.error(e);
			map.put("result", "failure");
		}
		return map;
	}
}
