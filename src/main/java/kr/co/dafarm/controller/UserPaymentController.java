package kr.co.dafarm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dafarm.bean.UserBean;
import kr.co.dafarm.bean.UserPaymentBean;
import kr.co.dafarm.service.UserPaymentService;

@Controller
@RequestMapping("/users/trade")
public class UserPaymentController {

	@Autowired
	private UserPaymentService userPaymentService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/payment")
	public String payment_list(Model model) {

		List<UserPaymentBean> payment_info = userPaymentService.payment_info(loginUserBean.getUser_num());
		model.addAttribute("payment_info", payment_info);
		
		int totalPrice1 = userPaymentService.getTotalPrice(loginUserBean.getUser_num());
		model.addAttribute("totalPrice1", totalPrice1);
		
		return "users/trade/payment";
	}

}
