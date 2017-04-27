package kr.traingo.reserve.controller;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import kr.traingo.reserve.domain.CSCommand;
import kr.traingo.reserve.domain.CancelCommand;
import kr.traingo.reserve.domain.CostCommand;
import kr.traingo.reserve.domain.RatesCommand;
import kr.traingo.reserve.domain.SeatCommand;
import kr.traingo.reserve.domain.SeatSelectedCommand;
import kr.traingo.reserve.domain.TicketCommand;
import kr.traingo.reserve.domain.TrainCommand;
import kr.traingo.reserve.service.ReserveService;

import kr.traingo.table.domain.ResultTimeTableCommand;
import kr.traingo.table.service.CtyCodeService;
import kr.traingo.table.service.TrainSttnListService;
import kr.traingo.table.util.UtilAjax;
import kr.traingo.util.UtilReserve;



@Controller
@SessionAttributes({"mancount","childrencount","oldcount","costcommand"})
public class ReserveMainController {

	/* private Logger log = Logger.getLogger(this.getClass());    
    @Resource
    private TheService theService;
	 */	


	@Resource
	private ReserveService reserveService;
	@Resource
	private CtyCodeService ctyCodeService;
	@Resource
	private TrainSttnListService trainSttnListService;


	//예매 메뉴로 이동
	// 2017.04.20 16:27 JCB Modify for Mini-Reserve
	@RequestMapping(value="/resv_main.do", method=RequestMethod.GET)
	public ModelAndView trainlist(HttpSession session
	                               , @RequestParam(value="startdate", defaultValue="") String departdate
	                               , @RequestParam(value="depplaceid", defaultValue="") String depStn
	                               , @RequestParam(value="arrplaceid", defaultValue="") String arrStn){
		/* Definition Area */
	    ModelAndView mav=new ModelAndView();
	    Calendar cal=Calendar.getInstance();
		
		List<ResultTimeTableCommand> list2 = null;
        UtilAjax util2 = new UtilAjax();
        ResultTimeTableCommand tt=null;
        
        int count=0;
        int count1=0;       
		
		// Exception Control Routine
		if(departdate.equals("") || departdate==null){
		    mav.setViewName("trainlist");
	        mav.addObject("userId","admin");
		    return mav;
		}
		if(depStn.equals("")||depStn==null){
		    mav.setViewName("trainlist");
	        mav.addObject("userId","admin");
            return mav;
		}
		if(arrStn.equals("")||arrStn==null){
		    mav.setViewName("trainlist");
	        mav.addObject("userId","admin");
            return mav;
		}
        
        
		
		// Create AutoTrain Table
		 //Auto Train Control - START 
        reserveService.deleteAutoTrain();

        // build table with available 
        for(int i=0;i<3;i++){
            int year = cal.get(Calendar.YEAR);
            int mon = cal.get(Calendar.MONTH)+1;
            int day = cal.get(Calendar.DAY_OF_MONTH)+i;
            
            
            // Build Date
            String ymd=year+"-"+String.format("%02d", mon)+"-"+String.format("%02d", day);   
            
            // get real time-table from server
            list2 = util2.getTimeTableFromServer(depStn, arrStn, ymd);
            
            if(list2.isEmpty()||list2==null){
                // No such Train on that Station
                mav.setViewName("redirect:/home.do");
                return mav;
            }
            
            for(int z=list2.size()-1;z>=0;z--){
                // Extract Command-Bean
                tt=list2.get(z);
                count=reserveService.ModifyAutoTrain(tt);
                
                if(count!=0){
                   // System.out.println("같은 차량이 있어 인덱스 "+z+"번을 포함시키지 않습니다.");
                }else{
                   // System.out.println(z+"번을 추가합니다");
                    reserveService.insertAutoTrain(tt);
                }
            }        }
        
        // tlist : TrainNum
        List<CSCommand> tlist=new ArrayList<CSCommand>();
        CSCommand train=null;
        
        // get TrainNum : Primary Key
        tlist=reserveService.gettnum();
        
        for(int y=tlist.size()-1;y>=0;y--){ 
            train=tlist.get(y);
            
            count1=reserveService.ModifyAutoSeats(train.getTrainnum());
            if(count1!=0){
               // System.out.println("시트가 있어 인덱스 "+y+"번을 삭제합니다");
                tlist.remove(y);                
            }else{
               // System.out.println("시트가 없어"+y+"y번 삭제 안합니다.");
            }
        }
        
        CSCommand seat2=null;
        // Build Seat Information
        for(int x=0;x<tlist.size();x++){
            seat2=tlist.get(x);

            for(int y=1;y<=240;y++){
                seat2.setSeatnum(y);                    
                
               

                reserveService.MakeSeat(seat2);
            }
        }
        
        /* Auto Train Control - END */
		
		// Get TrainSeat
		TrainCommand command=new TrainCommand();
		
		// Set Depart Station
		command.setDepartsta(trainSttnListService.selectSttnCodeBySttnCode(depStn).getNodeName());
		// Set Arrive Station
		command.setArrivalsta(trainSttnListService.selectSttnCodeBySttnCode(arrStn).getNodeName());
		// Set Departure Date
		command.setDeparttime(departdate);
		
		// Call Train Seat List
		List<TrainCommand> trainList = reserveService.getTrainList(command);
		
		mav.setViewName("trainlist");				
		mav.addObject("resvList",trainList);

		return mav;
	}

	
	
	

