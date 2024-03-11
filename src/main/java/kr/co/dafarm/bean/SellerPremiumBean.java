package kr.co.dafarm.bean;

public class SellerPremiumBean {

	private int seller_num;

	private int seller_premium_chk;

	String seller_premium_date;

	public SellerPremiumBean() {
		seller_premium_chk = 0;
	}
	
	public int getSeller_num() {
		return seller_num;
	}

	public void setSeller_num(int seller_num) {
		this.seller_num = seller_num;
	}

	public int getSeller_premium_chk() {
		return seller_premium_chk;
	}

	public void setSeller_premium_chk(int seller_premium_chk) {
		this.seller_premium_chk = seller_premium_chk;
	}

	public String getSeller_premium_date() {
		return seller_premium_date;
	}

	public void setSeller_premium_date(String seller_premium_date) {
		this.seller_premium_date = seller_premium_date;
	}

}
