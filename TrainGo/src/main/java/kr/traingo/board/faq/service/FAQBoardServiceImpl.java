package kr.traingo.board.faq.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.traingo.board.faq.dao.FAQBoardMapper;
import kr.traingo.board.faq.domain.FAQBoardCommand;


@Service("faqBoardService")
public class FAQBoardServiceImpl implements FAQBoardService{

	@Resource
	private FAQBoardMapper faqBoardMapper;
	
	@Override
	public List<FAQBoardCommand> faqList(Map<String, Object> map) {
		return faqBoardMapper.faqList(map);
	}

	@Override
	public int getListRowCount(Map<String, Object> map) {
		return faqBoardMapper.getListRowCount(map);
	}

	@Override
	public void insert(FAQBoardCommand faqBoard) {
		faqBoardMapper.insert(faqBoard);
	}

	@Override
	public FAQBoardCommand selectFAQBoard(Integer num) {
		return faqBoardMapper.selectFAQBoard(num);
	}

	@Override
	public void update(FAQBoardCommand faqBoard) {
		faqBoardMapper.update(faqBoard);
	}

	@Override
	public void delete(Integer num) {
		faqBoardMapper.delete(num);
	}

}
