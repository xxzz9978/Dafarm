package kr.co.dafarm.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dafarm.bean.AdminPremiumBean;
import kr.co.dafarm.bean.AdminProfitBean;
import kr.co.dafarm.bean.AdminSellerBean;
import kr.co.dafarm.bean.AdminUserBean;
import kr.co.dafarm.service.AdminDbService;
import kr.co.dafarm.service.AdminTradeLogService;

@Controller
@RequestMapping("/Admin/table")
public class AdminTableController {
    @Autowired
    private AdminDbService adminDbService;
    @Autowired
    private AdminTradeLogService adminTradeLogService;

    @GetMapping("AdminBuyerTables")
    public String AdminBuyerTables(Model model, HttpSession session) {
       
        String adminId = (String) session.getAttribute("adminId");
        if (adminId == null) {
           
        	return "redirect:/Admin/login/not_login";
        }

        List<AdminUserBean> userList = adminDbService.getUserList();
        model.addAttribute("userList", userList);
        return "/Admin/table/AdminBuyerTables";
    }

    @GetMapping("/AdminSellerTables")
    public String SellerTables(Model model, HttpSession session) {
        String adminId = (String) session.getAttribute("adminId");
        if (adminId == null) {
        	return "redirect:/Admin/login/not_login";
        }

        List<AdminSellerBean> sellerList = adminDbService.getSellerList();
        model.addAttribute("sellerList", sellerList);

        return "/Admin/table/AdminSellerTables";
    }
    
    @GetMapping("/AdminSellerInfo")
    public String AdminSellerInfo(HttpSession session, @RequestParam("seller_num") int seller_num, Model model) {
    	String adminId = (String) session.getAttribute("adminId");
    	AdminSellerBean AdminSellerInfoBean = adminDbService.select_seller_info(seller_num);
    	AdminSellerBean AdminbussinessInfoBean = adminDbService.select_bussiness_info(seller_num);
    	AdminPremiumBean adminPremiumBean = adminDbService.select_premium(seller_num);
    	AdminProfitBean adminProfitBean = adminTradeLogService.select_seller_profit(seller_num);
    	
        if (adminId == null) {
        	return "redirect:/Admin/login/not_login";
        }
    	
        model.addAttribute("AdminSellerInfoBean" ,AdminSellerInfoBean);
    	model.addAttribute("AdminbussinessInfoBean" ,AdminbussinessInfoBean);
    	model.addAttribute("adminPremiumBean",adminPremiumBean);
    	model.addAttribute("adminProfitBean",adminProfitBean);
    	return "/Admin/table/AdminSellerInfo";
    }
    
    @GetMapping("/AdminSellerModify")
    public String AdminSellerModify(HttpSession session, @RequestParam("seller_num") int seller_num, Model model,
    		@ModelAttribute("adminModifySellerBean") AdminSellerBean adminModifySellerBean) {
    	String adminId = (String) session.getAttribute("adminId");
    	AdminSellerBean AdminSellerInfoBean = adminDbService.select_seller_info(seller_num);
    	AdminSellerBean AdminbussinessInfoBean = adminDbService.select_bussiness_info(seller_num);
    	AdminPremiumBean adminPremiumBean = adminDbService.select_premium(seller_num);
    	AdminProfitBean adminProfitBean = adminTradeLogService.select_seller_profit(seller_num);
    	    	
    	adminModifySellerBean.setSeller_name(AdminSellerInfoBean.getSeller_name());
    	adminModifySellerBean.setSeller_access_date(AdminSellerInfoBean.getSeller_access_date());
    	adminModifySellerBean.setSeller_num(AdminSellerInfoBean.getSeller_num());
    	adminModifySellerBean.setSeller_phone(AdminSellerInfoBean.getSeller_phone());
    	adminModifySellerBean.setSeller_email(AdminSellerInfoBean.getSeller_email());
    	adminModifySellerBean.setSeller_address(AdminSellerInfoBean.getSeller_address());
    	adminModifySellerBean.setSeller_id(AdminSellerInfoBean.getSeller_id());
    	adminModifySellerBean.setSeller_password(AdminSellerInfoBean.getSeller_password());
    	adminModifySellerBean.setBusiness_account(AdminbussinessInfoBean.getBusiness_account());
    	adminModifySellerBean.setBusiness_name(AdminbussinessInfoBean.getBusiness_name());
    	adminModifySellerBean.setBusiness_number(AdminbussinessInfoBean.getBusiness_number());
    	model.addAttribute("adminPremiumBean",adminPremiumBean);
    	model.addAttribute("adminProfitBean",adminProfitBean);

    	if (adminId == null) {
    		return "redirect:/Admin/login/not_login";
    	}
    	
    	
    	return "/Admin/table/AdminSellerModify";
    }
    
