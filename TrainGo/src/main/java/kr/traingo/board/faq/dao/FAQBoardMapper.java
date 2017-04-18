package kr.traingo.board.faq.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.traingo.board.faq.domain.FAQBoardCommand;

public interface FAQBoardMapper {
	public List<FAQBoardCommand> faqList(Map<String,Object> map);
	public int getListRowCount(Map<String,Object> map);
	@Insert("INSERT INTO faqboard (num,faq_title,faq_content,ip,id,register,"
			+ "faq_image01,faq_filename01,"
			+ "faq_image02,faq_filename02,"
			+ "faq_image03,faq_filename03,"
			+ "faq_image04,faq_filename04) "
			+ "VALUES(faqboard_seq.nextval,#{faq_title},#{faq_content},#{ip},#{id},sysdate,"
			+ "#{faq_image01,jdbcType=BLOB},#{faq_filename01,jdbcType=VARCHAR},"
			+ "#{faq_image02,jdbcType=BLOB},#{faq_filename02,jdbcType=VARCHAR},"
			+ "#{faq_image03,jdbcType=BLOB},#{faq_filename03,jdbcType=VARCHAR},"
			+ "#{faq_image04,jdbcType=BLOB},#{faq_filename04,jdbcType=VARCHAR})")
	public void insert(FAQBoardCommand faqBoard);
	@Select("SELECT * FROM faqboard WHERE num=#{num}")
	public FAQBoardCommand selectFAQBoard(Integer num);
	@Update("UPDATE faqboard SET faq_title=#{faq_title},faq_content=#{faq_content},"
			+ "faq_image01=#{faq_image01,jdbcType=BLOB},faq_filename01=#{faq_filename01,jdbcType=VARCHAR},"
			+ "faq_image02=#{faq_image02,jdbcType=BLOB},faq_filename02=#{faq_filename02,jdbcType=VARCHAR},"
			+ "faq_image03=#{faq_image03,jdbcType=BLOB},faq_filename03=#{faq_filename03,jdbcType=VARCHAR},"
			+ "faq_image04=#{faq_image04,jdbcType=BLOB},faq_filename04=#{faq_filename04,jdbcType=VARCHAR}"
			+ "WHERE num=#{num}")
	public void update(FAQBoardCommand faqBoard);
	@Delete("DELETE FROM faqboard WHERE num=#{num}")
	public void delete(Integer num);
	
}
