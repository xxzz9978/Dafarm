package kr.co.dafarm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.dafarm.bean.SellerBean;

public class CheckSellerLoginInterceptor implements HandlerInterceptor{
	
	// 해당 Class 파일 설명 :
	// Seller 로그인 상태를 확인하여 미로그인 상태에서 Login 및 SignUp(회원 가입) 페이지 기능 이외
	// 사용 제한을 두기 위해 구현한 class
	
	// ===== Seller단 ===============================================================================
	private SellerBean loginSellerBean;
	
	// Seller 로그인 확인
	public CheckSellerLoginInterceptor(SellerBean loginSellerBean) {
		this.loginSellerBean = loginSellerBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// if 문 설명 (로그인이 되지 않은 상황일 경우 DAFARM Login 화면으로 전환)
		if(loginSellerBean.isSellerLogin() == false) {
			// 로그인 하지 않은 경로 호출
			String contextPath = request.getContextPath();
			// 로그인이 되어있지 않은 상태일 경우 WebBrowser에게 not_loign을 요청 지시하고 false 반환
			response.sendRedirect(contextPath + "/users/user/not_login");
			return false;
		}
		// 로그인이 되어있는 상태일 경우 true 반환
		return true;
	}
	
}