    @PostMapping("/AdminSellerModify_pro")
    public String AdminSellerModify_pro (@ModelAttribute("adminModifySellerBean")AdminSellerBean adminModifySellerBean, Model model, BindingResult result) {
    	if (result.hasErrors()) {
			return "/Admin/table/AdminSellerModify";
		}
    	adminDbService.modify_bussiness(adminModifySellerBean);
    	adminDbService.modify_seller(adminModifySellerBean);
    	return "/Admin/table/AdminSellerModify_success" ;
    }
    
    @PostMapping("/AdminSellerDelete")
    public String AdminSellerDelete (HttpSession session, @RequestParam("seller_num") int seller_num) {

    	adminDbService.delete_business(seller_num);
    	adminDbService.delete_seller(seller_num);
    	return "/Admin/table/AdminSellerTables" ;
    }
    
    @PostMapping("/AdminBuyerDelete")
    public String AdminBuyerDelete (HttpSession session, @RequestParam("user_num") int user_num) {

    	adminDbService.delete_user(user_num);
    	return "/Admin/table/AdminBuyerTables" ;
    }
    
    @GetMapping("/AdminBuyerInfo")
    public String AdminBuyerInfo(HttpSession session, @RequestParam("user_num") int user_num, Model model) {
    	String adminId = (String) session.getAttribute("adminId");
    	AdminUserBean adminUserBean = adminDbService.select_user_info(user_num);
    	AdminProfitBean adminProfitBean = adminTradeLogService.select_user_info(user_num);
        if (adminId == null) {
        	return "redirect:/Admin/login/not_login";
        }
    	
        model.addAttribute("adminUserBean", adminUserBean);
        model.addAttribute("adminProfitBean", adminProfitBean);
        
    	return "/Admin/table/AdminBuyerInfo";
    }
    
    @GetMapping("/AdminBuyerModify")
    public String AdminBuyerModify(HttpSession session, @RequestParam("user_num") int user_num, Model model,
    		@ModelAttribute("adminUserBean") AdminUserBean adminUserBean) {
    	String adminId = (String) session.getAttribute("adminId");
    		
    	if (adminId == null) {
    		return "redirect:/Admin/login/not_login";
    	}
    	AdminProfitBean adminProfitBean = adminTradeLogService.select_user_info(user_num);
    	model.addAttribute("adminProfitBean", adminProfitBean);
    	AdminUserBean adminUserBeanNum = adminDbService.select_user_info(user_num);
    	
    	adminUserBean.setUser_name(adminUserBeanNum.getUser_name());
    	adminUserBean.setUser_access_date(adminUserBeanNum.getUser_access_date());
    	adminUserBean.setUser_num(adminUserBeanNum.getUser_num());
    	adminUserBean.setUser_phone(adminUserBeanNum.getUser_phone());
    	adminUserBean.setUser_email(adminUserBeanNum.getUser_email());
    	adminUserBean.setUser_address(adminUserBeanNum.getUser_address());
    	adminUserBean.setUser_id(adminUserBeanNum.getUser_id());
    	adminUserBean.setUser_password(adminUserBeanNum.getUser_password());

    	
    	return "/Admin/table/AdminBuyerModify";
    }
    
    @PostMapping("/AdminBuyerModify_pro")
    public String AdminBuyerModify_pro (@ModelAttribute("adminUserBean") AdminUserBean adminUserBean, Model model, BindingResult result) {
    	if (result.hasErrors()) {
			return "/Admin/table/AdminBuyerModify";
		}
    	adminDbService.modify_user(adminUserBean);
    	return "/Admin/table/AdminBuyerModify_success" ;
    }
    
}
