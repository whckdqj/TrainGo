package kr.traingo.board.faq.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.traingo.board.faq.domain.FAQBoardCommand;

public interface FAQBoardService {
	@Transactional(readOnly=true)
	public List<FAQBoardCommand> faqList(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getListRowCount(Map<String,Object> map);
	public void insert(FAQBoardCommand faqBoard);
	@Transactional(readOnly=true)
	public FAQBoardCommand selectFAQBoard(Integer num);
	public void update(FAQBoardCommand faqBoard);
	public void delete(Integer num);
}
