package kr.traingo.board.info.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.traingo.board.info.domain.InfoBoardCommand;
import kr.traingo.board.info.domain.InfoBoardReplyCommand;

public interface InfoBoardMapper {
	//�θ��
	public List<InfoBoardCommand> infoList(Map<String,Object> map);
	public int getListRowCount(Map<String,Object> map);
	@Insert("INSERT INTO informationboard (num,code,nodeId,content_title,content_introduction,ip,id,register,"
			+ "info_image01,info_filename01,"
			+ "info_image02,info_filename02,"
			+ "info_image03,info_filename03,"
			+ "info_image04,info_filename04,"
			+ "info_image05,info_filename05,"
			+ "info_image06,info_filename06,"
			+ "info_image07,info_filename07,"
			+ "info_image08,info_filename08,"
			+ "info_image09,info_filename09,"
			+ "info_image10,info_filename10) VALUES(informationboard_seq.nextval,#{code},#{nodeId},#{content_title},#{content_introduction},#{ip},#{id},sysdate,"
			+ "#{info_image01,jdbcType=BLOB},#{info_filename01,jdbcType=VARCHAR},"
			+ "#{info_image02,jdbcType=BLOB},#{info_filename02,jdbcType=VARCHAR},"
			+ "#{info_image03,jdbcType=BLOB},#{info_filename03,jdbcType=VARCHAR},"
			+ "#{info_image04,jdbcType=BLOB},#{info_filename04,jdbcType=VARCHAR},"
			+ "#{info_image05,jdbcType=BLOB},#{info_filename05,jdbcType=VARCHAR},"
			+ "#{info_image06,jdbcType=BLOB},#{info_filename06,jdbcType=VARCHAR},"
			+ "#{info_image07,jdbcType=BLOB},#{info_filename07,jdbcType=VARCHAR},"
			+ "#{info_image08,jdbcType=BLOB},#{info_filename08,jdbcType=VARCHAR},"
			+ "#{info_image09,jdbcType=BLOB},#{info_filename09,jdbcType=VARCHAR},"
			+ "#{info_image10,jdbcType=BLOB},#{info_filename10,jdbcType=VARCHAR})")
	public void insert(InfoBoardCommand infoBoard);
	@Select("SELECT * FROM informationboard left join stninfotable on informationboard.nodeId=stninfotable.nodeId WHERE num = #{num}")
	public InfoBoardCommand selectInfoBoard(Integer num);
	@Update("UPDATE informationboard SET hit = hit+1 WHERE num=#{num}")
	public void updateHit(Integer num);
	@Update("UPDATE informationboard SET code=#{code},nodeId=#{nodeId},content_title=#{content_title},content_introduction=#{content_introduction},"
			+ "info_image01=#{info_image01,jdbcType=BLOB}, info_filename01=#{info_filename01,jdbcType=VARCHAR},"
			+ "info_image02=#{info_image02,jdbcType=BLOB}, info_filename02=#{info_filename02,jdbcType=VARCHAR},"
			+ "info_image03=#{info_image03,jdbcType=BLOB}, info_filename03=#{info_filename03,jdbcType=VARCHAR},"
			+ "info_image04=#{info_image04,jdbcType=BLOB}, info_filename04=#{info_filename04,jdbcType=VARCHAR},"
			+ "info_image05=#{info_image05,jdbcType=BLOB}, info_filename05=#{info_filename05,jdbcType=VARCHAR},"
			+ "info_image06=#{info_image06,jdbcType=BLOB}, info_filename06=#{info_filename06,jdbcType=VARCHAR},"
			+ "info_image07=#{info_image07,jdbcType=BLOB}, info_filename07=#{info_filename07,jdbcType=VARCHAR},"
			+ "info_image08=#{info_image08,jdbcType=BLOB}, info_filename08=#{info_filename08,jdbcType=VARCHAR},"
			+ "info_image09=#{info_image09,jdbcType=BLOB}, info_filename09=#{info_filename09,jdbcType=VARCHAR},"
			+ "info_image10=#{info_image10,jdbcType=BLOB}, info_filename10=#{info_filename10,jdbcType=VARCHAR}"
			+ "WHERE num=#{num}")
	public void update(InfoBoardCommand infoBoard);
	@Delete("DELETE FROM informationboard WHERE num=#{num}")
	public void delete(Integer num);
	
	//���
	public List<InfoBoardReplyCommand> infoListReply(Map<String,Object> map);
	@Select("SELECT count(*) FROM informationboardreply WHERE num=#{num}")
	public int getListRowCountReply(Map<String,Object> map);
	@Insert("INSERT INTO informationboardreply(re_num,re_content,re_ip,id,num,re_register) VALUES(informationboardreply_seq.nextval,#{re_content},#{re_ip},#{id},#{num},sysdate)")
	public void insertReply(InfoBoardReplyCommand infoBoardReply);
	@Update("UPDATE informationboardreply SET re_content=#{re_content} WHERE re_num=#{re_num}")
	public void updateReply(InfoBoardReplyCommand infoBoardReply);
	@Delete("DELETE FROM informationboardreply WHERE re_num=#{re_num}")
	public void deleteReply(Integer re_num);
	
	//�θ� �� ������ ����� ������ ��� �θ�� ���� ���� ��� ����
	@Delete("DELETE FROM informationboardreply WHERE num=#{num}")
	public void deleteReplyByNum(Integer num);
	
	//ȸ�� Ż��� ó������
	//�ش� id�� �ۼ��� ��� ���� �� ��ȣ�� �Լ�
	@Select("SELECT num FROM informationboard WHERE id=#{id}")
	public List<Integer> selectNumById(String id);
	
	//�ش� id�� �ۼ��� ��� �ۿ� �޸� ��� ����
	public void deleteReplyByNumList(List<Integer> list);
	
	//�ش� id�� �ۼ��� ��� ����
	@Delete("DELETE FROM informationboardreply WHERE id=#{id}")
	public void deleteReplyById(String id);
	
	//�ش� id�� �ۼ��� ��� �θ�� ����
	@Delete("DELETE FROM informationboard WHERE id=#{id}")
	public void deleteById(String id);
	
}
