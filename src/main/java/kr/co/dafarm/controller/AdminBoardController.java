package kr.co.dafarm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dafarm.bean.AdminSellerBoardBean;
import kr.co.dafarm.bean.AdminUserBoardBean;
import kr.co.dafarm.service.AdminBoardService;

@Controller
@RequestMapping("/Admin/board")
public class AdminBoardController {
	
	@Autowired
	AdminBoardService adminBoardService;

	@GetMapping("/AdminUserBoardList")
	public String admin_user_board(Model model, HttpServletRequest request) {
		// 세션에서 어드민 아이디를 가져와서 로그인정보확인
		HttpSession session = request.getSession();
		String adminId = (String) session.getAttribute("adminId");
		if (adminId == null) {
			// 로그인안되면 낫로그인으로
			return "redirect:/Admin/login/not_login";
		}
		
		List<AdminUserBoardBean> adminUserBoardBean = adminBoardService.select_all_user_board();
		
		model.addAttribute("adminUserBoardBean", adminUserBoardBean);
		
		return "/Admin/board/AdminUserBoardList";
	}
	
	@GetMapping("/AdminUserBoardWrite")
	public String admin_User_board_write(@ModelAttribute("adminUserBoardBean") AdminUserBoardBean adminUserBoardBean, HttpServletRequest request) {
		// 세션에서 어드민 아이디를 가져와서 로그인정보확인
		HttpSession session = request.getSession();
		String adminId = (String) session.getAttribute("adminId");
		if (adminId == null) {
			// 로그인안되면 낫로그인으로
			return "redirect:/Admin/login/not_login";
		}
		
		return "/Admin/board/AdminUserBoardWrite";
	}
	
	@PostMapping("/AdminUserBoardWrite_pro")
	public String admin_User_Board_Write_pro(@Valid @ModelAttribute("adminUserBoardBean") AdminUserBoardBean adminUserBoardBean, HttpServletRequest request,
			BindingResult result) {
		// 세션에서 어드민 아이디를 가져와서 로그인 정보 확인
		HttpSession session = request.getSession();
		String adminId = (String) session.getAttribute("adminId");
		if (adminId == null) {
			// 로그인안되면 낫로그인으로
			return "redirect:/Admin/login/not_login";
		}
		
		adminBoardService.user_new_post(adminUserBoardBean);
		
		if(result.hasErrors()) {
			return "redirect:/Admin/board/AdminUserBoardList";
		}
		
		return "redirect:/Admin/board/AdminUserBoardList";
	}
	
	@GetMapping("/AdminUserBoardModify")
	public String admin_User_Board_Modify(HttpServletRequest request, @RequestParam("user_board_num") int user_board_num, Model model,
    		@ModelAttribute("adminUserBoardBean") AdminUserBoardBean adminUserBoardBean) {
		
		// 세션에서 어드민 아이디를 가져와서 로그인 정보 확인
		HttpSession session = request.getSession();
		String adminId = (String) session.getAttribute("adminId");
		if (adminId == null) {
			// 로그인안되면 낫로그인으로
			return "redirect:/Admin/login/not_login";
		}
		
		AdminUserBoardBean boardBean = adminBoardService.select_one_user_board(user_board_num);
		
		adminUserBoardBean.setUser_board_num(boardBean.getUser_board_num());
		adminUserBoardBean.setUser_board_title(boardBean.getUser_board_title());
		adminUserBoardBean.setUser_board_content(boardBean.getUser_board_content());
		adminUserBoardBean.setUser_board_access_date(boardBean.getUser_board_access_date());
		adminUserBoardBean.setUser_board_view_count(boardBean.getUser_board_view_count());
    	
    	return "/Admin/board/AdminUserBoardModify";
		
	}
	
	@PostMapping("/AdminUserBoardModify_pro")
	public String admin_User_Board_Modify_pro(@ModelAttribute("adminUserBoardBean") AdminUserBoardBean adminUserBoardBean, Model model, BindingResult result) {
		adminBoardService.user_modify_board(adminUserBoardBean);
		return "redirect:/Admin/board/AdminUserBoardList";
	}
	
