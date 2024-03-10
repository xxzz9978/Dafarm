package kr.co.dafarm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.dafarm.bean.AdminRevenueBean;
import kr.co.dafarm.bean.AdminSellerBean;
import kr.co.dafarm.bean.AdminSellerProfitBean;
import kr.co.dafarm.bean.AdminUserBean;
import kr.co.dafarm.service.AdminDbService;

@RestController
@Component
public class ChartDateController extends HttpServlet {

	@Autowired
	AdminDbService adminDbService;
	
	// AdminChart.jsp에 사용하는 수익 테이블
	@PostMapping("/Admin/chart/adminRevenueDate")
	protected void adminRevenueDate(@RequestBody AdminRevenueBean bean, HttpServletResponse resp)
			throws ServletException, IOException {
		String startDate = bean.getStartDate();
		String endDate = bean.getEndDate();

		System.out.println(startDate);
		System.out.println(endDate);

		List<AdminRevenueBean> data = adminDbService.select_date(startDate, endDate);
		
		// 데이터를 JSON 형식으로 변환하여 응답합니다.
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}
	
	@PostMapping("/Admin/chart/adminSellerProfitDate")
	protected void adminSellerProfitDate(@RequestBody AdminSellerProfitBean bean, HttpServletResponse resp)
			throws ServletException, IOException {
		String startDate = bean.getStartDate();
		String endDate = bean.getEndDate();
		List<AdminSellerProfitBean> data = adminDbService.selected_date_seller_profit(startDate, endDate);
		
		resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}
	
	// AdminChart.jsp에 사용하는 구매자 테이블
	@PostMapping("/Admin/chart/adminSellerDate")
	protected void adminSellerDate(@RequestBody AdminSellerBean bean, HttpServletResponse resp)
			throws ServletException, IOException {
		String startDate = bean.getStartDate();
		String endDate = bean.getEndDate();
		List<AdminSellerBean> data = adminDbService.selected_date_seller(startDate, endDate);
		
		resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}
	
	@PostMapping("/Admin/chart/adminBuyerDate")
	protected void adminBuyerDate(@RequestBody AdminUserBean bean, HttpServletResponse resp)
			throws ServletException, IOException {
		String startDate = bean.getStartDate();
		String endDate = bean.getEndDate();
		List<AdminUserBean> data = adminDbService.selected_date_buyer(startDate, endDate);
		
		resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}
	
	
	@PostMapping("/Admin/chart/adminTotalWeek")
	protected void AdminRevenueWeek(@RequestBody AdminRevenueBean bean, HttpServletResponse resp)
	        throws ServletException, IOException {
	    List<AdminRevenueBean> data = adminDbService.one_week_revenue();

	    // 데이터를 JSON 형식으로 변환하여 응답합니다.
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}
	
	@PostMapping("/Admin/chart/adminSellerProfitWeek")
	protected void AdminSellerProfitWeek(@RequestBody AdminSellerProfitBean bean, HttpServletResponse resp)
	        throws ServletException, IOException {
	    List<AdminSellerProfitBean> data = adminDbService.select_seller_profit_week();

	    // 데이터를 JSON 형식으로 변환하여 응답합니다.
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}
	
	@PostMapping("/Admin/chart/adminSellerWeek")
	protected void AdminSellerWeek(@RequestBody AdminSellerBean bean, HttpServletResponse resp)
	        throws ServletException, IOException {
	    List<AdminSellerBean> data = adminDbService.select_seller_count_week();

	    // 데이터를 JSON 형식으로 변환하여 응답합니다.
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}
	
	@PostMapping("/Admin/chart/adminBuyerWeek")
	protected void AdminBuyerWeek(@RequestBody AdminUserBean bean, HttpServletResponse resp)
	        throws ServletException, IOException {
	    List<AdminUserBean> data = adminDbService.select_buyer_count_week();

	    // 데이터를 JSON 형식으로 변환하여 응답합니다.
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}
	
	@PostMapping("/Admin/chart/adminTotalMonth")
	protected void AdminRevenueMonth(@RequestBody AdminRevenueBean bean, HttpServletResponse resp)
	        throws ServletException, IOException {
	    List<AdminRevenueBean> data = adminDbService.one_month_revenue();

	    // 데이터를 JSON 형식으로 변환하여 응답합니다.
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}
	
	@PostMapping("/Admin/chart/adminSellerProfitMonth")
	protected void AdminSellerProfitMonth(@RequestBody AdminSellerProfitBean bean, HttpServletResponse resp)
	        throws ServletException, IOException {
	    List<AdminSellerProfitBean> data = adminDbService.select_seller_profit_month();

	    // 데이터를 JSON 형식으로 변환하여 응답합니다.
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}
	
	@PostMapping("/Admin/chart/adminSellerMonth")
	protected void AdminSellerMonth(@RequestBody AdminSellerBean bean, HttpServletResponse resp)
	        throws ServletException, IOException {
	    List<AdminSellerBean> data = adminDbService.select_seller_count_month();

	    // 데이터를 JSON 형식으로 변환하여 응답합니다.
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}
	
	@PostMapping("/Admin/chart/adminBuyerMonth")
	protected void AdminBuyerMonth(@RequestBody AdminUserBean bean, HttpServletResponse resp)
	        throws ServletException, IOException {
	    List<AdminUserBean> data = adminDbService.select_buyer_count_month();

	    // 데이터를 JSON 형식으로 변환하여 응답합니다.
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}

	@PostMapping("/Admin/adminDashboardTotal")
	protected void dashboardTotalChart(@RequestBody AdminRevenueBean bean, HttpServletResponse resp)
	        throws ServletException, IOException {
	    List<AdminRevenueBean> data = adminDbService.one_week_revenue();

	    // 데이터를 JSON 형식으로 변환하여 응답합니다.
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}
	
	@PostMapping("/Admin/adminDashboardSeller")
	protected void dashboardSellerChart(@RequestBody AdminSellerBean bean, HttpServletResponse resp)
			throws ServletException, IOException {
		List<AdminSellerBean> data = adminDbService.select_seller_count_week();
		
		resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
	}

}