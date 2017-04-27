package kr.traingo.ticketlist.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import kr.traingo.reserve.domain.CancelCommand;
import kr.traingo.ticketlist.dao.TicketListMapper;
import kr.traingo.ticketlist.domain.TicketListCommand;

@Service("ticketListService")
public class TicketListServiceImpl implements TicketListService{
	@Resource
	private TicketListMapper ticketlistmapper;
	
	@Override
	public void update(TicketListCommand ticketListCommand) {
		// TODO Auto-generated method stub
		ticketlistmapper.update(ticketListCommand);
	}
	
	@Override
	public List<TicketListCommand> ticketlist(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ticketlistmapper.ticketlist(map);
	}
	@Override
	public int getRowCountReply(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ticketlistmapper.getRowCountReply(map);
	}
	@Override
	public TicketListCommand TicketDetail(int ticketnum) {
		// TODO Auto-generated method stub
		return ticketlistmapper.TicketDetail(ticketnum);
	}

	@Override
	public TicketListCommand ticketcaneldetail(String id) {
		// TODO Auto-generated method stub
		return ticketlistmapper.ticketcaneldetail(id);
	}

	@Override
	public TicketListCommand ticketCancel(String id, int ticketnum, int trainnum) {
		// TODO Auto-generated method stub
		return ticketlistmapper.ticketCancel(id, ticketnum, trainnum);
	}

	@Override
	public void CancelSeat(CancelCommand command) {
		// TODO Auto-generated method stub
		ticketlistmapper.CancelSeat(command);
	}

    @Override
    public void deleteTicket(String id, int ticketnum, int trainnum) {
        // TODO Auto-generated method stub
        ticketlistmapper.deleteTicket(id,ticketnum,trainnum);
    }
	
	
	

	
	
}
