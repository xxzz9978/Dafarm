package kr.co.dafarm.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class AdminSellerProfitBean {

	private int seller_num;
	private int order_number;
	private String seller_profit;
	private String gen_date;
	private int sum_seller_profit;
	private String startDate;
	private String endDate;
	
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
	public int getSum_seller_profit() {
		return sum_seller_profit;
	}
	public void setSum_seller_profit(int sum_seller_profit) {
		this.sum_seller_profit = sum_seller_profit;
	}
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

}