	//트레인정보와 시트 정보를 가져와 줌 
		@RequestMapping("trainseat.do")
		@ResponseBody  
		public Map<String,Object> trainseat(@RequestParam(value="startdate") String departdate,Model model,@RequestParam(value="mancount") int mancount,@RequestParam(value="childrencount") int childrencount,@RequestParam(value="oldcount") int oldcount){

			
			
			
			//지금은 리퀘스트파람만 받지만, 나중에 다른 것을 받게 되니까, 그것까지 다 확인할 수 없는 리퀘스트 파람말고 다른 걸 써보는 것도 생각해봐야할 듯.
			//나중에 고쳐보자.
			//트레인커맨드도 나중에 바꿔보자
			TrainCommand command=new TrainCommand();
	        
	       
	        
	        List<RatesCommand> rlist=reserveService.getrates();        
	                
	        
			command.setDepartsta("서울");
			command.setArrivalsta("부산");
			command.setDeparttime(departdate);		
			
	         
			List<TrainCommand> train=reserveService.getTrainList(command);      	
			Map<String,Object> mapJson =new HashMap<String,Object>();    	
			mapJson.put("list",train);
			
			

			for(int x=0;x<rlist.size();x++){
			     RatesCommand rcommand=rlist.get(x);
			     
			     
			     mapJson.put(rcommand.getType(),rcommand.getRate());
			      
			}
	        
				
					
			model.addAttribute("mancount",mancount);
			model.addAttribute("oldcount",oldcount);
			model.addAttribute("childrencount",childrencount);		
			
			mapJson.put("mancount",mancount);
			mapJson.put("oldcount",oldcount);
			mapJson.put("childrencount",childrencount);	
			


			return mapJson;	 	}   
		
		
		



