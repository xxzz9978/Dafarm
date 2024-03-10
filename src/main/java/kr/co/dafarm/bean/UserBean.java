package kr.co.dafarm.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserBean {

	public UserBean() {
		// 초기에 userId 중복 검사는 하지 않기에 false로 지정해줌
		this.userIdExist = false;
		// 초기에 로그인을 하지 않은것으로 false 처리
		this.userLogin = false;
	}
	
	private int user_num; 				// 일반 회원 번호
	
	@Size(min=8, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_id;			 	// 일반 회원 아이디
	
	@Size(min=8, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_password; 		// 일반 회원 비밀번호

	@Size(min=8, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_password_check; // 일반 회원 비밀번호 확인
	
	@Size(min=2, max=6)
	@Pattern(regexp = "[가-힣]*")
	private String user_name; 			// 일반 회원 이름
	
	private String user_address; 		// 일반 회원 주소
	
	@Email
	private String user_email; 			// 일반 회원 이메일
	
	@Pattern(regexp = "^[0-9]+$")
	private String user_phone;		 	// 일반 회원 전화번호
	
	private String user_access_date;	// 일반 회원 회원가입 일자
	
	private boolean userIdExist; 		// 회원가입시 아이디 중복확인
	
	private boolean userLogin;			// 회원 로그인 상태 확인

	//----- Getter / Setter ------------------------------------------------------------
	
	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_password_check() {
		return user_password_check;
	}

	public void setUser_password_check(String user_password_check) {
		this.user_password_check = user_password_check;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_access_date() {
		return user_access_date;
	}

	public void setUser_access_date(String user_access_date) {
		this.user_access_date = user_access_date;
	}

	public boolean isUserIdExist() {
		return userIdExist;
	}

	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}

	public boolean isUserLogin() {
		return userLogin;
	}

	public void setUserLogin(boolean userLogin) {
		this.userLogin = userLogin;
	}

}
