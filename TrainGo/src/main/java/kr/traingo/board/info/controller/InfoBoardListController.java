package kr.traingo.board.info.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.traingo.board.info.domain.InfoBoardCommand;
import kr.traingo.board.info.service.InfoBoardService;
import kr.traingo.util.PagingUtil;

@Controller
public class InfoBoardListController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private InfoBoardService infoBoardService;
	
	@RequestMapping("/board/informationBoard/infolist.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1")
					            int currentPage,
					            @RequestParam(value="keyfield", defaultValue="")
								String keyfield,
								@RequestParam(value="keyword", defaultValue="")
	                            String keyword,
	                            @RequestParam(value="code", defaultValue="3")
								int serviceCode,
								HttpServletRequest request){
		HttpSession session = request.getSession();
		//아래 통합시 제거
		session.setAttribute("userId", "admin");
		//윗글 통합시 제거
		if(log.isDebugEnabled()){
			log.debug("<<pageNum>> : " + currentPage);
			log.debug("<<keyfield>> : " + keyfield);
			log.debug("<<keyword>> : " + keyword);
			if(session.getAttribute("code")!=null){
				log.debug("<<code>> : " + session.getAttribute("code"));
				session.invalidate();
			}else{
				log.debug("<<code>> : " + serviceCode);
			}
		}
		
		/*if(session.getAttribute("code")!=null){
			System.out.println(session.getAttribute("code"));
		}*/
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		if(session.getAttribute("code")!=null){
			serviceCode = Integer.parseInt(String.valueOf(session.getAttribute("code")));
			map.put("code", serviceCode);
			//session.invalidate();
		}else{
			map.put("code", serviceCode);
		}
		//글의 총 갯수 또는 검색된 글의 갯수
		
		int count = infoBoardService.getListRowCount(map);
		
		if(log.isDebugEnabled()){
			log.debug("<<count>> : " + count);
		}
		
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"infolist.do","&code="+serviceCode);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<InfoBoardCommand> infoList = null;
		if(count>0){
			infoList = infoBoardService.infoList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("infoBoardList");
		mav.addObject("count", count);
		mav.addObject("infoList", infoList);
		if(session.getAttribute("code")!=null){
			serviceCode = Integer.parseInt(String.valueOf(session.getAttribute("code")));
			mav.addObject("code", serviceCode);
			session.invalidate();
		}else{
			mav.addObject("code", serviceCode);
		}
		mav.addObject("pagingHtml", page.getPagingHtml());
		return mav;
	}
	
}
