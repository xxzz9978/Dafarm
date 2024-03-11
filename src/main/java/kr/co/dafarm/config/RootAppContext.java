package kr.co.dafarm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.dafarm.bean.SellerBean;
import kr.co.dafarm.bean.SellerPremiumBean;
import kr.co.dafarm.bean.UserBean;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext{

	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
	}
	
	@Bean("loginSellerBean")
	@SessionScope
	public SellerBean loginSellerBean() {
		return new SellerBean();
	}
	
}