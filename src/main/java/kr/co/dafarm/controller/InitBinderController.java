package kr.co.dafarm.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import kr.co.dafarm.validator.SellerValidator;
import kr.co.dafarm.validator.UserValidator;

public class InitBinderController {

	// Error 발생시 경고문 Binder에 등록 
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
		
		SellerValidator validator2 = new SellerValidator();
		binder.addValidators(validator2);
		
	}

	/*
	// Error 발생시 경고문 Binder에 등록 
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SellerValidator validator2 = new SellerValidator();
		binder.addValidators(validator2);
	}
	*/
	
}
