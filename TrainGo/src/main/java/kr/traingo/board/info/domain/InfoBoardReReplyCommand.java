package kr.traingo.board.info.domain;

public class InfoBoardReReplyCommand {
	private int rere_num;
	private String rere_content;
	private String rere_ip;
	private String id;
	private int re_num;
	private String rere_register;
	public int getRere_num() {
		return rere_num;
	}
	public void setRere_num(int rere_num) {
		this.rere_num = rere_num;
	}
	public String getRere_content() {
		return rere_content;
	}
	public void setRere_content(String rere_content) {
		this.rere_content = rere_content;
	}
	public String getRere_ip() {
		return rere_ip;
	}
	public void setRere_ip(String rere_ip) {
		this.rere_ip = rere_ip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public String getRere_register() {
		return rere_register;
	}
	public void setRere_register(String rere_register) {
		this.rere_register = rere_register;
	}
	@Override
	public String toString() {
		return "InfoBoardReReplyCommand [rere_num=" + rere_num + ", rere_content=" + rere_content + ", rere_ip="
				+ rere_ip + ", id=" + id + ", re_num=" + re_num + ", rere_register=" + rere_register + "]";
	}
}
