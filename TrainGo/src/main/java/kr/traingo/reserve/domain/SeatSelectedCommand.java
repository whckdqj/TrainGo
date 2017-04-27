package kr.traingo.reserve.domain;

public class SeatSelectedCommand {
private String seatnums;
private int seatnum;
private String trainnum;
private String cancel;
private int cost;
private String discount;





private String id;
private String trainname;
private int humancount;




public int getHumancount() {
	return humancount;
}
public void setHumancount(int humancount) {
	this.humancount = humancount;
}
public String getSeatnums() {
	return seatnums;
}
public void setSeatnums(String seatnums) {
	this.seatnums = seatnums;
}







public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTrainname() {
	return trainname;
}
public void setTrainname(String trainname) {
	this.trainname = trainname;
}


public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}



public String getDiscount() {
	return discount;
}
public void setDiscount(String discount) {
	this.discount = discount;
}
public String getCancel() {
	return cancel;
}
public void setCancel(String cancel) {
	this.cancel = cancel;
}
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
public String getBooker() {
	return booker;
}
public void setBooker(String booker) {
	this.booker = booker;
}
String booker;
	
}
