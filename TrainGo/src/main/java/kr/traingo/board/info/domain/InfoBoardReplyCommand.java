package kr.traingo.board.info.domain;

public class InfoBoardReplyCommand {
	private int re_num;
	private String re_content;
	private String re_ip;
	private String id;
	private int num;
	private String re_register;
	
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getRe_ip() {
		return re_ip;
	}
	public void setRe_ip(String re_ip) {
		this.re_ip = re_ip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getRe_register() {
		return re_register;
	}
	public void setRe_register(String re_register) {
		this.re_register = re_register;
	}
	
	@Override
	public String toString() {
		return "InfoBoardReplyCommand [re_num=" + re_num + ", re_content=" + re_content + ", re_ip=" + re_ip + ", id="
				+ id + ", num=" + num + ", re_register=" + re_register + "]";
	}
}
