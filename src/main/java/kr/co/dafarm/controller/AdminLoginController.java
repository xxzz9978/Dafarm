package kr.co.dafarm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dafarm.service.AdminLoginService;
@Controller
@RequestMapping("/Admin/login")
public class AdminLoginController {

	@Autowired
	AdminLoginService adminLoginService;

	// AdminLogin 매핑
	@GetMapping("/AdminLogin")
	public String Login() {
		return "/Admin/login/AdminLogin";
	}

	@PostMapping("/login")
	public String login(@RequestParam("inputID") String adminId, @RequestParam("inputPassword") String adminPw,
			HttpSession session, Model model) {
		if (adminLoginService.login(adminId, adminPw)) {
			session.setAttribute("adminId", adminId); // 세션에 어드민 아이디 저장
			return "redirect:/Admin/AdminDashboard"; // 로그인 성공 시 대시보드로
		} else {
			return "redirect:/Admin/login/AdminLogin";
		}
	}

	// AdminLogin 매핑
	@GetMapping("/not_login")
	public String not_login() {
		return "/Admin/login/not_login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 로그아웃 = 세션삭제
		session.removeAttribute("adminId");
		return "redirect:/Admin/login/AdminLogin";
	}

}
