package kr.co.dafarm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dafarm.bean.UserBean;
import kr.co.dafarm.bean.UserInformationBean;
import kr.co.dafarm.bean.UserProductBean;
import kr.co.dafarm.service.UserTradeService;

@Controller
@RequestMapping("/users/trade")
public class UserTradeController {

	@Autowired
	private UserTradeService userTradeService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	@GetMapping("/order_list")
	public String order_list(Model model) {

		List<UserProductBean> order_list = userTradeService.select_product_table();

		model.addAttribute("order_list", order_list);

		return "users/trade/order_list";

	}

	@GetMapping("/product_info")
	public String product_info(@RequestParam("product_idx") int product_idx, Model model) {
		UserProductBean product_info = userTradeService.select_one_product_table(product_idx);
		model.addAttribute("product_info", product_info);
		return "users/trade/product_info";
	}

	@GetMapping("/information")
	public String information(Model model) {

		List<UserInformationBean> information_list = userTradeService.trackingshipment(loginUserBean.getUser_num());

		model.addAttribute("information_list", information_list);

		return "users/trade/information";
	}
}
