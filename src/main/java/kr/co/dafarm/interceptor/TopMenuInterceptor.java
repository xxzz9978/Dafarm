
package kr.co.dafarm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.dafarm.bean.UserBean;

public class TopMenuInterceptor implements HandlerInterceptor{

	/* 
	 * 해당 Class 파일 설명 :
	 * User 미로그인 상태에서는 Main / Login / 광고 보기 / 시세 보기 기능만 가능하며
	 * User 로그인 상태에서만 Shop / Market 등 기능들을 사용하게 제한하기 위함 
	 */

	private UserBean loginUserBean;	
	
	public TopMenuInterceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.setAttribute("loginUserBean", loginUserBean);
		return true;
	}
	
	
}
