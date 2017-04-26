package kr.traingo.ticketlist.domain;

public class AutoTrainCommand {
	private int seatnum;
	private String trainnum;
	private String departsta;
	private String arrivalsta;
	private String departtime;
	private String arrivaltime;
	private String trainname;
	private String charge;
	private String cancel;
	private int ticketnum;
	public int getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(int seatnum) {
		this.seatnum = seatnum;
	}
	public String getTrainnum() {
		return trainnum;
	}
	public void setTrainnum(String trainnum) {
		this.trainnum = trainnum;
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
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getCancel() {
		return cancel;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	public int getTicketnum() {
		return ticketnum;
	}
	public void setTicketnum(int ticketnum) {
		this.ticketnum = ticketnum;
	}
	
}