		@RequestMapping(value="/selectseat.do")
		public ModelAndView SelectSeat(@RequestParam(value="pageNum",defaultValue="1") String pageNum, @RequestParam("trainnum")String trainnum,HttpSession session){
         
			int rowCount=40;	// 한 차량당 좌석수
			int pageCount=10;	// 한 페이지에 보여지는 최대 차량수 
			int currentPage = Integer.parseInt(pageNum);		
			int count =240; //최대 좌석 수..나중에 메소드로 받아서 처리할 수 있게끔 만들어야 함.

			UtilReserve page = new UtilReserve(currentPage, count, rowCount, pageCount, "selectseat.do",trainnum);			
			TrainCommand train=reserveService.getseatinfo(trainnum);		
			CostCommand costcommand=new CostCommand();
			String s=train.getCharge();
			
			
			//코드 정리를 해야할 것 같애
			
			HashMap<String,String> hash=new HashMap<String,String>();
			
			List<RatesCommand> rlist=reserveService.getrates();
			for(int x=0;x<rlist.size();x++){
			     RatesCommand rcommand=rlist.get(x);
			     hash.put(rcommand.getType(),String.valueOf(rcommand.getRate()));		      
			}
				

			int mancost=Integer.parseInt(s.replace(",",""));		
			int oldcount=(Integer)session.getAttribute("oldcount");
			int mancount=(Integer)session.getAttribute("mancount");
			int childrencount=(Integer)session.getAttribute("childrencount");
			
			
			float childrate=Float.parseFloat(hash.get("child"));
			float oldrate=Float.parseFloat(hash.get("old"));
					
			int childcost=(int)Math.ceil((float)mancost*childrate*0.01)*100;		
			int oldcost=(int)Math.ceil((float)mancost*oldrate*0.01)*100;
					
			
			/*int childcost=(int)Math.ceil((float)mancost*0.005)*100;		
			int oldcost=(int)Math.ceil((float)mancost*0.007)*100;*/
			
			
			
			int allcost=mancost*mancount+oldcost*oldcount+childcost*childrencount;		

			costcommand.setMancost(mancost);
			costcommand.setMancount(mancount);
			costcommand.setChildcost(childcost);
			costcommand.setChildrencount(childrencount);;
			costcommand.setOldcost(oldcost);
			costcommand.setOldcount(oldcount);
			costcommand.setAllcost(allcost);		
			
		

			SeatCommand command=new SeatCommand();
			command.setTrainnum(trainnum);
			command.setStart(page.getStartCount());
			command.setEnd(page.getEndCount());

			List<SeatCommand> seatlist=null;			

			seatlist=reserveService.getSeats(command);		

			ModelAndView mav=new ModelAndView();
			mav.setViewName("SelectSeatForm");  
			mav.addObject("train",train);      	 	        	
			mav.addObject("seatlist",seatlist);	        	 
			mav.addObject("pagingHtml",page.getPagingHtml());
			mav.addObject("costcommand",costcommand);          	 	        	

			return mav;		    }    

		@RequestMapping(value="/seatselected.do")
		public String seatselected(@ModelAttribute("costcommand") CostCommand costcommand,
				@ModelAttribute("seatselectedcommand") SeatSelectedCommand command){

					
			StringTokenizer tokens = new StringTokenizer(command.getSeatnums()," ");
			//이거 모델 아트리뷰트로 바꿀 수 있을듯 나중에 바꿔볼 것.    	
			

			int mancount=costcommand.getMancount();
			int oldcount=costcommand.getOldcount();
			int childrencount=costcommand.getChildrencount();
			
			 
			 		 
			
			while(tokens.hasMoreElements()){
				int seatnum= Integer.parseInt(tokens.nextToken());	    	

				if(mancount>0){                 
					
					command.setDiscount("없음");
					command.setCost(costcommand.getMancost());							
						    	
					command.setSeatnum(seatnum);
					
					--mancount;


				}else if(oldcount>0){
					
					
					command.setDiscount("노약자");
					command.setCost(costcommand.getOldcost());
						    	
					command.setSeatnum(seatnum);


	                --oldcount;

				}else if(childrencount>0){
					
					command.setDiscount("어린이");
					command.setCost(costcommand.getChildcost());				
						    	
					command.setSeatnum(seatnum);
	                
					--childrencount;
					

				}
						
				
				reserveService.registerSeat(command);		
				
				
				
				reserveService.registerticket(command);	   

			}    	
			 
        
			return "redirect:/ticketlist.do";

		}	




	
		
		/*@RequestMapping(value="/ticketlist.do")
		public ModelAndView ticketlist(@RequestParam(value="user_id") String booker){


			List<TicketCommand> list=null;
			list=reserveService.getTicketList(booker);		

			ModelAndView mav=new ModelAndView();

			mav.setViewName("TicketListForm");  
			mav.addObject("list",list);      	 	        	

			return mav;			
		}
		
		
				

		@RequestMapping(value="/cancelticket.do")
		public String cancel(@RequestParam(value="id") String id,@RequestParam(value="seatnum") int seatnum, @RequestParam("trainnum")String trainnum){

			CancelCommand command1=new CancelCommand();	    
			TicketCommand command=new TicketCommand();

			command.setId(id);
			command.setSeatnum(seatnum);
			command.setTrainnum(trainnum);       

			//숫자, 스트링 구분해서 들어가는 것 같아서 이렇게 했는데
			//실제로도 구분해서 커맨드가 받는지 확인하고 싶다.


			command1.setBooker(id);
			command1.setSeatnum(seatnum);
			command1.setTrainnum(Integer.parseInt(trainnum));



			reserveService.CancelTicket(command);

			reserveService.CancelSeat(command1);



			return "redirect:/ticketlist.do";


		}*/



