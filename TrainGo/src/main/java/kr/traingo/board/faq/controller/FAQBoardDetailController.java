package kr.traingo.board.faq.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.traingo.board.faq.domain.FAQBoardCommand;
import kr.traingo.board.faq.service.FAQBoardService;

@Controller
public class FAQBoardDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private FAQBoardService faqBoardService;
	
	@RequestMapping("/board/faqBoard/faqdetail.do")
	public ModelAndView process(@RequestParam("num")int num){
		
		if(log.isDebugEnabled()){
			log.debug("<num>> : " + num);
		}
		
		FAQBoardCommand faqBoardCommand = faqBoardService.selectFAQBoard(num);
		
		return new ModelAndView("faqBoardView", "faqBoardCommand", faqBoardCommand);
		
	}
	
	//파일 다운로드
	
	@RequestMapping("/board/faqBoard/faqfile.do")
	public ModelAndView download(@RequestParam("num")int num, @RequestParam("imageNum") int imageNum){
		
		FAQBoardCommand faqBoardCommand = faqBoardService.selectFAQBoard(num);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("downloadView");
		if(imageNum == 1){
			mav.addObject("downloadFile", faqBoardCommand.getFaq_image01());
			mav.addObject("filename", faqBoardCommand.getFaq_filename01());
		}else if(imageNum == 2){
			mav.addObject("downloadFile", faqBoardCommand.getFaq_image02());
			mav.addObject("filename", faqBoardCommand.getFaq_filename02());
		}else if(imageNum == 3){
			mav.addObject("downloadFile", faqBoardCommand.getFaq_image03());
			mav.addObject("filename", faqBoardCommand.getFaq_filename03());
		}else if(imageNum == 4){
			mav.addObject("downloadFile", faqBoardCommand.getFaq_image04());
			mav.addObject("filename", faqBoardCommand.getFaq_filename04());
		}
		return mav;
	}
	//이미지 출력
	@RequestMapping("/board/faqBoard/faqimageview.do")
	public ModelAndView viewImage(@RequestParam("num")int num, @RequestParam("imageNum") int imageNum){
		
		FAQBoardCommand faqBoardCommand = faqBoardService.selectFAQBoard(num);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("imageView");
		if(imageNum == 1){
			mav.addObject("imageFile", faqBoardCommand.getFaq_image01());
			mav.addObject("filename", faqBoardCommand.getFaq_filename01());
		}else if(imageNum == 2){
			mav.addObject("imageFile", faqBoardCommand.getFaq_image02());
			mav.addObject("filename", faqBoardCommand.getFaq_filename02());
		}else if(imageNum == 3){
			mav.addObject("imageFile", faqBoardCommand.getFaq_image03());
			mav.addObject("filename", faqBoardCommand.getFaq_filename03());
		}else if(imageNum == 4){
			mav.addObject("imageFile", faqBoardCommand.getFaq_image04());
			mav.addObject("filename", faqBoardCommand.getFaq_filename04());
		}
		return mav;
	}
}
