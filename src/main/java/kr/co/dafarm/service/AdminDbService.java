package kr.co.dafarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.AdminPremiumBean;
import kr.co.dafarm.bean.AdminProductBean;
import kr.co.dafarm.bean.AdminRevenueBean;
import kr.co.dafarm.bean.AdminSellerBean;
import kr.co.dafarm.bean.AdminSellerProfitBean;
import kr.co.dafarm.bean.AdminUserBean;
import kr.co.dafarm.dao.AdminRevenueDao;
import kr.co.dafarm.dao.AdminSellerDao;
import kr.co.dafarm.dao.AdminUserDao;

@Service
public class AdminDbService {

	@Autowired
	private AdminRevenueDao adminRevenueDao;
	@Autowired
	private AdminUserDao adminUserDao;
	@Autowired
	private AdminSellerDao adminSellerDao;
	
	public List<AdminUserBean> getUserList() {
		return adminUserDao.getUserList();
	}
	
	public List<AdminUserBean> getDashboardUserList() {
		return adminUserDao.getDashboardUserList();
	}
	
	public List<AdminUserBean> select_buyer_count_week() {
		return adminUserDao.select_buyer_count_week();
	}
	
	public List<AdminUserBean> select_buyer_count_month() {
		return adminUserDao.select_buyer_count_month();
	}
	
	public List<AdminUserBean> selected_date_buyer(String startDate, String endDate) {
		return adminUserDao.selected_date_buyer(startDate, endDate);
	}
	
	public AdminUserBean select_user_info(int user_num) {
		return adminUserDao.select_user_info(user_num);
	}
	
	
	
	public List<AdminSellerBean> getSellerList() {
		return adminSellerDao.getSellerList();
	}
	
	public List<AdminSellerBean> select_seller_count_week(){
		return adminSellerDao.select_seller_count_week();
	}
	
	public List<AdminSellerBean> select_seller_count_month(){
		return adminSellerDao.select_seller_count_month();
	}
	
	public List<AdminSellerBean> selected_date_seller(String startDate, String endDate){
		return adminSellerDao.selected_date_seller(startDate, endDate);
	}

	public List<AdminSellerBean> getDashboardSellerList() {
		return adminSellerDao.getDashboardSellerList();
	}
	
	public AdminSellerBean select_seller_info(int seller_num){
		return adminSellerDao.select_seller_info(seller_num);
	}
	public AdminSellerBean select_bussiness_info(int seller_num){
		return adminSellerDao.select_bussiness_info(seller_num);
	}
	
	public List<AdminSellerProfitBean> select_seller_profit_week(){
		return adminSellerDao.select_seller_profit_week();
	}
	
	public List<AdminSellerProfitBean> select_seller_profit_month(){
		return adminSellerDao.select_seller_profit_month();
	}
	
	public List<AdminSellerProfitBean> selected_date_seller_profit(String startDate, String endDate){
		return adminSellerDao.selected_date_seller_profit(startDate, endDate);
	}
	
	public List<AdminProductBean> selected_product(int seller_num){
		return adminSellerDao.selected_product(seller_num);
	}
	
	
	
	public List<AdminRevenueBean> select_date(String startDate, String endDate){
		return adminRevenueDao.select_date(startDate, endDate);
	}
	
	public List<AdminRevenueBean> one_week_revenue(){
		return adminRevenueDao.one_week_revenue();
	}
	
	public List<AdminRevenueBean> one_month_revenue(){
		return adminRevenueDao.one_month_revenue();
	}
	
	public void modify_user(AdminUserBean adminUserBean) {
		adminUserDao.modify_user(adminUserBean);
	}
	
	public void modify_seller(AdminSellerBean adminModifySellerBean) {
		adminSellerDao.modify_seller(adminModifySellerBean);
	}
	public void modify_bussiness(AdminSellerBean adminModifySellerBean) {
		adminSellerDao.modify_bussiness(adminModifySellerBean);
	}
	
	public void delete_seller(int seller_num) {
		adminSellerDao.delete_seller(seller_num);
	}
	
	public void delete_business(int seller_num) {
		adminSellerDao.delete_business(seller_num);
	}
	
	public void delete_user(int user_num) {
		adminUserDao.delete_user(user_num);
	}
	public AdminPremiumBean select_premium(int seller_num) {

		return adminSellerDao.select_premium(seller_num);

		

	}
	

	
}