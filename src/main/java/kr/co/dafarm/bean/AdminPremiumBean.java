package kr.co.dafarm.bean;

public class AdminPremiumBean {
	
	private int seller_num;
	private boolean seller_premium_chk;
	String seller_premium_date;
	
	public int getSeller_num() {
		return seller_num;
	}
	public void setSeller_num(int seller_num) {
		this.seller_num = seller_num;
	}
	public boolean isSeller_premium_chk() {
		return seller_premium_chk;
	}
	public void setSeller_premium_chk(boolean seller_premium_chk) {
		this.seller_premium_chk = seller_premium_chk;
	}
	public String getSeller_premium_date() {
		return seller_premium_date;
	}
	public void setSeller_premium_date(String seller_premium_date) {
		this.seller_premium_date = seller_premium_date;
	}
	
	

}
