package kr.traingo.board.free.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.traingo.board.free.dao.FreeBoardMapper;
import kr.traingo.board.free.domain.FreeBoardCommand;
import kr.traingo.board.free.domain.FreeBoardReplyCommand;

@Service("freeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService{
	
	@Resource
	private FreeBoardMapper freeBoardMapper;
	
	@Override
	public List<FreeBoardCommand> freeList(Map<String, Object> map) {
		return freeBoardMapper.freeList(map);
	}

	@Override
	public int getListRowCount(Map<String, Object> map) {
		return freeBoardMapper.getListRowCount(map);
	}

	@Override
	public void insert(FreeBoardCommand freeBoard) {
		freeBoardMapper.insert(freeBoard);
	}

	@Override
	public FreeBoardCommand selectFreeBoard(Integer num) {
		return freeBoardMapper.selectFreeBoard(num);
	}

	@Override
	public void updateHit(Integer num) {
		freeBoardMapper.updateHit(num);
	}

	@Override
	public void update(FreeBoardCommand freeBoard) {
		freeBoardMapper.update(freeBoard);
	}

	@Override
	public void delete(Integer num) {
		//댓글의 댓글이 존재하면 우선 삭제
		//infoBoardMapper.deleteReReplyByNum(num);
		//댓글이 존재하면 댓글을 우선 삭제하고 부모글 삭제
		freeBoardMapper.deleteReplyByNum(num);
		//부모글 삭제
		freeBoardMapper.delete(num);
	}

	@Override
	public List<FreeBoardReplyCommand> freeListReply(Map<String, Object> map) {
		return freeBoardMapper.freeListReply(map);
	}

	@Override
	public int getListRowCountReply(Map<String, Object> map) {
		return freeBoardMapper.getListRowCountReply(map);
	}

	@Override
	public void insertReply(FreeBoardReplyCommand freeBoardReply) {
		freeBoardMapper.insertReply(freeBoardReply);
	}

	@Override
	public void updateReply(FreeBoardReplyCommand freeBoardReply) {
		freeBoardMapper.updateReply(freeBoardReply);
	}

	@Override
	public void deleteReply(Integer re_num) {
		freeBoardMapper.deleteReply(re_num);
	}


}
