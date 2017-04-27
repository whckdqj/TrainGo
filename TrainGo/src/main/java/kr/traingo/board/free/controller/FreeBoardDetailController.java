package kr.traingo.board.free.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.traingo.board.free.domain.FreeBoardCommand;
import kr.traingo.board.free.service.FreeBoardService;

@Controller
public class FreeBoardDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/board/freeBoard/freedetail.do")
	public ModelAndView process(@RequestParam("num")int num){
		
		if(log.isDebugEnabled()){
			log.debug("<<num>> : " + num);
		}
		
		freeBoardService.updateHit(num);
		
		FreeBoardCommand freeBoardCommand = freeBoardService.selectFreeBoard(num);
		
		return new ModelAndView("freeBoardView", "freeBoardCommand",freeBoardCommand);
	}
	
	//파일 다운로드
	
	@RequestMapping("/board/freeBoard/freefile.do")
	public ModelAndView download(@RequestParam("num")int num, @RequestParam("imageNum") int imageNum){
		
		FreeBoardCommand freeBoardCommand = freeBoardService.selectFreeBoard(num);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("downloadView");
		
		if(imageNum == 1){
			mav.addObject("downloadFile", freeBoardCommand.getFree_image01());
			mav.addObject("filename", freeBoardCommand.getFree_filename01());
		}else if(imageNum == 2){
			mav.addObject("downloadFile", freeBoardCommand.getFree_image02());
			mav.addObject("filename", freeBoardCommand.getFree_filename02());
		}else if(imageNum == 3){
			mav.addObject("downloadFile", freeBoardCommand.getFree_image03());
			mav.addObject("filename", freeBoardCommand.getFree_filename03());
		}else if(imageNum == 4){
			mav.addObject("downloadFile", freeBoardCommand.getFree_image04());
			mav.addObject("filename", freeBoardCommand.getFree_filename04());
		}else if(imageNum == 5){
			mav.addObject("downloadFile", freeBoardCommand.getFree_image05());
			mav.addObject("filename", freeBoardCommand.getFree_filename05());
		}else if(imageNum == 6){
			mav.addObject("downloadFile", freeBoardCommand.getFree_image06());
			mav.addObject("filename", freeBoardCommand.getFree_filename06());
		}else if(imageNum == 7){
			mav.addObject("downloadFile", freeBoardCommand.getFree_image07());
			mav.addObject("filename", freeBoardCommand.getFree_filename07());
		}else if(imageNum == 8){
			mav.addObject("downloadFile", freeBoardCommand.getFree_image08());
			mav.addObject("filename", freeBoardCommand.getFree_filename08());
		}else if(imageNum == 9){
			mav.addObject("downloadFile", freeBoardCommand.getFree_image09());
			mav.addObject("filename", freeBoardCommand.getFree_filename09());
		}else if(imageNum == 10){
			mav.addObject("downloadFile", freeBoardCommand.getFree_image10());
			mav.addObject("filename", freeBoardCommand.getFree_filename10());
		}
		
		return mav;
	}
	
	//이미지 출력
	
	@RequestMapping("/board/freeBoard/freeimageview.do")
	public ModelAndView viewImage(@RequestParam("num")int num, @RequestParam("imageNum") int imageNum){
		
		FreeBoardCommand freeBoardCommand = freeBoardService.selectFreeBoard(num);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("imageView");
		if(imageNum == 1){
			mav.addObject("imageFile", freeBoardCommand.getFree_image01());
			mav.addObject("filename", freeBoardCommand.getFree_filename01());
		}else if(imageNum == 2){
			mav.addObject("imageFile", freeBoardCommand.getFree_image02());
			mav.addObject("filename", freeBoardCommand.getFree_filename02());
		}else if(imageNum == 3){
			mav.addObject("imageFile", freeBoardCommand.getFree_image03());
			mav.addObject("filename", freeBoardCommand.getFree_filename03());
		}else if(imageNum == 4){
			mav.addObject("imageFile", freeBoardCommand.getFree_image04());
			mav.addObject("filename", freeBoardCommand.getFree_filename04());
		}else if(imageNum == 5){
			mav.addObject("imageFile", freeBoardCommand.getFree_image05());
			mav.addObject("filename", freeBoardCommand.getFree_filename05());
		}else if(imageNum == 6){
			mav.addObject("imageFile", freeBoardCommand.getFree_image06());
			mav.addObject("filename", freeBoardCommand.getFree_filename06());
		}else if(imageNum == 7){
			mav.addObject("imageFile", freeBoardCommand.getFree_image07());
			mav.addObject("filename", freeBoardCommand.getFree_filename07());
		}else if(imageNum == 8){
			mav.addObject("imageFile", freeBoardCommand.getFree_image08());
			mav.addObject("filename", freeBoardCommand.getFree_filename08());
		}else if(imageNum == 9){
			mav.addObject("imageFile", freeBoardCommand.getFree_image09());
			mav.addObject("filename", freeBoardCommand.getFree_filename09());
		}else if(imageNum == 10){
			mav.addObject("imageFile", freeBoardCommand.getFree_image10());
			mav.addObject("filename", freeBoardCommand.getFree_filename10());
		}
		return mav;
	}
	
}
