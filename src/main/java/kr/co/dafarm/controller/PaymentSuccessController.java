package kr.co.dafarm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dafarm.bean.ProfitBean;
import kr.co.dafarm.bean.SellerOrderBean;
import kr.co.dafarm.bean.UserBean;
import kr.co.dafarm.bean.UserPaymentBean;
import kr.co.dafarm.service.ProfitService;
import kr.co.dafarm.service.SellerOrderService;
import kr.co.dafarm.service.SellerProductService;
import kr.co.dafarm.service.UserCartService;
import kr.co.dafarm.service.UserPaymentService;

@Controller
@RequestMapping("/users/trade")
public class PaymentSuccessController {

	@Autowired
	private SellerOrderService sellerOrderService;

	@Autowired
	private SellerProductService sellerProductService;

	@Autowired
	private UserCartService userCartService;

	@Autowired
	private UserPaymentService userPaymentService;

	@Autowired
	private ProfitService profitSerivce;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/payment_success")
	public String addSellerOrderInfo(SellerOrderBean orderBean, Model model) {

		List<UserPaymentBean> payment_info = userPaymentService.payment_info(loginUserBean.getUser_num());

		ProfitBean profitBean = new ProfitBean();

		for (int i = 0; i < payment_info.size(); i++) {

			orderBean.setSeller_name(payment_info.get(i).getSeller_name());
			orderBean.setSeller_phone(payment_info.get(i).getSeller_phone());
			orderBean.setItem_name(payment_info.get(i).getProduct_name());
			orderBean.setUser_name(payment_info.get(i).getUser_name());
			orderBean.setUser_phone(payment_info.get(i).getUser_phone());
			orderBean.setAddress(payment_info.get(i).getUser_address());
			orderBean.setSeller_num(payment_info.get(i).getSeller_num());
			orderBean.setUser_num(payment_info.get(i).getUser_num());

			// 상품이 결제된 일자 OrderDate에 넣어줌
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = dateFormat.format(currentDate);
			orderBean.setOrder_date(formattedDate);

			// Seller Order Table에 주문 내역 Insert
			sellerOrderService.addSellerOrderInfo(orderBean);

			// Seller Profit Table에 위에서 Insert한 주문에 대한 수익 값 계산 및 Set
			int price = Integer.parseInt(payment_info.get(i).getProduct_price());
			int quantity = Integer.parseInt(payment_info.get(i).getProduct_quantity());
			String total_price = Integer.toString(price * quantity);

			profitBean.setSeller_num(orderBean.getSeller_num());
			profitBean.setSeller_profit(total_price);
			profitBean.setGen_date(orderBean.getOrder_date());

			// Seller Profit Table에 판매자 번호, 주문 번호 그리고 그에 해당하는 계산된 수익값, 거래가 성사된 일자 Insert
			profitSerivce.addProfit(profitBean);

			// 결제 완료 된 판매자의 상품을 상품 등록 테이블에서 삭제
			sellerProductService.deleteProduct_payComp(payment_info.get(i).getProduct_idx());

			// Seller Order Table과 Profit Table에 Insert 이후 해당 결제 처리된 User의 장바구니 내역에 대해
			// Delete
			userCartService.paySuccess_delete(payment_info.get(i).getCart_num(), payment_info.get(i).getUser_num());

		} // for

		return "users/trade/payment_success";
	}

}
