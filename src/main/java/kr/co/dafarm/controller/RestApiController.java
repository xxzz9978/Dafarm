package kr.co.dafarm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dafarm.service.SellerService;
import kr.co.dafarm.service.UserService;

@RestController
public class RestApiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SellerService sellerService;
	
	// JSON 형식으로 View에 결과를 보여줌 (User)
	@GetMapping("/users/user/checkUserIdExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		
		boolean chk = userService.checkUserIdExist(user_id);
		
		return chk + "";
	}
	
	// JSON 형식으로 View에 결과를 보여줌 (Seller)
	@GetMapping("/users/user/checkSellerIdExist/{seller_id}")
	public String checkSellerIdExist(@PathVariable String seller_id) {
		
		boolean chk = sellerService.checkSellerIdExist(seller_id);
		
		return chk + "";
	}
}
