package kr.co.dafarm.bean;

import org.springframework.stereotype.Component;

@Component
public class AdminProfitBean {

	private int seller_num;
	private int order_number;
	private String seller_profit;
	private String gen_date;
	
	private int orderCount;
	
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(int totalProfit) {
		this.totalProfit = totalProfit;
	}
	private int totalProfit;
	
	// == Getter / Setter ========================================================
	
	public int getSeller_num() {
		return seller_num;
	}
	public void setSeller_num(int seller_num) {
		this.seller_num = seller_num;
	}
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	public String getSeller_profit() {
		return seller_profit;
	}
	public void setSeller_profit(String seller_profit) {
		this.seller_profit = seller_profit;
	}
	public String getGen_date() {
		return gen_date;
	}
	public void setGen_date(String gen_date) {
		this.gen_date = gen_date;
	}
	
	
	
	
}
