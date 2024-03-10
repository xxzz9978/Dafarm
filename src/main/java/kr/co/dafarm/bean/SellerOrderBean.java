package kr.co.dafarm.bean;

public class SellerOrderBean {

	private int order_number;

	private String order_status;

	private String order_date;

	private String delivery_company;

	private String delivery_number;

	private String seller_name;

	private String seller_phone;

	private String item_name;

	private String user_name;

	private String user_phone;

	private String address;

	private int seller_num;

	private int user_num;

	//----- Getter / Setter ------------------------------------------------------------
	
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

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
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

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	public String getSeller_phone() {
		return seller_phone;
	}

	public void setSeller_phone(String seller_phone) {
		this.seller_phone = seller_phone;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSeller_num() {
		return seller_num;
	}

	public void setSeller_num(int seller_num) {
		this.seller_num = seller_num;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

}
