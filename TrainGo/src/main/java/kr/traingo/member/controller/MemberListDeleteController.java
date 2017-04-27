package kr.traingo.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.traingo.member.service.MemberService;

@Controller
public class MemberListDeleteController {
	@Resource
	private MemberService memberService;
	// JCB Change for PrevPage
	@RequestMapping("/member/deleteList.do")
	public String form(HttpServletRequest request){
	    String referer = request.getHeader("Referer");
	    request.getSession().setAttribute("prevPage", referer);
		return "deleteForm";
	}
	
	@RequestMapping("/member/deleteListPro.do")
	public String process(@RequestParam("id")String id, HttpServletRequest request){
		
	    String referer = request.getHeader("Referer");
        request.getSession().setAttribute("prevPage", referer);
        
		memberService.deleteMember(id);
		
		return "redirect:/list.do";
	}
}
