package kr.traingo.ticketlist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.traingo.reserve.domain.CancelCommand;
import kr.traingo.ticketlist.domain.TicketListCommand;

public interface TicketListMapper {
	@Select("SELECT * FROM ticketlist WHERE ticketnum=#{ticketnum}")
	public TicketListCommand TicketDetail(int ticketnum);
	
	@Update("update ticketlist set cancel=#{cancel}, reg_date=sysdate where id=#{id} and trainnum=#{trainnum} and ticketnum=#{ticketnum} ")
	public void update(TicketListCommand ticketListCommand);
	
	@Select("SELECT * FROM ticketlist WHERE id=#{id} ")
	public TicketListCommand ticketcaneldetail(String id);	
	
	/*@Select("select * from ticketlist where id=#{id}")*/
	public List<TicketListCommand> ticketlist(Map<String, Object> map);
	@Select("SELECT count(*) FROM ticketlist WHERE id=#{id}")
	public int getRowCountReply(Map<String,Object> map);
	@Select("select * from ticketlist where id=#{id} and ticketnum=#{ticketnum} and trainnum=#{trainnum}")
	public TicketListCommand ticketCancel(@Param("id") String id,@Param("ticketnum") int ticketnum, @Param("trainnum") int trainnum);
	
	@Update("update seats set booker=#{booker} where trainnum=#{trainnum} and seatnum=#{seatnum}")
	public void CancelSeat(CancelCommand command);
	
	@Delete("delete from ticketlist where id=#{id} and ticketnum=#{ticketnum} and trainnum=#{trainnum}")
	public void deleteTicket(@Param("id") String id,@Param("ticketnum") int ticketnum, @Param("trainnum") int trainnum);
	
}
