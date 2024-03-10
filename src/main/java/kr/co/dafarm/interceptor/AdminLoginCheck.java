package kr.co.dafarm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.dafarm.bean.AdminAccountBean;

public class AdminLoginCheck implements HandlerInterceptor {

	private AdminAccountBean loginAdminBean;
	
	
	public AdminLoginCheck(AdminAccountBean loginAdminBean) {
		this.loginAdminBean = loginAdminBean;
	
	}


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (loginAdminBean.isAdminLogin() == false) {

			// 로그인 하지 않은 경로 호출
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/admin/login/not_login");

			return false;

		}

		return true;
	}

	}
	
	

