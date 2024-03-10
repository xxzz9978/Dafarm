package kr.co.dafarm.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.dafarm.bean.SellerBean;

public class SellerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SellerBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		SellerBean sellerBean = (SellerBean)target;
		
		String beanName = errors.getObjectName();
		
		if(beanName.equals("joinSellerBean") || beanName.equals("modifySellerBean")) {
			// 회원가입시 비밀번호와 비밀번호 확인이 일치하지 않는 경우 검사 OR 수정할때
			if(sellerBean.getSeller_password().equals(sellerBean.getSeller_password_check()) == false) {
				errors.rejectValue("seller_password", "NotEquals");
				errors.rejectValue("seller_password_check", "NotEquals");
			}
		
			// 회원가입시 사용자 아이디 중복 확인이 이루어지지 않은 경우 검사
			if(beanName.equals("joinSellerBean")) {
				
				if(sellerBean.isSellerIdExist() == false) {
					errors.rejectValue("seller_id", "DontCheckSellerIdExist");
				}
			}
			
		}
	}
}
