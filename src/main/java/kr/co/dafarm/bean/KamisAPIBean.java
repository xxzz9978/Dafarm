package kr.co.dafarm.bean;

import java.util.List;

public class KamisAPIBean {
	
	private List<List<String>> condition;
	private String error_code;
	private List<PriceKamis> price;
	public List<List<String>> getCondition() {
		return condition;
	}
	public void setCondition(List<List<String>> condition) {
		this.condition = condition;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public List<PriceKamis> getPrice() {
		return price;
	}
	public void setPrice(List<PriceKamis> price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "KamisAPIBean [condition=" + condition + ", error_code=" + error_code + ", price=" + price + "]";
	}
	
	
}
