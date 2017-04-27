package kr.traingo.ticketlist.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.traingo.reserve.domain.CancelCommand;
import kr.traingo.ticketlist.domain.TicketListCommand;
@Transactional
public interface TicketListService {
	@Transactional
	public TicketListCommand TicketDetail(int ticketnum);
	public void update(TicketListCommand ticketListCommand);
	public TicketListCommand ticketcaneldetail(String id);
	public List<TicketListCommand> ticketlist(Map<String, Object> map);
	@Transactional
	public int getRowCountReply(Map<String,Object> map);
	public TicketListCommand ticketCancel(String id,int ticketnum, int trainnum);
	public void CancelSeat(CancelCommand command);
	public void deleteTicket(String id, int ticketnum, int trainnum);
}
