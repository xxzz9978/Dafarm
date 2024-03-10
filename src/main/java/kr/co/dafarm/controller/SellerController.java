package kr.co.dafarm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.ibatis.session.RowBounds;
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

import kr.co.dafarm.bean.AdminSellerBoardBean;
import kr.co.dafarm.bean.KamisAPIBean;
import kr.co.dafarm.bean.OrderPageBean;
import kr.co.dafarm.bean.SellerBean;
import kr.co.dafarm.bean.SellerBoardBean;
import kr.co.dafarm.bean.SellerBoardPageBean;
import kr.co.dafarm.bean.SellerOrderBean;
import kr.co.dafarm.service.KamisAPIService;
import kr.co.dafarm.service.ProfitService;
import kr.co.dafarm.service.SellerNoticeService;
import kr.co.dafarm.service.SellerOrderService;
import kr.co.dafarm.service.SellerService;
import kr.co.dafarm.validator.SellerValidator;

@Controller
@RequestMapping("/seller/seller_user")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private KamisAPIService kamisApiService;
	
	@Autowired
	private SellerNoticeService sellerNoticeService;
	
	@Autowired
	private SellerOrderService sellerOrderService;
	
	@Autowired
	private ProfitService profitService;
	
	
	@Resource(name = "loginSellerBean")
	private SellerBean loginSellerBean;
	
	
	@GetMapping("/main")
	public String seller_main(@RequestParam(value = "order_status", defaultValue = "전체") String order_status,
			@RequestParam(value = "page", defaultValue = "1")int page, Model model) {
		KamisAPIBean kamisAPIBean = kamisApiService.getKamisAPIInfo();
		List<SellerBoardBean> contentList = sellerNoticeService.getContentList(page);
		
	    
		int count = sellerOrderService.getOrderCount(loginSellerBean.getSeller_num());
		int count1 = sellerOrderService.getOrderCountByStatus(loginSellerBean.getSeller_num(), "입금대기");
		int count2 = sellerOrderService.getOrderCountByStatus(loginSellerBean.getSeller_num(), "결제완료");
		int count3 = sellerOrderService.getOrderCountByStatus(loginSellerBean.getSeller_num(), "발송대기"); 
		int count4 = sellerOrderService.getOrderCountByStatus(loginSellerBean.getSeller_num(), "발송완료"); 
		
		int sellerProfit = profitService.getProfitPrice(loginSellerBean.getSeller_num());
		model.addAttribute("sellerProfit", sellerProfit);
		model.addAttribute("count", count);
		model.addAttribute("count1", count1);
		model.addAttribute("count2", count2);
		model.addAttribute("count3", count3);
		model.addAttribute("count4", count4);
		
		model.addAttribute("order_status", order_status);
		model.addAttribute("page",page);
	    model.addAttribute("contentList", contentList);
		model.addAttribute("kamisAPIBean",kamisAPIBean);	
		return "seller/seller_user/main";
	}
	
	@GetMapping("/info")
	public String info(@ModelAttribute("modifySellerBean") SellerBean modifySellerBean) {
		sellerService.getModifySellerInfo(modifySellerBean);
		return "seller/seller_user/info";
	}
	
	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifySellerBean") SellerBean modifySellerBean,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "seller/seller_user/info";
		}
		sellerService.modifySellerInfo(modifySellerBean);
		return "seller/seller_user/modify_success";
	}
	

	@GetMapping("/menu")
	public String menu(@RequestParam(value = "order_status", defaultValue = "전체") String order_status,
			@RequestParam(value = "orderPage", defaultValue = "1") int orderPage,
			@RequestParam(value = "page", defaultValue = "1")int page,
			Model model) {
		// 콘텐츠 목록 가져오기
	    List<SellerBoardBean> contentList = sellerNoticeService.getContentList(page);
	    model.addAttribute("contentList", contentList);
		
	    // 총 콘텐츠 개수와 페이지 정보를 가져와서 페이지 빈 객체에 설정
	    SellerBoardPageBean pageBean = sellerNoticeService.getContentCnt(null, page);
	    model.addAttribute("pageBean", pageBean);

	    // 현재 페이지 정보를 모델에 추가
	    model.addAttribute("page", page);
	    
	    return "seller/seller_user/menu";
	}

	
	// 게시판 리스트 제목, 내용 화면전환
	@GetMapping("/noticeRead")
	public String noticeRead(@RequestParam("seller_board_num")int seller_board_num,
						@RequestParam(value = "page", defaultValue = "1") int page,
						Model model,
						HttpServletRequest request,
						HttpServletResponse response) {
		
		// 조회수 증가 로직 추가
		sellerNoticeService.updateVisit(seller_board_num);
		
		model.addAttribute("seller_board_num", seller_board_num);
		
		SellerBoardBean readContentBean =
				sellerNoticeService.getContentInfo(seller_board_num);
		
		model.addAttribute("readContentBean", readContentBean);
		
		model.addAttribute("page", page);
		
		return "seller/seller_user/noticeRead";
	}
	
}
