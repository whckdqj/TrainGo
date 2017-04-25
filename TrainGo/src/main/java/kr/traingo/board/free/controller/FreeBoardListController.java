package kr.traingo.board.free.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.traingo.board.free.domain.FreeBoardCommand;
import kr.traingo.board.free.service.FreeBoardService;
import kr.traingo.util.PagingUtil;

@Controller
public class FreeBoardListController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/board/freeBoard/freelist.do")
	public ModelAndView process(
			@RequestParam(value="pageNum", defaultValue="1")
			int currentPage,
			@RequestParam(value="keyfield", defaultValue="")
			String keyfield,
			@RequestParam(value="keyword", defaultValue="")
			String keyword){
		
		if(log.isDebugEnabled()){
			log.debug("<<pageNum>> : " + currentPage);
			log.debug("<<keyfield>> : " + keyfield);
			log.debug("<<keyword>> : " + keyword);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//±ÛÀÇ ÃÑ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
		int count = freeBoardService.getListRowCount(map);
		
		if(log.isDebugEnabled()){
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"freelist.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<FreeBoardCommand> freeList = null;
		if(count > 0){
			freeList = freeBoardService.freeList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("freeBoardList");
		mav.addObject("count", count);
		mav.addObject("freeList", freeList);
		mav.addObject("pagingHtml",page.getPagingHtml());
		
		return mav;
	}
}
