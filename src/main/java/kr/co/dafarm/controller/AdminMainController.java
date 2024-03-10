package kr.co.dafarm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dafarm.bean.AdminOrderBean;
import kr.co.dafarm.bean.AdminProfitBean;
import kr.co.dafarm.bean.AdminSellerBean;
import kr.co.dafarm.bean.AdminUserBean;
import kr.co.dafarm.service.AdminDbService;
import kr.co.dafarm.service.AdminLoginService;
import kr.co.dafarm.service.AdminTradeLogService;

@Controller
@RequestMapping("/Admin")
public class AdminMainController {
	// 의존성 주입
	@Autowired
	private AdminDbService adminDbService;
	@Autowired
	private AdminLoginService adminLoginService;
	@Autowired
	private AdminTradeLogService adminTradeLogService;
	
	

	// AdminDashboard 매핑
	@GetMapping("/AdminDashboard")
	public String Dashboard(HttpSession session,Model model, Model model2) {
		
        String adminId = (String) session.getAttribute("adminId");
        if (adminId == null) {
            // 로그인되어 있지 않다면 로그인 페이지로 리다이렉트합니다.
            return "redirect:/Admin/login/not_login";
        }
		
		List<AdminUserBean> DashboardUserList = adminDbService.getDashboardUserList();
		model.addAttribute("userList",DashboardUserList );
		
		List<AdminSellerBean> DashboardSellerList = adminDbService.getDashboardSellerList();
		model2.addAttribute("sellerList",DashboardSellerList);
		
		List<AdminProfitBean> DashboardProfitList = adminTradeLogService.main_profitLog();
		model.addAttribute("profitList",DashboardProfitList) ;
		List<AdminOrderBean> DashboardOrderList = adminTradeLogService.main_tradeLog();
		model.addAttribute("orderList",DashboardOrderList) ;
		return "Admin/AdminDashboard";
	}

	
	
	

}
