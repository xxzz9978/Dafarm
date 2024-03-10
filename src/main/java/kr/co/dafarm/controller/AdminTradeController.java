package kr.co.dafarm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dafarm.bean.AdminOrderBean;
import kr.co.dafarm.bean.AdminProfitBean;
import kr.co.dafarm.service.AdminTradeLogService;

@Controller
@RequestMapping("/Admin/trade")
public class AdminTradeController {
	@Autowired
    private AdminTradeLogService adminTradeLogService;
	
	@GetMapping("/AdminTradeLog")
	public String AdminTradeLog(Model model, HttpSession session) {	
		 String adminId = (String) session.getAttribute("adminId");
	        if (adminId == null) {
	           
	        	return "redirect:/Admin/login/not_login";
	        }
	        List<AdminOrderBean> orderList = adminTradeLogService.all_orderLog();	        
	        model.addAttribute("orderList",orderList);
	        return "/Admin/trade/AdminTradeLog";
		
	}
	@GetMapping("/AdminTradeLogInfo")
	public String AdminTradeLogInfo(@RequestParam("order_number") int order_number, Model model, HttpSession session) {	
		 String adminId = (String) session.getAttribute("adminId");
		 AdminOrderBean orderInfo = adminTradeLogService.select_orderLog(order_number);	        
	        AdminProfitBean profitInfo = adminTradeLogService.select_profit(order_number);	
	        
	        model.addAttribute("orderInfo",orderInfo);
	        model.addAttribute("profitInfo",profitInfo);
	        if (adminId == null) {
	           
	        	return "redirect:/Admin/login/not_login";
	        }
	        
	        return "/Admin/trade/AdminTradeLogInfo";
		
	}

}
