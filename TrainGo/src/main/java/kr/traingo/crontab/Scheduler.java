package kr.traingo.crontab;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Service;

import kr.traingo.reserve.domain.CSCommand;
import kr.traingo.reserve.service.ReserveService;
import kr.traingo.table.domain.ResultTimeTableCommand;
import kr.traingo.table.util.UtilAjax;

@Service
public class Scheduler {

	@Resource
	private ReserveService reserveService;	
	
	
	// 2017.04.17 jcb Change - Time Inteval Every Day 21:00
	// @Scheduled(fixedDelay=20000) 
	@Scheduled(cron="0 0 21 * * ?")	
	public void autotrain(){
		
		reserveService.autotrainconfirm();
				
		
		List<ResultTimeTableCommand> list2 = null;
		UtilAjax util2 = new UtilAjax();
		Calendar cal=Calendar.getInstance();
		ResultTimeTableCommand tt=null;
		int count=0;
		int count1=0;

		
		int confirm=0;

		System.out.println(confirm);
		
		
		
		confirm=reserveService.autotrainconfirm();
		
		
		if(confirm==1){
       
		for(int i=0;i<3;i++){ 			


			int year = cal.get(Calendar.YEAR);
			int mon = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DAY_OF_MONTH)+i;          
			String ymd=year+"-"+String.format("%02d", mon)+"-"+String.format("%02d", day);   
			list2 = util2.getTimeTableFromServer("NAT010000","NAT014445", ymd);
			System.out.println(list2.size());

			for(int z=list2.size()-1;z>=0;z--){
				tt=list2.get(z);	


				count=reserveService.ModifyAutoTrain(tt);


				if(count!=0){
					System.out.println("같은 차량이 있어 인덱스 "+z+"번을 포함시키지 않습니다.");

				}else{
					System.out.println(z+"번을 추가합니다");

					reserveService.insertAutoTrain(tt);
				}

			}	

		}

		List<CSCommand> tlist=new ArrayList<CSCommand>();	
		CSCommand train=null;


		tlist=reserveService.gettnum();



		for(int y=tlist.size()-1;y>=0;y--){	
			train=tlist.get(y);
			System.out.println(train.getTrainnum());

			count1=reserveService.ModifyAutoSeats(train.getTrainnum());


			if(count1!=0){
				System.out.println("시트가 있어 인덱스 "+y+"번을 삭제합니다");
				tlist.remove(y);				
			}else{
				System.out.println("시트가 없어"+y+"y번 삭제 안합니다.");
			}

		}  		

		CSCommand seat2=null;


		System.out.println("받은"+tlist.size());

		for(int x=0;x<tlist.size();x++){

			seat2=tlist.get(x);   			


			for(int y=1;y<=240;y++){


				seat2.setSeatnum(y);    				


				System.out.println("추가될 시트넘버"+seat2.getSeatnum());
				System.out.println("추가될 시트 트래인넘버"+seat2.getTrainnum());


				
				
				reserveService.MakeSeat(seat2);    				

			}    		
		}

	}
	}
	
	

	/*@Scheduled(fixedDelay=1000)	
	public void cronTest1(){

	System.out.println("오후 05:50:00에 호출이 됩니다 ");


	} */





	/*	*//** * 2. 오후 05:51:00에 호출이 되는 스케쥴러 *//* 
	@Scheduled(cron = "0 51 17 * * *") 
	public void cronTest2(){ System.out.println("오후 05:51:00에 호출이 됩니다 "); } 
	 */



}