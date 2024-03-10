package kr.co.dafarm.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.dafarm.bean.UserBean;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserBean userBean = (UserBean)target;
		
		String beanName = errors.getObjectName();
		
		if(beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
			// 회원가입시 비밀번호와 비밀번호 확인이 일치하지 않는 경우 검사 OR 수정할때
			if(userBean.getUser_password().equals(userBean.getUser_password_check()) == false) {
				errors.rejectValue("user_password", "NotEquals");
				errors.rejectValue("user_password_check", "NotEquals");
			}
		
			// 회원가입시 사용자 아이디 중복 확인이 이루어지지 않은 경우 검사
			if(beanName.equals("joinUserBean")) {
				
				if(userBean.isUserIdExist() == false) {
					errors.rejectValue("user_id", "DontCheckUserIdExist");
				}
			}
			
		}
	}
}
