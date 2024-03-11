 package kr.co.dafarm.controller;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import kr.co.dafarm.bean.AdminPremiumBean;
import kr.co.dafarm.bean.AdminSellerBean;
import kr.co.dafarm.bean.KamisAPIBean;
import kr.co.dafarm.bean.OrderPageBean;
import kr.co.dafarm.bean.ProfitBean;
import kr.co.dafarm.bean.SellerBean;
import kr.co.dafarm.bean.SellerBoardBean;
import kr.co.dafarm.bean.SellerBoardPageBean;
import kr.co.dafarm.bean.SellerOrderBean;
import kr.co.dafarm.bean.SellerPremiumPiechartBean;
import kr.co.dafarm.bean.SellerProductBean;
import kr.co.dafarm.bean.UserBoardBean;
import kr.co.dafarm.bean.UserBoardPageBean;
import kr.co.dafarm.service.KamisAPIService;
import kr.co.dafarm.service.ProfitService;
import kr.co.dafarm.service.SellerNoticeService;
import kr.co.dafarm.service.SellerOrderService;
import kr.co.dafarm.service.SellerProductService;
import kr.co.dafarm.service.SellerService;

@Controller
@RequestMapping("/seller/board")
public class SellerBoardController {
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private SellerProductService sellerProductService;
	
	@Autowired
	private SellerOrderService sellerOrderService;
	
	@Autowired
	private KamisAPIService kamisApiService;
	
	@Autowired
	private ProfitService profitService;
	
	@Resource(name = "loginSellerBean")
	private SellerBean loginSellerBean;

	@GetMapping("/order")
	public String order(@RequestParam(value = "order_status", defaultValue = "전체") String order_status,
						@RequestParam(value = "orderPage", defaultValue = "1") int orderPage,
						Model model) {

		List<SellerOrderBean> orderList = sellerOrderService.getOrderList(loginSellerBean.getSeller_num(), order_status, orderPage);
		model.addAttribute("orderList", orderList);
		
		int count = sellerOrderService.getOrderCount(loginSellerBean.getSeller_num());
		int count1 = sellerOrderService.getOrderCountByStatus(loginSellerBean.getSeller_num(), "입금대기");
		int count2 = sellerOrderService.getOrderCountByStatus(loginSellerBean.getSeller_num(), "결제완료");
		int count3 = sellerOrderService.getOrderCountByStatus(loginSellerBean.getSeller_num(), "발송대기"); 
		int count4 = sellerOrderService.getOrderCountByStatus(loginSellerBean.getSeller_num(), "발송완료"); 
		
		model.addAttribute("count", count);
		model.addAttribute("count1", count1);
		model.addAttribute("count2", count2);
		model.addAttribute("count3", count3);
		model.addAttribute("count4", count4);
		
		model.addAttribute("order_status", order_status);
		
		OrderPageBean orderPageBean = sellerOrderService.getPageBeanCnt(order_status, orderPage);
		model.addAttribute("orderPageBean", orderPageBean);
		
		model.addAttribute("orderPage", orderPage);
		
		return "seller/board/order";
	}

	@GetMapping("/addPremium")
	public String addPremium(Model model) {			
		return "seller/board/premium_payment";
	}
	
	@GetMapping("/payment_success")
	public String premium_succes(Model model) {				
		return "seller/board/payment_success";
	}
	
	@GetMapping("/seller_payment_success")
	public String seller_payment_success() {
		
		AdminPremiumBean sellerPremiumBean = new AdminPremiumBean();
		sellerService.addSellerPremiumInfo(sellerPremiumBean);
		
		return "seller/board/premium_payment";
	}

	@GetMapping("/premium")
	public String premium(Model model) {
		
		KamisAPIBean kamisAPIBean = kamisApiService.getKamisAPIInfo();
		model.addAttribute("kamisAPIBean", kamisAPIBean);
		
		List<SellerProductBean> sellerProductBean = sellerProductService.getProductList(loginSellerBean.getSeller_num());
		model.addAttribute("sellerProductBean", sellerProductBean);
		
		List<SellerOrderBean> sellerOrderBean = sellerOrderService.getOrderListVanila(loginSellerBean.getSeller_num());
		model.addAttribute("sellerOrderBean", sellerOrderBean);
		
		List<ProfitBean> sellerProfitBean = profitService.getProfitList(loginSellerBean.getSeller_num());
		model.addAttribute("sellerProfitBean", sellerProfitBean);
		
		int year = LocalDate.now().getYear();
		model.addAttribute("year",year);
		
		int month = LocalDate.now().getMonthValue();
		model.addAttribute("month", month);
				
		String jan = profitService.getProfitSumByMonth(1);
		if(jan == null) {
			jan = "0";
		}
		model.addAttribute("jan", jan);		
		
		String feb = profitService.getProfitSumByMonth(2);
		if(feb == null) {
			feb = "0";
		}
		model.addAttribute("feb", feb);
		
		String mar = profitService.getProfitSumByMonth(3);
		if(mar == null) {
			mar = "0";
		}
		model.addAttribute("mar", mar);
				
		String apr = profitService.getProfitSumByMonth(4);
		if(apr == null) {
			apr = "0";
		}
		model.addAttribute("apr", apr);
		
		String may = profitService.getProfitSumByMonth(5);
		if(may == null) {
			may = "0";
		}
		model.addAttribute("may", may);
		
		String jun = profitService.getProfitSumByMonth(6);
		if(jun == null) {
			jun = "0";
		}
		model.addAttribute("jun", jun);
		
		String jul = profitService.getProfitSumByMonth(7);
		if(jul == null) {
			jul = "0";
		}
		model.addAttribute("jul", jul);
		
		String aug = profitService.getProfitSumByMonth(8);
		if(aug == null) {
			aug = "0";
		}
		model.addAttribute("aug", aug);
		
		String sep = profitService.getProfitSumByMonth(9);
		if(sep == null) {
			sep = "0";
		}
		model.addAttribute("sep", sep);
		
		String oct = profitService.getProfitSumByMonth(10);
		if(oct == null) {
			oct = "0";
		}
		model.addAttribute("oct", oct);
		
		String nov = profitService.getProfitSumByMonth(11);
		if(nov == null) {
			nov = "0";
		}
		model.addAttribute("nov", nov);
		
		String dec = profitService.getProfitSumByMonth(12);
		if(dec == null) {
			dec = "0";
		}
		model.addAttribute("dec", dec);
		
		List<SellerPremiumPiechartBean> piechartBean = profitService.getPiechartList(loginSellerBean.getSeller_num());
		model.addAttribute("piechartBean", piechartBean);	
		
		
		return "seller/board/premium";
	}

