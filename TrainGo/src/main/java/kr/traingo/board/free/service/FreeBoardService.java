package kr.traingo.board.free.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.traingo.board.free.domain.FreeBoardCommand;
import kr.traingo.board.free.domain.FreeBoardReplyCommand;

@Transactional
public interface FreeBoardService {
	//ºÎ¸ð±Û
	@Transactional(readOnly=true)
	public List<FreeBoardCommand> freeList(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getListRowCount(Map<String,Object> map);
	public void insert(FreeBoardCommand freeBoard);
	@Transactional(readOnly=true)
	public FreeBoardCommand selectFreeBoard(Integer num);
	public void updateHit(Integer num);
	public void update(FreeBoardCommand freeBoard);
	public void delete(Integer num);

	//´ñ±Û
	@Transactional(readOnly=true)
	public List<FreeBoardReplyCommand> freeListReply(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getListRowCountReply(Map<String,Object> map);
	public void insertReply(FreeBoardReplyCommand freeBoardReply);
	public void updateReply(FreeBoardReplyCommand freeBoardReply);
	public void deleteReply(Integer re_num);

}