	@PostMapping("/AdminUserBoardDelete")
	public String admin_User_Board_Delete(@RequestParam("user_board_num") int user_board_num) {
		adminBoardService.user_delete_board(user_board_num);
		return "redirect:/Admin/board/AdminUserBoardList";
	}
	
	
	
	
	@GetMapping("/AdminSellerBoardList")
	public String admin_seller_board(Model model, HttpServletRequest request) {
		// 세션에서 어드민 아이디를 가져와서 로그인정보확인
		HttpSession session = request.getSession();
		String adminId = (String) session.getAttribute("adminId");
		if (adminId == null) {
			// 로그인안되면 낫로그인으로
			return "redirect:/Admin/login/not_login";
		}
		
		List<AdminSellerBoardBean> adminSellerBoardBean = adminBoardService.select_all_seller_board();
		
		model.addAttribute("adminSellerBoardBean", adminSellerBoardBean);
		
		return "/Admin/board/AdminSellerBoardList";
	}
	
	@GetMapping("/AdminSellerBoardWrite")
	public String admin_seller_board_write(@ModelAttribute("adminSellerBoardBean") AdminSellerBoardBean adminSellerBoardBean, HttpServletRequest request) {
		// 세션에서 어드민 아이디를 가져와서 로그인정보확인
		HttpSession session = request.getSession();
		String adminId = (String) session.getAttribute("adminId");
		if (adminId == null) {
			// 로그인안되면 낫로그인으로
			return "redirect:/Admin/login/not_login";
		}
		
		return "/Admin/board/AdminSellerBoardWrite";
	}
	
	@PostMapping("/AdminSellerBoardWrite_pro")
	public String admin_Seller_Board_Write_pro(@Valid @ModelAttribute("adminSellerBoardBean") AdminSellerBoardBean adminSellerBoardBean, HttpServletRequest request,
			BindingResult result) {
		// 세션에서 어드민 아이디를 가져와서 로그인 정보 확인
		HttpSession session = request.getSession();
		String adminId = (String) session.getAttribute("adminId");
		if (adminId == null) {
			// 로그인안되면 낫로그인으로
			return "redirect:/Admin/login/not_login";
		}
		
		adminBoardService.seller_new_post(adminSellerBoardBean);
		
		if(result.hasErrors()) {
			return "redirect:/Admin/board/AdminSellerBoardList";
		}
		
		return "redirect:/Admin/board/AdminSellerBoardList";
	}
	
	@GetMapping("/AdminSellerBoardModify")
	public String admin_Seller_Board_Modify(HttpServletRequest request, @RequestParam("seller_board_num") int seller_board_num, Model model,
    		@ModelAttribute("adminSellerBoardBean") AdminSellerBoardBean adminSellerBoardBean) {
		
		// 세션에서 어드민 아이디를 가져와서 로그인 정보 확인
		HttpSession session = request.getSession();
		String adminId = (String) session.getAttribute("adminId");
		if (adminId == null) {
			// 로그인안되면 낫로그인으로
			return "redirect:/Admin/login/not_login";
		}
		
		AdminSellerBoardBean boardBean = adminBoardService.select_one_seller_board(seller_board_num);
		
		adminSellerBoardBean.setSeller_board_num(boardBean.getSeller_board_num());
		adminSellerBoardBean.setSeller_board_title(boardBean.getSeller_board_title());
		adminSellerBoardBean.setSeller_board_content(boardBean.getSeller_board_content());
		adminSellerBoardBean.setSeller_board_access_date(boardBean.getSeller_board_access_date());
		adminSellerBoardBean.setSeller_board_view_count(boardBean.getSeller_board_view_count());
    	
    	return "/Admin/board/AdminSellerBoardModify";
		
	}
	
	@PostMapping("/AdminSellerBoardModify_pro")
	public String admin_Seller_Board_Modify_pro(@ModelAttribute("adminSellerBoardBean") AdminSellerBoardBean adminSellerBoardBean, Model model, BindingResult result) {
		adminBoardService.seller_modify_board(adminSellerBoardBean);
		return "redirect:/Admin/board/AdminSellerBoardList";
	}
	
	@PostMapping("/AdminSellerBoardDelete")
	public String admin_Seller_Board_Delete(@RequestParam("seller_board_num") int seller_board_num) {
		adminBoardService.seller_delete_board(seller_board_num);
		return "redirect:/Admin/board/AdminSellerBoardList";
	}
	
}