	@GetMapping("/read")
	public String read(@RequestParam("product_idx") int product_idx, Model model) {
		model.addAttribute("product_idx",product_idx); 
		
		SellerProductBean readProductBean = sellerProductService.getProductInfo(product_idx);
		readProductBean.setProduct_writer_num(loginSellerBean.getSeller_num());
		System.out.println(loginSellerBean.getSeller_num());
		model.addAttribute("readProductBean",readProductBean);
		
		model.addAttribute("loginSellerBean",loginSellerBean);
		return "seller/board/read";
	}

	@GetMapping("/store")
	public String store(Model model) {
		
		List<SellerProductBean> productList = sellerProductService.getProductList(loginSellerBean.getSeller_num());
		int count = sellerProductService.getProductCount(loginSellerBean.getSeller_num());
		model.addAttribute("count",count);
		model.addAttribute("productList",productList);
		return "seller/board/store";
	}

	@GetMapping("/plusGoods")
	public String plusGoods(@ModelAttribute("addProductBean") SellerProductBean addProductBean) {
		
		return "seller/board/plusGoods";
	}
	
	@GetMapping("/OrderGoods")
	public String OrderGoods(@ModelAttribute("addOrderBean") SellerOrderBean SellerOrderBean) {
		
		return "seller/board/OrderGoods";
	}

	@PostMapping("/addProduct_pro")
	public String addProduct_pro(@Valid @ModelAttribute("addProductBean") SellerProductBean addProductBean,
			BindingResult result, Model model) {
//		if(result.hasErrors()) {
//			return "seller/board/plusGoods";
//		}
		addProductBean.setProduct_writer_num(loginSellerBean.getSeller_num());
		sellerProductService.addProductInfo(addProductBean);
		return "seller/board/addProduct_success";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("product_idx") int product_idx, Model model) {
		sellerProductService.deleteProductInfo(product_idx);
		return "seller/board/delete";
	}
	
	@PostMapping("/addOrder_pro")
	public String addOrder_pro(@Valid @ModelAttribute("addOrderBean") SellerOrderBean addOrderBean,
			BindingResult result, Model model) {
		addOrderBean.setSeller_num(loginSellerBean.getSeller_num());
		sellerOrderService.addSellerOrderInfo(addOrderBean);
		return "seller/board/addOrder_success";
	}
	
	@GetMapping("/modify")
	public String modify(@RequestParam("product_idx") int product_idx, Model model,
			@ModelAttribute("modifyProductBean") SellerProductBean modifyProductBean) {
		modifyProductBean.setProduct_writer_num(loginSellerBean.getSeller_num());
		model.addAttribute("product_idx", product_idx);
		
		SellerProductBean tempProductBean = sellerProductService.getProductInfo(product_idx);
		modifyProductBean.setProduct_name(tempProductBean.getProduct_name());
		modifyProductBean.setProduct_quantity(tempProductBean.getProduct_quantity());
		modifyProductBean.setProduct_weight(tempProductBean.getProduct_weight());
		modifyProductBean.setProduct_price(tempProductBean.getProduct_price());
		modifyProductBean.setProduct_description(tempProductBean.getProduct_description());
		modifyProductBean.setProduct_date(tempProductBean.getProduct_date());
		modifyProductBean.setProduct_image(tempProductBean.getProduct_image());
		modifyProductBean.setProduct_idx(product_idx);
		model.addAttribute("modifyProductBean",modifyProductBean);
		
		
		return "seller/board/modify";
	}
	
	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifyProductBean") SellerProductBean modifyProductBean,
			BindingResult result, Model model, @RequestParam("product_idx") int product_idx) {
	
		model.addAttribute("product_idx",product_idx);
		sellerProductService.modifyProductInfo(modifyProductBean);
		System.out.println("셀러 이미지 "+modifyProductBean.getProduct_image());
		return "seller/board/modify_success";
	}
}
