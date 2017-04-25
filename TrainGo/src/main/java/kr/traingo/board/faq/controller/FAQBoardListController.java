package kr.traingo.board.faq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.traingo.board.faq.domain.FAQBoardCommand;
import kr.traingo.board.faq.service.FAQBoardService;
import kr.traingo.util.PagingUtil;

@Controller
public class FAQBoardListController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private FAQBoardService faqBoardService;
	
	@RequestMapping("/board/faqBoard/faqlist.do")
	public ModelAndView process(
			@RequestParam(value="pageNum", defaultValue="1")
			int currentPage,
			@RequestParam(value="keyfield", defaultValue="")
			String keyfield,
			@RequestParam(value="keyword", defaultValue="")
			String keyword,
			HttpServletRequest request){
		
		if(log.isDebugEnabled()){
			log.debug("<<pageNum>> : " + currentPage);
			log.debug("<<keyfield>> : " + keyfield);
			log.debug("<<keyword>> : " + keyword);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//System.out.println(faqBoardService.getListRowCount(map));
		
		int count = faqBoardService.getListRowCount(map);
		
		if(log.isDebugEnabled()){
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"faqlist.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<FAQBoardCommand> faqList = null;
		if(count > 0){
			faqList = faqBoardService.faqList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("faqBoardList");
		mav.addObject("count", count);
		mav.addObject("faqList", faqList);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
	
}
