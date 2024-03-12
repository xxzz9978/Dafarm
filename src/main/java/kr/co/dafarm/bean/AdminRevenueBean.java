package kr.co.dafarm.bean;

import org.springframework.stereotype.Component;

@Component
public class AdminRevenueBean {
	
	String startDate;
	String endDate;
	String revenue_date;
	Integer revenue_advertising;
	Integer revenue_commission;
	Integer revenue_membership;
	Integer revenue_total;
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRevenue_date() {
		return revenue_date;
	}
	public void setRevenue_date(String revenue_date) {
		this.revenue_date = revenue_date;
	}
	public Integer getRevenue_advertising() {
		return revenue_advertising;
	}
	public void setRevenue_advertising(Integer revenue_advertising) {
		this.revenue_advertising = revenue_advertising;
	}
	public Integer getRevenue_commission() {
		return revenue_commission;
	}
	public void setRevenue_commission(Integer revenue_commission) {
		this.revenue_commission = revenue_commission;
	}
	public Integer getRevenue_membership() {
		return revenue_membership;
	}
	public void setRevenue_membership(Integer revenue_membership) {
		this.revenue_membership = revenue_membership;
	}
	public Integer getRevenue_total() {
		return revenue_total;
	}
	public void setRevenue_total(Integer revenue_total) {
		this.revenue_total = revenue_total;
	}
	
	
	
}
