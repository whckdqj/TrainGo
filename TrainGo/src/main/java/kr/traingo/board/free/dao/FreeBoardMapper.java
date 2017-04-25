package kr.traingo.board.free.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.traingo.board.free.domain.FreeBoardCommand;
import kr.traingo.board.free.domain.FreeBoardReplyCommand;

public interface FreeBoardMapper {
	//부모글
	public List<FreeBoardCommand> freeList(Map<String,Object> map);
	public int getListRowCount(Map<String,Object> map);
	@Insert("INSERT INTO freeboard (num,free_title,free_content,ip,id,register,"
			+ "free_image01,free_filename01,"
			+ "free_image02,free_filename02,"
			+ "free_image03,free_filename03,"
			+ "free_image04,free_filename04,"
			+ "free_image05,free_filename05,"
			+ "free_image06,free_filename06,"
			+ "free_image07,free_filename07,"
			+ "free_image08,free_filename08,"
			+ "free_image09,free_filename09,"
			+ "free_image10,free_filename10) VALUES(freeboard_seq.nextval,#{free_title},#{free_content},#{ip},#{id},sysdate,"
			+ "#{free_image01,jdbcType=BLOB},#{free_filename01,jdbcType=VARCHAR},"
			+ "#{free_image02,jdbcType=BLOB},#{free_filename02,jdbcType=VARCHAR},"
			+ "#{free_image03,jdbcType=BLOB},#{free_filename03,jdbcType=VARCHAR},"
			+ "#{free_image04,jdbcType=BLOB},#{free_filename04,jdbcType=VARCHAR},"
			+ "#{free_image05,jdbcType=BLOB},#{free_filename05,jdbcType=VARCHAR},"
			+ "#{free_image06,jdbcType=BLOB},#{free_filename06,jdbcType=VARCHAR},"
			+ "#{free_image07,jdbcType=BLOB},#{free_filename07,jdbcType=VARCHAR},"
			+ "#{free_image08,jdbcType=BLOB},#{free_filename08,jdbcType=VARCHAR},"
			+ "#{free_image09,jdbcType=BLOB},#{free_filename09,jdbcType=VARCHAR},"
			+ "#{free_image10,jdbcType=BLOB},#{free_filename10,jdbcType=VARCHAR})")
	public void insert(FreeBoardCommand freeBoard);
	@Select("SELECT * FROM freeboard WHERE num=#{num}")
	public FreeBoardCommand selectFreeBoard(Integer num);
	@Update("UPDATE freeboard SET hit = hit+1 WHERE num=#{num}")
	public void updateHit(Integer num);
	@Update("UPDATE freeboard SET free_title=#{free_title},free_content=#{free_content},"
			+ "free_image01=#{free_image01,jdbcType=BLOB},free_filename01=#{free_filename01,jdbcType=VARCHAR},"
			+ "free_image02=#{free_image02,jdbcType=BLOB},free_filename02=#{free_filename02,jdbcType=VARCHAR},"
			+ "free_image03=#{free_image03,jdbcType=BLOB},free_filename03=#{free_filename03,jdbcType=VARCHAR},"
			+ "free_image04=#{free_image04,jdbcType=BLOB},free_filename04=#{free_filename04,jdbcType=VARCHAR},"
			+ "free_image05=#{free_image05,jdbcType=BLOB},free_filename05=#{free_filename05,jdbcType=VARCHAR},"
			+ "free_image06=#{free_image06,jdbcType=BLOB},free_filename06=#{free_filename06,jdbcType=VARCHAR},"
			+ "free_image07=#{free_image07,jdbcType=BLOB},free_filename07=#{free_filename07,jdbcType=VARCHAR},"
			+ "free_image08=#{free_image08,jdbcType=BLOB},free_filename08=#{free_filename08,jdbcType=VARCHAR},"
			+ "free_image09=#{free_image09,jdbcType=BLOB},free_filename09=#{free_filename09,jdbcType=VARCHAR},"
			+ "free_image10=#{free_image10,jdbcType=BLOB},free_filename10=#{free_filename10,jdbcType=VARCHAR}"
			+ "WHERE num=#{num}")
	public void update(FreeBoardCommand freeBoard);
	@Delete("DELETE FROM freeboard WHERE num=#{num}")
	public void delete(Integer num);
	
	//댓글
	public List<FreeBoardReplyCommand> freeListReply(Map<String,Object> map);
	@Select("SELECT count(*) FROM freeboardreply WHERE num=#{num}")
	public int getListRowCountReply(Map<String,Object> map);
	@Insert("INSERT INTO freeboardreply(re_num,re_content,re_ip,id,num,re_register) VALUES(freeboardreply_seq.nextval,#{re_content},#{re_ip},#{id},#{num},sysdate)")
	public void insertReply(FreeBoardReplyCommand freeBoardReply);
	@Update("UPDATE freeboardreply SET re_content=#{re_content} WHERE re_num=#{re_num}")
	public void updateReply(FreeBoardReplyCommand freeBoardReply);
	@Delete("DELETE FROM freeboardreply WHERE re_num=#{re_num}")
	public void deleteReply(Integer re_num);
	
	//부모 글 삭제시 댓글이 존재할 경우 부모글 삭제 이전 댓글 삭제
	@Delete("DELETE FROM freeboardreply WHERE num=#{num}")
	public void deleteReplyByNum(Integer num);
	
	//회원 탈퇴시 처리사항
	//해당 id로 작성된 모든 글의 글 번호를 입수
	@Select("SELECT num FROM freeboard WHERE id=#{id}")
	public List<Integer> selectNumById(String id);
		
	//해당 id로 작성된 모든 글에 달린 댓글 삭제
	public void deleteReplyByNumList(List<Integer> list);
		
	//해당 id로 작성된 댓글 삭제
	@Delete("DELETE FROM freeboardreply WHERE id=#{id}")
	public void deleteReplyById(String id);
		
	//해당 id로 작성된 모든 부모글 삭제
	@Delete("DELETE FROM freeboard WHERE id=#{id}")
	public void deleteById(String id);

}
