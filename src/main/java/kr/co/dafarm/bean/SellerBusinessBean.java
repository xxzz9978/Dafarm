package kr.co.dafarm.bean;

public class SellerBusinessBean {
	
	private String business_name; //사업자명
	private String business_number; //사업자번호
	private boolean business_report; //통신판매업신고
	private String business_account; //사업자 계좌번호
	
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getBusiness_number() {
		return business_number;
	}
	public void setBusiness_number(String business_number) {
		this.business_number = business_number;
	}
	public Boolean getBusiness_report() {
		return business_report;
	}
	public void setBusiness_report(Boolean business_report) {
		this.business_report = business_report;
	}
	public String getBusiness_account() {
		return business_account;
	}
	public void setBusiness_account(String business_account) {
		this.business_account = business_account;
	}
	
	
}
