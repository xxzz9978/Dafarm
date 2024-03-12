package kr.co.dafarm.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class AdminAccountBean {

	private String admin_id;
	private String admin_pw;
	
	private boolean adminLogin;
	
	
	public AdminAccountBean() {
		adminLogin=false;
	}


	public String getAdmin_id() {
		return admin_id;
	}


	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}


	public String getAdmin_pw() {
		return admin_pw;
	}


	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}


	public boolean isAdminLogin() {
		return adminLogin;
	}


	public void setAdminLogin(boolean adminLogin) {
		this.adminLogin = adminLogin;
	}
	
	
	
}
