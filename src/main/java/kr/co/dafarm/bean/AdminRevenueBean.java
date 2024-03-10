package kr.co.dafarm.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AdminRevenueBean {
	
	String startDate;
	String endDate;
	String revenue_date;
	Integer revenue_advertising;
	Integer revenue_commission;
	Integer revenue_membership;
	Integer revenue_total;
	
}
