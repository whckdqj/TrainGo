package kr.traingo.board.info.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.traingo.board.info.service.InfoBoardService;

@Controller
public class InfoBoardDeleteReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private InfoBoardService infoBoardService;
	
	@RequestMapping("/board/informationBoard/infoDeleteReplyAjax.do")
	@ResponseBody
	public Map<String,String> process(@RequestParam("re_num") int re_num,
			                          @RequestParam("id") String id,
			                          HttpSession session){
		
		if(log.isDebugEnabled()){
			log.debug("<<re_num>> : " + re_num);
			log.debug("<<id>> : " + id);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		try{
			String userId = (String)session.getAttribute("userId");
			if(userId==null){
				map.put("result", "logout");
			}else if(userId!=null && userId.equals(id)){
				//¥Ò±€ ªË¡¶
				infoBoardService.deleteReply(re_num);
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
