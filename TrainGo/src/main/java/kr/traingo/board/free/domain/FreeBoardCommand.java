package kr.traingo.board.free.domain;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class FreeBoardCommand {
	private int num;
	@NotEmpty
	private String free_title;
	@NotEmpty
	private String free_content;
	private String ip;
	@NotEmpty
	private String id;
	private Date register;
	private int hit;
	
	private MultipartFile upload01;
	private byte[] free_image01;
	private String free_filename01;
	
	private MultipartFile upload02;
	private byte[] free_image02;
	private String free_filename02;
	
	private MultipartFile upload03;
	private byte[] free_image03;
	private String free_filename03;
	
	private MultipartFile upload04;
	private byte[] free_image04;
	private String free_filename04;
	
	private MultipartFile upload05;
	private byte[] free_image05;
	private String free_filename05;
	
	private MultipartFile upload06;
	private byte[] free_image06;
	private String free_filename06;
	
	private MultipartFile upload07;
	private byte[] free_image07;
	private String free_filename07;
	
	private MultipartFile upload08;
	private byte[] free_image08;
	private String free_filename08;
	
	private MultipartFile upload09;
	private byte[] free_image09;
	private String free_filename09;
	
	private MultipartFile upload10;
	private byte[] free_image10;
	private String free_filename10;
	
	private int reply_cnt;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getFree_title() {
		return free_title;
	}

	public void setFree_title(String free_title) {
		this.free_title = free_title;
	}

	public String getFree_content() {
		return free_content;
	}

	public void setFree_content(String free_content) {
		this.free_content = free_content;
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
		setFree_image01(upload01.getBytes());
		setFree_filename01(upload01.getOriginalFilename());
	}

	public byte[] getFree_image01() {
		return free_image01;
	}

	public void setFree_image01(byte[] free_image01) {
		this.free_image01 = free_image01;
	}

	public String getFree_filename01() {
		return free_filename01;
	}

	public void setFree_filename01(String free_filename01) {
		this.free_filename01 = free_filename01;
	}

	public MultipartFile getUpload02() {
		return upload02;
	}

	public void setUpload02(MultipartFile upload02) throws IOException {
		this.upload02 = upload02;
		setFree_image02(upload02.getBytes());
		setFree_filename02(upload02.getOriginalFilename());
	}

	public byte[] getFree_image02() {
		return free_image02;
	}

	public void setFree_image02(byte[] free_image02) {
		this.free_image02 = free_image02;
	}

	public String getFree_filename02() {
		return free_filename02;
	}

	public void setFree_filename02(String free_filename02) {
		this.free_filename02 = free_filename02;
	}

	public MultipartFile getUpload03() {
		return upload03;
	}

	public void setUpload03(MultipartFile upload03) throws IOException {
		this.upload03 = upload03;
		setFree_image03(upload03.getBytes());
		setFree_filename03(upload03.getOriginalFilename());
	}

	public byte[] getFree_image03() {
		return free_image03;
	}

	public void setFree_image03(byte[] free_image03) {
		this.free_image03 = free_image03;
	}

	public String getFree_filename03() {
		return free_filename03;
	}

	public void setFree_filename03(String free_filename03) {
		this.free_filename03 = free_filename03;
	}

	public MultipartFile getUpload04() {
		return upload04;
	}

	public void setUpload04(MultipartFile upload04) throws IOException {
		this.upload04 = upload04;
		setFree_image04(upload04.getBytes());
		setFree_filename04(upload04.getOriginalFilename());
	}

	public byte[] getFree_image04() {
		return free_image04;
	}

	public void setFree_image04(byte[] free_image04) {
		this.free_image04 = free_image04;
	}

	public String getFree_filename04() {
		return free_filename04;
	}

	public void setFree_filename04(String free_filename04) {
		this.free_filename04 = free_filename04;
	}

	public MultipartFile getUpload05() {
		return upload05;
	}

	public void setUpload05(MultipartFile upload05) throws IOException {
		this.upload05 = upload05;
		setFree_image05(upload05.getBytes());
		setFree_filename05(upload05.getOriginalFilename());
	}

	public byte[] getFree_image05() {
		return free_image05;
	}

	public void setFree_image05(byte[] free_image05) {
		this.free_image05 = free_image05;
	}

	public String getFree_filename05() {
		return free_filename05;
	}

	public void setFree_filename05(String free_filename05) {
		this.free_filename05 = free_filename05;
	}

	public MultipartFile getUpload06() {
		return upload06;
	}

	public void setUpload06(MultipartFile upload06) throws IOException {
		this.upload06 = upload06;
		setFree_image06(upload06.getBytes());
		setFree_filename06(upload06.getOriginalFilename());
	}

	public byte[] getFree_image06() {
		return free_image06;
	}

	public void setFree_image06(byte[] free_image06) {
		this.free_image06 = free_image06;
	}

	public String getFree_filename06() {
		return free_filename06;
	}

	public void setFree_filename06(String free_filename06) {
		this.free_filename06 = free_filename06;
	}

	public MultipartFile getUpload07() {
		return upload07;
	}

	public void setUpload07(MultipartFile upload07) throws IOException {
		this.upload07 = upload07;
		setFree_image07(upload07.getBytes());
		setFree_filename07(upload07.getOriginalFilename());
	}

	public byte[] getFree_image07() {
		return free_image07;
	}

	public void setFree_image07(byte[] free_image07) {
		this.free_image07 = free_image07;
	}

	public String getFree_filename07() {
		return free_filename07;
	}

	public void setFree_filename07(String free_filename07) {
		this.free_filename07 = free_filename07;
	}

	public MultipartFile getUpload08() {
		return upload08;
	}

	public void setUpload08(MultipartFile upload08) throws IOException {
		this.upload08 = upload08;
		setFree_image08(upload08.getBytes());
		setFree_filename08(upload08.getOriginalFilename());
	}

	public byte[] getFree_image08() {
		return free_image08;
	}

	public void setFree_image08(byte[] free_image08) {
		this.free_image08 = free_image08;
	}

	public String getFree_filename08() {
		return free_filename08;
	}

	public void setFree_filename08(String free_filename08) {
		this.free_filename08 = free_filename08;
	}

	public MultipartFile getUpload09() {
		return upload09;
	}

	public void setUpload09(MultipartFile upload09) throws IOException {
		this.upload09 = upload09;
		setFree_image09(upload09.getBytes());
		setFree_filename09(upload09.getOriginalFilename());
	}

	public byte[] getFree_image09() {
		return free_image09;
	}

	public void setFree_image09(byte[] free_image09) {
		this.free_image09 = free_image09;
	}

	public String getFree_filename09() {
		return free_filename09;
	}

	public void setFree_filename09(String free_filename09) {
		this.free_filename09 = free_filename09;
	}

	public MultipartFile getUpload10() {
		return upload10;
	}

	public void setUpload10(MultipartFile upload10) throws IOException {
		this.upload10 = upload10;
		setFree_image10(upload10.getBytes());
		setFree_filename10(upload10.getOriginalFilename());
	}

	public byte[] getFree_image10() {
		return free_image10;
	}

	public void setFree_image10(byte[] free_image10) {
		this.free_image10 = free_image10;
	}

	public String getFree_filename10() {
		return free_filename10;
	}

	public void setFree_filename10(String free_filename10) {
		this.free_filename10 = free_filename10;
	}

	public int getReply_cnt() {
		return reply_cnt;
	}

	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}

	@Override
	public String toString() {
		return "FreeBoardCommand [num=" + num + ", free_title=" + free_title + ", free_content=" + free_content
				+ ", ip=" + ip + ", id=" + id + ", register=" + register + ", hit=" + hit + ", upload01=" + upload01
				+ ", free_image01=" + Arrays.toString(free_image01) + ", free_filename01=" + free_filename01
				+ ", upload02=" + upload02 + ", free_image02=" + Arrays.toString(free_image02) + ", free_filename02="
				+ free_filename02 + ", upload03=" + upload03 + ", free_image03=" + Arrays.toString(free_image03)
				+ ", free_filename03=" + free_filename03 + ", upload04=" + upload04 + ", free_image04="
				+ Arrays.toString(free_image04) + ", free_filename04=" + free_filename04 + ", upload05=" + upload05
				+ ", free_image05=" + Arrays.toString(free_image05) + ", free_filename05=" + free_filename05
				+ ", upload06=" + upload06 + ", free_image06=" + Arrays.toString(free_image06) + ", free_filename06="
				+ free_filename06 + ", upload07=" + upload07 + ", free_image07=" + Arrays.toString(free_image07)
				+ ", free_filename07=" + free_filename07 + ", upload08=" + upload08 + ", free_image08="
				+ Arrays.toString(free_image08) + ", free_filename08=" + free_filename08 + ", upload09=" + upload09
				+ ", free_image09=" + Arrays.toString(free_image09) + ", free_filename09=" + free_filename09
				+ ", upload10=" + upload10 + ", free_image10=" + Arrays.toString(free_image10) + ", free_filename10="
				+ free_filename10 + ", reply_cnt=" + reply_cnt + "]";
	}
}
