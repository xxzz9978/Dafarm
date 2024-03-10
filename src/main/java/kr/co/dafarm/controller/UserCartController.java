package kr.co.dafarm.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dafarm.bean.UserBean;
import kr.co.dafarm.bean.UserCartBean;
import kr.co.dafarm.service.UserCartService;

@Controller
@RequestMapping("/users/trade")
public class UserCartController {

	@Autowired
	private UserCartService userCartService;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	@GetMapping("/cart_add")
    public String addCartInfo(@RequestParam("user_num") String user_num,
                            @RequestParam("user_name") String user_name,
                            @RequestParam("product_name") String product_name,
                            @RequestParam("product_price") String product_price,
                            @RequestParam("product_weight") String product_weight,
                            @RequestParam("product_quantity") String product_quantity,
                            @RequestParam("product_date") String product_date,
                            @RequestParam("product_writer_num") int product_writer_num,
                            @RequestParam("product_idx") int product_idx) {

		// 날짜 형식 변환
	    LocalDate date = LocalDate.parse(product_date, DateTimeFormatter.ISO_DATE);
	    
        // 여기서 받은 정보로 UserCartBean을 생성
        UserCartBean addCartBean = new UserCartBean();
        addCartBean.setUser_num(loginUserBean.getUser_num());
        addCartBean.setUser_name(loginUserBean.getUser_name());
        addCartBean.setProduct_name(product_name);
        addCartBean.setProduct_price(product_price);
        addCartBean.setProduct_weight(product_weight);
        addCartBean.setProduct_quantity(product_quantity);
        addCartBean.setProduct_date(date.toString());
        addCartBean.setProduct_writer_num(product_writer_num);
        addCartBean.setProduct_idx(product_idx);

        // 카트에 추가하는 서비스 호출
        userCartService.addCartInfo(addCartBean);
        
		return "users/trade/cart_add_success";
	}
	
	@GetMapping("/cart")
	public String cart_list(Model model) {
		
		List<UserCartBean> cart_list = userCartService.select_cart_table(loginUserBean.getUser_num());
		
		model.addAttribute("cart_list", cart_list);
		
		return "users/trade/cart";
	}
	
	@GetMapping("/delete")
	public String cart_delete(@RequestParam("cart_num") int cart_num, @RequestParam("user_num") int user_num, Model model) {
		userCartService.delete_cart(cart_num, user_num);
		
		List<UserCartBean> cart_list = userCartService.select_cart_table(loginUserBean.getUser_num());
		model.addAttribute("cart_list", cart_list);
		return "users/trade/cart";
	}
}
