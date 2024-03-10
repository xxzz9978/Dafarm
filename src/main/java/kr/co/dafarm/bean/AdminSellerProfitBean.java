package kr.co.dafarm.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AdminSellerProfitBean {

	private int seller_num;
	private int order_number;
	private String seller_profit;
	private String gen_date;
	private int sum_seller_profit;
	private String startDate;
	private String endDate;
	
}
