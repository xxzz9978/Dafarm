package kr.co.dafarm.bean;

import org.springframework.web.multipart.MultipartFile;

public class SellerProductBean {

	private MultipartFile upload_file; // 업로드 파일
	private int product_idx;// 상품 등록 번호
	private String product_name; // 상품 명
	private String product_price; // 상품 가격
	private String product_weight; // 상품 무게
	private String product_quantity; // 상품 수량
	private String product_image; // 상품 이미지 등록
	private String product_description; // 상품 설명
	private boolean agreement; // 정보 제공 고시
	private int product_writer_num; // 상품등록 작성자 번호 = 회원 고유 번호
	private String product_date; // 상품 등록 일자
	private String business_name;

	public String getBusiness_name() {
		return business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public String getProduct_weight() {
		return product_weight;
	}

	public void setProduct_weight(String product_weight) {
		this.product_weight = product_weight;
	}

	public String getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public boolean isAgreement() {
		return agreement;
	}

	public void setAgreement(boolean agreement) {
		this.agreement = agreement;
	}

	public MultipartFile getUpload_file() {
		return upload_file;
	}

	public void setUpload_file(MultipartFile upload_file) {
		this.upload_file = upload_file;
	}

	public int getProduct_writer_num() {
		return product_writer_num;
	}

	public void setProduct_writer_num(int product_writer_num) {
		this.product_writer_num = product_writer_num;
	}

	public int getProduct_idx() {
		return product_idx;
	}

	public void setProduct_idx(int product_idx) {
		this.product_idx = product_idx;
	}

	public String getProduct_date() {
		return product_date;
	}

	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}

}
