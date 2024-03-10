package kr.co.dafarm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.AdminRevenueBean;
import kr.co.dafarm.mapper.AdminRevenueMapper;

@Repository
public class AdminRevenueDao {
	
	@Autowired
	private AdminRevenueMapper adminRevenueMapper;
	
	public List<AdminRevenueBean> select_date(String startDate, String endDate){
		return adminRevenueMapper.selected_date_revenue(startDate, endDate);
	}
	
	public List<AdminRevenueBean> one_week_revenue(){
		return adminRevenueMapper.one_week_revenue();
	}
	
	public List<AdminRevenueBean> one_month_revenue(){
		return adminRevenueMapper.one_month_revenue();
	}

}
