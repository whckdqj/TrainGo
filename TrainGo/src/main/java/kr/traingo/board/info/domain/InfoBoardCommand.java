package kr.traingo.board.info.domain;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class InfoBoardCommand {
	private int num;
	private int code;
	private String nodeId;
	private String nodename;
	private String citycode;
	private String cityname;
	@NotEmpty
	private String content_title;
	@NotEmpty
	private String content_introduction;
	private String ip;
	@NotEmpty
	private String id;
	private Date register;
	private int hit;
	private MultipartFile upload01;
	private byte[] info_image01;
	private String info_filename01;
	
	private MultipartFile upload02;
	private byte[] info_image02;
	private String info_filename02;
	
	private MultipartFile upload03;
	private byte[] info_image03;
	private String info_filename03;
	
	private MultipartFile upload04;
	private byte[] info_image04;
	private String info_filename04;
	
	private MultipartFile upload05;
	private byte[] info_image05;
	private String info_filename05;
	
	private MultipartFile upload06;
	private byte[] info_image06;
	private String info_filename06;
	
	private MultipartFile upload07;
	private byte[] info_image07;
	private String info_filename07;
	
	private MultipartFile upload08;
	private byte[] info_image08;
	private String info_filename08;
	
	private MultipartFile upload09;
	private byte[] info_image09;
	private String info_filename09;
	
	private MultipartFile upload10;
	private byte[] info_image10;
	private String info_filename10;
	
	private int reply_cnt;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getNodename() {
		return nodename;
	}
	public void setNodename(String nodename) {
		this.nodename = nodename;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getContent_title() {
		return content_title;
	}
	public void setContent_title(String content_title) {
		this.content_title = content_title;
	}
	public String getContent_introduction() {
		return content_introduction;
	}
	public void setContent_introduction(String content_introduction) {
		this.content_introduction = content_introduction;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRegister() {
		return register;
	}
	public void setRegister(Date register) {
		this.register = register;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public MultipartFile getUpload01() {
		return upload01;
	}
	public void setUpload01(MultipartFile upload01) throws IOException {
		this.upload01 = upload01;
		setInfo_image01(upload01.getBytes());
		setInfo_filename01(upload01.getOriginalFilename());
	}
	public byte[] getInfo_image01() {
		return info_image01;
	}
	public void setInfo_image01(byte[] info_image01) {
		this.info_image01 = info_image01;
	}
	public String getInfo_filename01() {
		return info_filename01;
	}
	public void setInfo_filename01(String info_filename01) {
		this.info_filename01 = info_filename01;
	}
	public MultipartFile getUpload02() {
		return upload02;
	}
	public void setUpload02(MultipartFile upload02) throws IOException {
		this.upload02 = upload02;
		setInfo_image02(upload02.getBytes());
		setInfo_filename02(upload02.getOriginalFilename());
	}
	public byte[] getInfo_image02() {
		return info_image02;
	}
	public void setInfo_image02(byte[] info_image02) {
		this.info_image02 = info_image02;
	}
	public String getInfo_filename02() {
		return info_filename02;
	}
	public void setInfo_filename02(String info_filename02) {
		this.info_filename02 = info_filename02;
	}
	public MultipartFile getUpload03() {
		return upload03;
	}
	public void setUpload03(MultipartFile upload03) throws IOException {
		this.upload03 = upload03;
		setInfo_image03(upload03.getBytes());
		setInfo_filename03(upload03.getOriginalFilename());
	}
	public byte[] getInfo_image03() {
		return info_image03;
	}
	public void setInfo_image03(byte[] info_image03) {
		this.info_image03 = info_image03;
	}
	public String getInfo_filename03() {
		return info_filename03;
	}
	public void setInfo_filename03(String info_filename03) {
		this.info_filename03 = info_filename03;
	}
	public MultipartFile getUpload04() {
		return upload04;
	}
	public void setUpload04(MultipartFile upload04) throws IOException {
		this.upload04 = upload04;
		setInfo_image04(upload04.getBytes());
		setInfo_filename04(upload04.getOriginalFilename());
	}
	public byte[] getInfo_image04() {
		return info_image04;
	}
	public void setInfo_image04(byte[] info_image04) {
		this.info_image04 = info_image04;
	}
	public String getInfo_filename04() {
		return info_filename04;
	}
	public void setInfo_filename04(String info_filename04) {
		this.info_filename04 = info_filename04;
	}
	public MultipartFile getUpload05() {
		return upload05;
	}
	public void setUpload05(MultipartFile upload05) throws IOException {
		this.upload05 = upload05;
		setInfo_image05(upload05.getBytes());
		setInfo_filename05(upload05.getOriginalFilename());
	}
	public byte[] getInfo_image05() {
		return info_image05;
	}
	public void setInfo_image05(byte[] info_image05) {
		this.info_image05 = info_image05;
	}
	public String getInfo_filename05() {
		return info_filename05;
	}
	public void setInfo_filename05(String info_filename05) {
		this.info_filename05 = info_filename05;
	}
	public MultipartFile getUpload06() {
		return upload06;
	}
	public void setUpload06(MultipartFile upload06) throws IOException {
		this.upload06 = upload06;
		setInfo_image06(upload06.getBytes());
		setInfo_filename06(upload06.getOriginalFilename());
	}
	public byte[] getInfo_image06() {
		return info_image06;
	}
	public void setInfo_image06(byte[] info_image06) {
		this.info_image06 = info_image06;
	}
	public String getInfo_filename06() {
		return info_filename06;
	}
	public void setInfo_filename06(String info_filename06) {
		this.info_filename06 = info_filename06;
	}
	public MultipartFile getUpload07() {
		return upload07;
	}
	public void setUpload07(MultipartFile upload07) throws IOException {
		this.upload07 = upload07;
		setInfo_image07(upload07.getBytes());
		setInfo_filename07(upload07.getOriginalFilename());
	}
	public byte[] getInfo_image07() {
		return info_image07;
	}
	public void setInfo_image07(byte[] info_image07) {
		this.info_image07 = info_image07;
	}
	public String getInfo_filename07() {
		return info_filename07;
	}
	public void setInfo_filename07(String info_filename07) {
		this.info_filename07 = info_filename07;
	}
	public MultipartFile getUpload08() {
		return upload08;
	}
	public void setUpload08(MultipartFile upload08) throws IOException {
		this.upload08 = upload08;
		setInfo_image08(upload08.getBytes());
		setInfo_filename08(upload08.getOriginalFilename());
	}
	public byte[] getInfo_image08() {
		return info_image08;
	}
	public void setInfo_image08(byte[] info_image08) {
		this.info_image08 = info_image08;
	}
	public String getInfo_filename08() {
		return info_filename08;
	}
	public void setInfo_filename08(String info_filename08) {
		this.info_filename08 = info_filename08;
	}
	public MultipartFile getUpload09() {
		return upload09;
	}
	public void setUpload09(MultipartFile upload09) throws IOException {
		this.upload09 = upload09;
		setInfo_image09(upload09.getBytes());
		setInfo_filename09(upload09.getOriginalFilename());
	}
	public byte[] getInfo_image09() {
		return info_image09;
	}
	public void setInfo_image09(byte[] info_image09) {
		this.info_image09 = info_image09;
	}
	public String getInfo_filename09() {
		return info_filename09;
	}
	public void setInfo_filename09(String info_filename09) {
		this.info_filename09 = info_filename09;
	}
	public MultipartFile getUpload10() {
		return upload10;
	}
	public void setUpload10(MultipartFile upload10) throws IOException {
		this.upload10 = upload10;
		setInfo_image10(upload10.getBytes());
		setInfo_filename10(upload10.getOriginalFilename());
	}
	public byte[] getInfo_image10() {
		return info_image10;
	}
	public void setInfo_image10(byte[] info_image10) {
		this.info_image10 = info_image10;
	}
	public String getInfo_filename10() {
		return info_filename10;
	}
	public void setInfo_filename10(String info_filename10) {
		this.info_filename10 = info_filename10;
	}
	public int getReply_cnt() {
		return reply_cnt;
	}
	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}
	@Override
	public String toString() {
		return "InfoBoardCommand [num=" + num + ", code=" + code + ", nodeId=" + nodeId + ", nodename=" + nodename
				+ ", citycode=" + citycode + ", cityname=" + cityname + ", content_title=" + content_title
				+ ", content_introduction=" + content_introduction + ", ip=" + ip + ", id=" + id + ", register="
				+ register + ", hit=" + hit + ", upload01=" + upload01 + ", info_image01="
				+ Arrays.toString(info_image01) + ", info_filename01=" + info_filename01 + ", upload02=" + upload02
				+ ", info_image02=" + Arrays.toString(info_image02) + ", info_filename02=" + info_filename02
				+ ", upload03=" + upload03 + ", info_image03=" + Arrays.toString(info_image03) + ", info_filename03="
				+ info_filename03 + ", upload04=" + upload04 + ", info_image04=" + Arrays.toString(info_image04)
				+ ", info_filename04=" + info_filename04 + ", upload05=" + upload05 + ", info_image05="
				+ Arrays.toString(info_image05) + ", info_filename05=" + info_filename05 + ", upload06=" + upload06
				+ ", info_image06=" + Arrays.toString(info_image06) + ", info_filename06=" + info_filename06
				+ ", upload07=" + upload07 + ", info_image07=" + Arrays.toString(info_image07) + ", info_filename07="
				+ info_filename07 + ", upload08=" + upload08 + ", info_image08=" + Arrays.toString(info_image08)
				+ ", info_filename08=" + info_filename08 + ", upload09=" + upload09 + ", info_image09="
				+ Arrays.toString(info_image09) + ", info_filename09=" + info_filename09 + ", upload10=" + upload10
				+ ", info_image10=" + Arrays.toString(info_image10) + ", info_filename10=" + info_filename10
				+ ", reply_cnt=" + reply_cnt + "]";
	}
	
}
