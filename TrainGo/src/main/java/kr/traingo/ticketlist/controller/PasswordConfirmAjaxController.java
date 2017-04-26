package kr.traingo.ticketlist.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.traingo.domain.TheCommand;
import kr.traingo.member.domain.MemberCommand;
import kr.traingo.member.service.MemberService;

@Controller
public class PasswordConfirmAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/passwdConfirm.do")
	@ResponseBody
	public Map<String, String> process(@RequestParam("id")String id,@RequestParam("passwd")String passwd){
		System.out.println(id+passwd);
		if(log.isDebugEnabled()){
			
		}
		boolean check;
		Map<String, String> map = new HashMap<String, String>();
		try{
		    MemberCommand command = memberService.getMember(id);
			System.out.println(command);
			check= command.isCheckedPasswd(passwd);
			if(check == true){
				map.put("result", "correct");
			}else if(check ==false){
				map.put("result", "incorrect");
			}
			 
		}catch(Exception e){
			log.error(e);
			map.put("result", "failure");
		}
		
		return map;
	}
}