	@RequestMapping(value="/autotrainon.do")
	public ModelAndView timeautotrainon(){

		reserveService.autotrainon();       	   

		ModelAndView mav=new ModelAndView();

		int confirm=reserveService.autotrainconfirm();
		mav.setViewName("trainlist");
		mav.addObject("autoseat",confirm);




		return mav;	        	 

	}


	@RequestMapping(value="/autotrain.do")
	public ModelAndView autotrain(){    	

		List<ResultTimeTableCommand> list2 = null;
		UtilAjax util2 = new UtilAjax();
		Calendar cal=Calendar.getInstance();
		ResultTimeTableCommand tt=null;
		int count=0;
		int count1=0;
		//이건 트랜잭션 작업 안해도 됨. 
		reserveService.deleteAutoTrain();		

		for(int i=0;i<3;i++){			
			

			int year = cal.get(Calendar.YEAR);
			int mon = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DAY_OF_MONTH)+i;          
			String ymd=year+"-"+String.format("%02d", mon)+"-"+String.format("%02d", day);   

			
			list2 = util2.getTimeTableFromServer("NAT010000","NAT014445", ymd);

			
			System.out.println(list2.size());		
			
			 //이 부분이 트랜잭션 필요.
			//머지를 사용할 수 있음.
			
			
			for(int z=list2.size()-1;z>=0;z--){
				tt=list2.get(z);					
				
				//삭제 count=reserveService.ModifyAutoTrain(tt);				
						
				System.out.println("insertautotrain을 수정했습니다");
				reserveService.insertAutoTrain(tt);
								
				
			}		}
		
		
		
		
		
		List<CSCommand> tlist=new ArrayList<CSCommand>();	
		CSCommand train=null;
      
	
		tlist=reserveService.gettnum();
		
		
		
		
		//이 부분이 트랜잭션 필요
		for(int y=tlist.size()-1;y>=0;y--){	
			train=tlist.get(y);
			
			count1=reserveService.ModifyAutoSeats(train.getTrainnum());


			if(count1!=0){
				System.out.println("시트가 있어 인덱스 "+y+"번을 삭제합니다");
				tlist.remove(y);				
			}else{
				System.out.println("시트가 없어"+y+"y번 삭제 안합니다.");
			}

		}
		
		
		
		
		
		

		CSCommand seat2=null;
		//List<CSCommand> tlist3=new ArrayList<CSCommand>();	

		System.out.println("받은"+tlist.size());

		for(int x=0;x<tlist.size();x++){
			seat2=tlist.get(x);   		


			for(int y=1;y<=240;y++){


				seat2.setSeatnum(y);    				

				System.out.println("추가될 시트넘버"+seat2.getSeatnum());
				System.out.println("추가될 시트 트래인넘버"+seat2.getTrainnum());

				//tlist3.add(seat2);

				reserveService.MakeSeat(seat2);


			}

		}

		//위에까지는 잘 돼 아래만 잘되면 됨
		//안되면 이거 문제임

		// reserveService.MakeSeat(tlist3);




		ModelAndView mav=new ModelAndView();

		//그리고 이건 티켓리스트 폼이 아니지.
		mav.setViewName("trainlist");




		return mav;

	}
	


	@RequestMapping(value="/autotrainoff.do")
	public ModelAndView timeautotrainoff(){

		reserveService.autotrainoff();       	   

		ModelAndView mav=new ModelAndView();

		int confirm=reserveService.autotrainconfirm();
		mav.setViewName("trainlist");  
		mav.addObject("autoseat",confirm);  		 




		return mav;	        	 

	}











































}










