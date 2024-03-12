package kr.co.dafarm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.AdminPremiumBean;
import kr.co.dafarm.bean.AdminProductBean;
import kr.co.dafarm.bean.AdminSellerBean;
import kr.co.dafarm.bean.AdminSellerProfitBean;
import kr.co.dafarm.mapper.AdminSellerMapper;

@Repository
public class AdminSellerDao {
	
	@Autowired
	private AdminSellerMapper sellerMapper;

	public List<AdminSellerBean> getSellerList() {
		return sellerMapper.select_data();
	}

	public List<AdminSellerBean> getDashboardSellerList() {
		return sellerMapper.select_dashboard_List();
	}
	
	public List<AdminSellerBean> select_seller_count_week(){
		return sellerMapper.select_seller_count_week();
	}
	public AdminSellerBean select_seller_info(int seller_num) {
		return sellerMapper.select_seller_info(seller_num);
	}
	
	public AdminSellerBean select_bussiness_info(int seller_num) {
		return sellerMapper.select_business_info(seller_num);
	}
	
	public void modify_seller(AdminSellerBean adminModifySellerBean) {
		sellerMapper.modify_seller(adminModifySellerBean);
	}
	public void modify_bussiness(AdminSellerBean adminModifySellerBean) {
		sellerMapper.modify_business(adminModifySellerBean);
	}
	
	public List<AdminSellerBean> select_seller_count_month(){
		return sellerMapper.select_seller_count_month();
	}
	
	public List<AdminSellerBean> selected_date_seller(String startDate, String endDate){
		return sellerMapper.selected_date_seller(startDate, endDate);
	}
	
	public void delete_seller(int seller_num) {
		sellerMapper.delete_seller(seller_num);
	}
	
	public void delete_business(int seller_num) {
		sellerMapper.delete_business(seller_num);
	}
	
	public List<AdminSellerProfitBean> select_seller_profit_week(){
		return sellerMapper.select_seller_profit_week();
	}
	
	public List<AdminSellerProfitBean> select_seller_profit_month(){
		return sellerMapper.select_seller_profit_month();
	}
	
	public List<AdminSellerProfitBean> selected_date_seller_profit(String startDate, String endDate){
		return sellerMapper.selected_date_seller_profit(startDate, endDate);
	}
	
	public AdminPremiumBean select_premium(int seller_num) {
		return sellerMapper.select_premium(seller_num);
	}
	
	public List<AdminProductBean> selected_product(int seller_num){
		return sellerMapper.selected_product(seller_num);
	}
	
	
}
