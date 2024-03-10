package kr.co.dafarm.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dafarm.bean.SellerBean;
import kr.co.dafarm.bean.UserBean;
import kr.co.dafarm.service.SellerService;
import kr.co.dafarm.service.UserService;
import kr.co.dafarm.validator.UserValidator;

@Controller
@RequestMapping("/users/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	@Autowired
	private SellerService sellerService;
	
	@Resource(name = "loginSellerBean")
	private SellerBean loginSellerBean;
	
	// ===========================================================================================================
	// not login
	@GetMapping("/not_login")
	public String not_login() {
		return "users/user/not_login";
	}
	
	// User Login
	@GetMapping("/login")
	public String user_login(@ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean,
							 @RequestParam(value = "fail", defaultValue = "false") boolean fail, Model model) {
		
		model.addAttribute("fail", fail);
		return "users/user/login";
	}

	//----------------------------------------------------------------------------------------------------------------------------
	
	// logout(로그아웃) 후 메인 페이지로 전환 하는 GetMapping Method
	@GetMapping("/logout")
	public String logout() {
		loginUserBean.setUserLogin(false);
		return "users/user/logout";
	}

	// Login(로그인)시 DB의 data를 비교하여 Post
	@PostMapping("/login_pro_user")
	public String login_pro_user(@Valid @ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean, BindingResult result) {

		if (result.hasErrors()) {
			return "users/user/login";
		}
		
		// DB에 있는 Data중 일치하는 Data를 찾아 Login을 성공한 경우
		userService.getLoginUserBean(tempLoginUserBean);
		
		if(loginUserBean.isUserLogin() == true) {
			
			System.out.println("확인이용" + loginUserBean.getUser_num());
			
			return "users/user/login_success";
		}else {
			
			return "users/user/login_fail";
		}
	}

	// ===========================================================================================================

	// User Join
	@GetMapping("/join")
	public String user_join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {

		return "users/user/join";
	}

	// join(회원가입)시 입력된 data들 UserBean에 Post
	@PostMapping("/join_pro_user")
	public String join_pro_user(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
		
		if (result.hasErrors()) {	
			return "users/user/join";
		}
		
		// 데이터베이스에 저장 및 회원가입 완료
		userService.addUserInfo(joinUserBean);
		
		return "users/user/join_success";
	}

	// ===========================================================================================================

	// User ModifyInfo (마이페이지_정보 수정)
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyUserBean") UserBean modifyUserBean) {
		
		userService.getModifyUserInfo(modifyUserBean);
		
		return "users/user/modify";
	}

	// modify (정보수정)시 입력된 data들을 UserBean에 Post
	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifyUserBean") UserBean modifyUserBean, BindingResult result) {
		
		if (result.hasErrors()) {
			return "users/user/modify";
		}
		
		userService.modifyUserInfo(modifyUserBean);
		return "users/user/modify_success";
	}

	// ===========================================================================================================
	
	// Seller Login / Join ===============================
	@GetMapping("/login_seller")
	public String seller_login(@ModelAttribute("tempLoginSellerBean") SellerBean tempLoginSellerBean,
							 @RequestParam(value = "fail", defaultValue = "false") boolean fail, Model model) {
		
		model.addAttribute("fail", fail);
		return "users/user/login_seller";
	}
	
	@PostMapping("/login_pro_seller")
	public String login_pro_seller(@Valid @ModelAttribute("tempLoginSellerBean") SellerBean tempLoginSellerBean, BindingResult result) {
		
		if (result.hasErrors()) {
			return "users/user/login_seller";
		}
		
		// DB에 있는 Data중 일치하는 Data를 찾아 Login을 성공한 경우
		sellerService.getLoginSellerBean(tempLoginSellerBean);
		
		if(loginSellerBean.isSellerLogin() == true) {
			
			return "users/user/login_success_seller";
		}else {
			
			return "users/user/login_fail_seller";
		}
	}
	
	// User Join
	@GetMapping("/join_seller")
	public String seller_join(@ModelAttribute("joinSellerBean") SellerBean joinSellerBean) {

		return "users/user/join_seller";
	}

	// join(회원가입)시 입력된 data들 UserBean에 Post
	@PostMapping("/join_pro_seller")
	public String join_pro_seller(@Valid @ModelAttribute("joinSellerBean") SellerBean joinSellerBean, BindingResult result) {
		
		if (result.hasErrors()) {	
			return "users/user/join_seller";
		}
			
		// 데이터베이스에 저장 및 회원가입 완료
		sellerService.addSellerInfo(joinSellerBean);
		sellerService.addSellerBusinessInfo(joinSellerBean);
		
		return "users/user/join_success_seller";
	}
}

