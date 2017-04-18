package kr.traingo.board.info.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.traingo.board.info.domain.InfoBoardReplyCommand;
import kr.traingo.board.info.service.InfoBoardService;

@Controller
public class InfoBoardUpdateReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private InfoBoardService infoBoardService;
	
	@RequestMapping("/board/informationBoard/infoUpdateReplyAjax.do")
	@ResponseBody
	public Map<String,String> process(
						InfoBoardReplyCommand infoBoardReplyCommand,
						HttpSession session){
		Map<String,String> map = new HashMap<String,String>();
		if(log.isDebugEnabled()){
			log.debug("<<infoBoardReplyCommand>> : " + infoBoardReplyCommand);
		}
		
		try{
			String userId = (String)session.getAttribute("userId");
			if(userId==null){
				map.put("result", "logout");
				
			}else if(userId!=null && userId.equals(infoBoardReplyCommand.getId())){
				//´ñ±Û ¼öÁ¤
				infoBoardService.updateReply(infoBoardReplyCommand);
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
