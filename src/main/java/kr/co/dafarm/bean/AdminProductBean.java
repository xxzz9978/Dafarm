package kr.co.dafarm.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AdminProductBean {

	private String product_name;
	private String product_price;
	private String product_weight;
	private String product_quantity;
	private String product_image;
	private String product_description;
	private String agreement;
	private int product_writer_num;
	private int product_idx;
	private String product_date;
	
}
