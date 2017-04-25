package kr.traingo.board.info.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.traingo.board.info.domain.InfoBoardCommand;
import kr.traingo.board.info.domain.InfoBoardReplyCommand;

@Transactional
public interface InfoBoardService {
	//ºÎ¸ð±Û
		@Transactional(readOnly=true)
		public List<InfoBoardCommand> infoList(Map<String,Object> map);
		@Transactional(readOnly=true)
		public int getListRowCount(Map<String,Object> map);
		public void insert(InfoBoardCommand infoBoard);
		@Transactional(readOnly=true)
		public InfoBoardCommand selectInfoBoard(Integer num);
		public void updateHit(Integer num);
		public void update(InfoBoardCommand infoBoard);
		public void delete(Integer num);
		
		//´ñ±Û
		@Transactional(readOnly=true)
		public List<InfoBoardReplyCommand> infoListReply(Map<String,Object> map);
		@Transactional(readOnly=true)
		public int getListRowCountReply(Map<String,Object> map);
		public void insertReply(InfoBoardReplyCommand infoBoardReply);
		public void updateReply(InfoBoardReplyCommand infoBoardReply);
		public void deleteReply(Integer re_num);
		
}
