package kr.traingo.board.info.controller;

import javax.annotation.Resource;
/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;*/

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.traingo.board.info.domain.InfoBoardCommand;
import kr.traingo.board.info.service.InfoBoardService;

@Controller
public class InfoBoardDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private InfoBoardService infoBoardService;
	
	
	@RequestMapping("/board/informationBoard/infodetail.do")
	public ModelAndView process(@RequestParam("num")int num){
		
		if(log.isDebugEnabled()){
			log.debug("<<num>> : " + num);
		}
		
		//해당 글 조회수 증가
		infoBoardService.updateHit(num);
		
		InfoBoardCommand infoBoardCommand = infoBoardService.selectInfoBoard(num);
		
		return new ModelAndView("infoBoardView","infoBoardCommand",infoBoardCommand);
	}
	
	//파일 다운로드
	
	@RequestMapping("/board/informationBoard/infofile.do")
	public ModelAndView download(@RequestParam("num")int num, @RequestParam("imageNum") int imageNum){
		
		InfoBoardCommand infoBoardCommand = infoBoardService.selectInfoBoard(num);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("downloadView");
		if(imageNum == 1){
			mav.addObject("downloadFile", infoBoardCommand.getInfo_image01());
			mav.addObject("filename", infoBoardCommand.getInfo_filename01());
		}else if(imageNum == 2){
			mav.addObject("downloadFile", infoBoardCommand.getInfo_image02());
			mav.addObject("filename", infoBoardCommand.getInfo_filename02());
		}else if(imageNum == 3){
			mav.addObject("downloadFile", infoBoardCommand.getInfo_image03());
			mav.addObject("filename", infoBoardCommand.getInfo_filename03());
		}else if(imageNum == 4){
			mav.addObject("downloadFile", infoBoardCommand.getInfo_image04());
			mav.addObject("filename", infoBoardCommand.getInfo_filename04());
		}else if(imageNum == 5){
			mav.addObject("downloadFile", infoBoardCommand.getInfo_image05());
			mav.addObject("filename", infoBoardCommand.getInfo_filename05());
		}else if(imageNum == 6){
			mav.addObject("downloadFile", infoBoardCommand.getInfo_image06());
			mav.addObject("filename", infoBoardCommand.getInfo_filename06());
		}else if(imageNum == 7){
			mav.addObject("downloadFile", infoBoardCommand.getInfo_image07());
			mav.addObject("filename", infoBoardCommand.getInfo_filename07());
		}else if(imageNum == 8){
			mav.addObject("downloadFile", infoBoardCommand.getInfo_image08());
			mav.addObject("filename", infoBoardCommand.getInfo_filename08());
		}else if(imageNum == 9){
			mav.addObject("downloadFile", infoBoardCommand.getInfo_image09());
			mav.addObject("filename", infoBoardCommand.getInfo_filename09());
		}else if(imageNum == 10){
			mav.addObject("downloadFile", infoBoardCommand.getInfo_image10());
			mav.addObject("filename", infoBoardCommand.getInfo_filename10());
		}

		return mav;
	}
	
	//이미지 출력
	@RequestMapping("/board/informationBoard/infoimageview.do")
	public ModelAndView viewImage(@RequestParam("num")int num, @RequestParam("imageNum") int imageNum){
		
		InfoBoardCommand infoBoardCommand = infoBoardService.selectInfoBoard(num);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("imageView");
		if(imageNum == 1){
			mav.addObject("imageFile", infoBoardCommand.getInfo_image01());
			mav.addObject("filename", infoBoardCommand.getInfo_filename01());
		}else if(imageNum == 2){
			mav.addObject("imageFile", infoBoardCommand.getInfo_image02());
			mav.addObject("filename", infoBoardCommand.getInfo_filename02());
		}else if(imageNum == 3){
			mav.addObject("imageFile", infoBoardCommand.getInfo_image03());
			mav.addObject("filename", infoBoardCommand.getInfo_filename03());
		}else if(imageNum == 4){
			mav.addObject("imageFile", infoBoardCommand.getInfo_image04());
			mav.addObject("filename", infoBoardCommand.getInfo_filename04());
		}else if(imageNum == 5){
			mav.addObject("imageFile", infoBoardCommand.getInfo_image05());
			mav.addObject("filename", infoBoardCommand.getInfo_filename05());
		}else if(imageNum == 6){
			mav.addObject("imageFile", infoBoardCommand.getInfo_image06());
			mav.addObject("filename", infoBoardCommand.getInfo_filename06());
		}else if(imageNum == 7){
			mav.addObject("imageFile", infoBoardCommand.getInfo_image07());
			mav.addObject("filename", infoBoardCommand.getInfo_filename07());
		}else if(imageNum == 8){
			mav.addObject("imageFile", infoBoardCommand.getInfo_image08());
			mav.addObject("filename", infoBoardCommand.getInfo_filename08());
		}else if(imageNum == 9){
			mav.addObject("imageFile", infoBoardCommand.getInfo_image09());
			mav.addObject("filename", infoBoardCommand.getInfo_filename09());
		}else if(imageNum == 10){
			mav.addObject("imageFile", infoBoardCommand.getInfo_image10());
			mav.addObject("filename", infoBoardCommand.getInfo_filename10());
		}
		return mav;
	}
	
}
