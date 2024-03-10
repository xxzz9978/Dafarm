package kr.co.dafarm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dafarm.service.AdminLoginService;

@Controller
@RequestMapping("/Admin/chart")
public class AdminChartController {
	
	@Autowired
	AdminLoginService adminLoginService;
	

	// AdminCharts 매핑
		@GetMapping("/AdminCharts")
		public String Charts(HttpServletRequest request) {
			// 세션에서 어드민 아이디를 가져와서 로그인정보확인
			HttpSession session = request.getSession();
			String adminId = (String) session.getAttribute("adminId");
			if (adminId == null) {
				// 로그인안되면 낫로그인으로
				return "redirect:/Admin/login/not_login";
			}
			return "/Admin/chart/AdminCharts";
		}
	}
