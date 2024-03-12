package kr.co.dafarm.bean;

public class ModifyOrderBean {

	private int order_number;
	
	private String order_status;
	
	private String delivery_company;
	
	private String delivery_number;

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getDelivery_company() {
		return delivery_company;
	}

	public void setDelivery_company(String delivery_company) {
		this.delivery_company = delivery_company;
	}

	public String getDelivery_number() {
		return delivery_number;
	}

	public void setDelivery_number(String delivery_number) {
		this.delivery_number = delivery_number;
	}
	
	
}
