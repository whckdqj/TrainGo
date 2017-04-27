package kr.traingo.ticketlist.domain;

import java.sql.Date;

public class TicketListCommand {
	private int ticketnum;
	private String id;
	private int trainnum;
	private int seatnum;
	private String cancel;
	private String departsta;
	private String arrivalsta;
	private String departtime;
	private String arrivaltime;
	private String trainname;
	private Date reg_date;
	private int cost;
	
	public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getDepartsta() {
		return departsta;
	}
	public void setDepartsta(String departsta) {
		this.departsta = departsta;
	}
	public String getArrivalsta() {
		return arrivalsta;
	}
	public void setArrivalsta(String arrivalsta) {
		this.arrivalsta = arrivalsta;
	}
	public String getDeparttime() {
		return departtime;
	}
	public void setDeparttime(String departtime) {
		this.departtime = departtime;
	}
	public String getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public String getTrainname() {
		return trainname;
	}
	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}
	public int getTicketnum() {
		return ticketnum;
	}
	public void setTicketnum(int ticketnum) {
		this.ticketnum = ticketnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTrainnum() {
		return trainnum;
	}
	public void setTrainnum(int trainnum) {
		this.trainnum = trainnum;
	}
	public int getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(int seatnum) {
		this.seatnum = seatnum;
	}
	public String getCancel() {
		return cancel;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	
}
