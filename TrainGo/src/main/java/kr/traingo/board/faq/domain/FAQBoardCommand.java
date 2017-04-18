package kr.traingo.board.faq.domain;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class FAQBoardCommand {
	private int num;
	@NotEmpty
	private String faq_title;
	@NotEmpty
	private String faq_content;
	private String ip;
	@NotEmpty
	private String id;
	private Date register;
	
	private MultipartFile upload01;
	private byte[] faq_image01;
	private String faq_filename01;
	
	private MultipartFile upload02;
	private byte[] faq_image02;
	private String faq_filename02;
	
	private MultipartFile upload03;
	private byte[] faq_image03;
	private String faq_filename03;
	
	private MultipartFile upload04;
	private byte[] faq_image04;
	private String faq_filename04;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
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
	public MultipartFile getUpload01() {
		return upload01;
	}
	public void setUpload01(MultipartFile upload01) throws IOException {
		this.upload01 = upload01;
		setFaq_image01(upload01.getBytes());
		setFaq_filename01(upload01.getOriginalFilename());
	}
	public byte[] getFaq_image01() {
		return faq_image01;
	}
	public void setFaq_image01(byte[] faq_image01) {
		this.faq_image01 = faq_image01;
	}
	public String getFaq_filename01() {
		return faq_filename01;
	}
	public void setFaq_filename01(String faq_filename01) {
		this.faq_filename01 = faq_filename01;
	}
	public MultipartFile getUpload02() {
		return upload02;
	}
	public void setUpload02(MultipartFile upload02) throws IOException {
		this.upload02 = upload02;
		setFaq_image02(upload02.getBytes());
		setFaq_filename02(upload02.getOriginalFilename());
	}
	public byte[] getFaq_image02() {
		return faq_image02;
	}
	public void setFaq_image02(byte[] faq_image02) {
		this.faq_image02 = faq_image02;
	}
	public String getFaq_filename02() {
		return faq_filename02;
	}
	public void setFaq_filename02(String faq_filename02) {
		this.faq_filename02 = faq_filename02;
	}
	public MultipartFile getUpload03() {
		return upload03;
	}
	public void setUpload03(MultipartFile upload03) throws IOException {
		this.upload03 = upload03;
		setFaq_image03(upload03.getBytes());
		setFaq_filename03(upload03.getOriginalFilename());
	}
	public byte[] getFaq_image03() {
		return faq_image03;
	}
	public void setFaq_image03(byte[] faq_image03) {
		this.faq_image03 = faq_image03;
	}
	public String getFaq_filename03() {
		return faq_filename03;
	}
	public void setFaq_filename03(String faq_filename03) {
		this.faq_filename03 = faq_filename03;
	}
	public MultipartFile getUpload04() {
		return upload04;
	}
	public void setUpload04(MultipartFile upload04) throws IOException {
		this.upload04 = upload04;
		setFaq_image04(upload04.getBytes());
		setFaq_filename04(upload04.getOriginalFilename());
	}
	public byte[] getFaq_image04() {
		return faq_image04;
	}
	public void setFaq_image04(byte[] faq_image04) {
		this.faq_image04 = faq_image04;
	}
	public String getFaq_filename04() {
		return faq_filename04;
	}
	public void setFaq_filename04(String faq_filename04) {
		this.faq_filename04 = faq_filename04;
	}
	@Override
	public String toString() {
		return "FAQBoardCommand [num=" + num + ", faq_title=" + faq_title + ", faq_content=" + faq_content + ", ip="
				+ ip + ", id=" + id + ", register=" + register + ", upload01=" + upload01 + ", faq_image01="
				+ Arrays.toString(faq_image01) + ", faq_filename01=" + faq_filename01 + ", upload02=" + upload02
				+ ", faq_image02=" + Arrays.toString(faq_image02) + ", faq_filename02=" + faq_filename02 + ", upload03="
				+ upload03 + ", faq_image03=" + Arrays.toString(faq_image03) + ", faq_filename03=" + faq_filename03
				+ ", upload04=" + upload04 + ", faq_image04=" + Arrays.toString(faq_image04) + ", faq_filename04="
				+ faq_filename04 + "]";
	}
}
