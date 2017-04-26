package kr.traingo.ticketlist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import kr.traingo.reserve.domain.CancelCommand;
import kr.traingo.ticketlist.domain.TicketListCommand;
import kr.traingo.ticketlist.service.TicketListService;

@Controller
public class TicketListDetailController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private TicketListService ticketListService;
	
	@RequestMapping(value="/ticketlist.do",method=RequestMethod.GET)
	public ModelAndView process(HttpSession session	){
		String id = (String)session.getAttribute("userId");
		String cancel;
		cancel="cancelP";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("cancel",cancel);
		int count = ticketListService.getRowCountReply(map);
		if(log.isDebugEnabled()){
			log.debug("<<count>> : " + count);
		}
		List<TicketListCommand> list =null;
		if(count >0){
		 list = ticketListService.ticketlist(map);
		 
		}
		cancel="cancel";
		map.put("cancel",cancel);
		count = ticketListService.getRowCountReply(map);
		List<TicketListCommand> list2 =null;
		if(count >0){
			 list2 = ticketListService.ticketlist(map);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ticketView");
		mav.addObject("list",list);
		mav.addObject("list2",list2);
		mav.addObject("id",id);
		return mav;
	}
	
	@RequestMapping(value="/ticketlist.do",method=RequestMethod.POST )
	public String submit(@ModelAttribute("command")
    @Valid TicketListCommand command,HttpSession session){
		String id = (String)session.getAttribute("userId");
		CancelCommand command3 = new CancelCommand();
		TicketListCommand command2 = ticketListService.ticketCancel(command.getId(), command.getTicketnum(), command.getTrainnum());
		
		command3.setBooker(id);
		command3.setSeatnum(command.getSeatnum());
		command3.setTrainnum(command.getTrainnum());
		command2.setCancel("cancelP");
		ticketListService.update(command2);
	
		return "redirect:/ticketlist.do";
	}
	//처음으로 버튼 눌렀을때 발생하는 이벤트
	@RequestMapping(value="/reserveF.do",method=RequestMethod.POST )
    public String reserveF(@ModelAttribute("command") @Valid TicketListCommand command){
        ticketListService.deleteTicket(command.getId(), command.getTicketnum(), command.getTrainnum());
	    
	    return "redirect:/resv_main.do";
    }
	//취소버튼을 눌렀을때 발생하는 이벤트
	@RequestMapping(value="/cancel.do",method=RequestMethod.POST )
	public ModelAndView submit2(@ModelAttribute("command")
    @Valid TicketListCommand command){
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("id" ,command.getId());
		System.out.println(command.getId());
		mav.addObject("trainnum",command.getTrainnum());
		mav.addObject("ticketnum",command.getTicketnum());
		mav.addObject("seatnum",command.getSeatnum());
		mav.setViewName("cancel");
		
		return mav;
	}
	
	//취소 확인 페이지
	@RequestMapping(value="/cancelConfirm.do")
	public String submit3(@RequestParam(value="id") String id,@RequestParam(value="seatnum") int seatnum, @RequestParam("ticketnum")int ticketnum, @RequestParam("trainnum")int trainnum){
		TicketListCommand command2 = ticketListService.ticketCancel(id, ticketnum, trainnum);
		CancelCommand command = new CancelCommand();
		command2.setCancel("cancel");
		ticketListService.update(command2);
		
		command.setBooker("");
		command.setSeatnum(seatnum);
		command.setTrainnum(trainnum);
		ticketListService.CancelSeat(command);
		return "redirect:/ticketlist.do";
	}
}
