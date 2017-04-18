package kr.traingo.board.info.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.traingo.board.info.domain.InfoBoardReplyCommand;
import kr.traingo.board.info.service.InfoBoardService;
import kr.traingo.util.PagingUtil;

@Controller
public class InfoBoardListReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private InfoBoardService infoBoardService;
	
	@RequestMapping("/board/informationBoard/infoListReplyAjax.do")
	@ResponseBody
	public Map<String,Object> process(
			@RequestParam(value="pageNum", defaultValue="1")
			int currentPage,
			@RequestParam("num") int num){
		
		if(log.isDebugEnabled()){
			log.debug("<<currentPage>> : " + currentPage);
			log.debug("<<num>> : " + num);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("num", num);
		
		//ÃÑ ±ÛÀÇ °¹¼ö
		int count = infoBoardService.getListRowCountReply(map);
		PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,null);
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<InfoBoardReplyCommand> list = null;
		if(count > 0){
			list = infoBoardService.infoListReply(map);
		}else{
			list = Collections.emptyList();
		}
		
		Map<String,Object> mapJson = new HashMap<String,Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("list", list);
		return mapJson;		
		
	}
	
}
