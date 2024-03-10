package kr.co.dafarm.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AdminAccountBean {

	private String admin_id;
	private String admin_pw;
	
	private boolean adminLogin;
	
	
	public AdminAccountBean() {
		adminLogin=false;
	}
}
