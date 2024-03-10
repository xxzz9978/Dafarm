package kr.co.dafarm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.AdminUserBean;
import kr.co.dafarm.mapper.AdminUserMapper;

@Repository
public class AdminUserDao {
	
	@Autowired
	private AdminUserMapper userMapper;
	
	
	public List<AdminUserBean> getUserList() {
		return userMapper.select_data();
	}
	
	public List<AdminUserBean> getDashboardUserList() {
		return userMapper.select_dashboard_List();
	}
	
	public List<AdminUserBean> select_buyer_count_week() {
		return userMapper.select_buyer_count_week();
	}
	
	public List<AdminUserBean> select_buyer_count_month() {
		return userMapper.select_buyer_count_month();
	}
	
	public List<AdminUserBean> selected_date_buyer(String startDate, String endDate){
		return userMapper.selected_date_buyer(startDate, endDate);
	}
	
	public AdminUserBean select_user_info(int user_num) {
		return userMapper.select_user_info(user_num);
	}
	
	public void modify_user(AdminUserBean adminUserBean) {
		userMapper.modify_user(adminUserBean);
	}
	
	public void delete_user(int user_num) {
		userMapper.delete_user(user_num);
	}
	
}
