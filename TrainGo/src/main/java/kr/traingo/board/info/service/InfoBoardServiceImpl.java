package kr.traingo.board.info.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.traingo.board.info.dao.InfoBoardMapper;
import kr.traingo.board.info.domain.InfoBoardCommand;
import kr.traingo.board.info.domain.InfoBoardReReplyCommand;
import kr.traingo.board.info.domain.InfoBoardReplyCommand;

@Service("infoBoardService")
public class InfoBoardServiceImpl implements InfoBoardService {

	@Resource
	private InfoBoardMapper infoBoardMapper;
	
	@Override
	public List<InfoBoardCommand> infoList(Map<String, Object> map) {
		return infoBoardMapper.infoList(map);
	}

	@Override
	public int getListRowCount(Map<String, Object> map) {
		return infoBoardMapper.getListRowCount(map);
	}

	@Override
	public void insert(InfoBoardCommand infoBoard) {
		infoBoardMapper.insert(infoBoard);
		
	}

	@Override
	public InfoBoardCommand selectInfoBoard(Integer num) {
		return infoBoardMapper.selectInfoBoard(num);
	}

	@Override
	public void updateHit(Integer num) {
		infoBoardMapper.updateHit(num);
		
	}

	@Override
	public void update(InfoBoardCommand infoBoard) {
		infoBoardMapper.update(infoBoard);
		
	}

	@Override
	public void delete(Integer num) {
		//댓글의 댓글이 존재하면 우선 삭제
		//infoBoardMapper.deleteReReplyByNum(num);
		//댓글이 존재하면 댓글을 우선 삭제하고 부모글 삭제
		infoBoardMapper.deleteReplyByNum(num);
		//부모글 삭제
		infoBoardMapper.delete(num);
	}

	@Override
	public List<InfoBoardReplyCommand> infoListReply(Map<String, Object> map) {
		return infoBoardMapper.infoListReply(map);
	}

	@Override
	public int getListRowCountReply(Map<String, Object> map) {
		return infoBoardMapper.getListRowCountReply(map);
	}

	@Override
	public void insertReply(InfoBoardReplyCommand infoBoardReply) {
		infoBoardMapper.insertReply(infoBoardReply);
		
	}

	@Override
	public void updateReply(InfoBoardReplyCommand infoBoardReply) {
		infoBoardMapper.updateReply(infoBoardReply);
	}

	@Override
	public void deleteReply(Integer re_num) {
		infoBoardMapper.deleteReply(re_num);
	}

	@Override
	public List<InfoBoardReReplyCommand> infoListReReply(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListRowCountReReply(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

    @Override
    public void insertReReply(InfoBoardReReplyCommand infoBoardReReply) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateReReply(InfoBoardReReplyCommand infoBoardReReply) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteReReply(Integer rere_num) {
        // TODO Auto-generated method stub
        
    }
}
