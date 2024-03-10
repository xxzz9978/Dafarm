package kr.co.dafarm.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AdminSellerBean {
   
   public AdminSellerBean() {
      this.sellerIdExist=false;
      this.sellerLogin=false;
   }
   
   private int seller_num;
   
   @Size(min=8, max=20)
   @Pattern(regexp = "[a-zA-Z0-9]*")
   private String seller_id;             //판매자 아이디
   
   @Size(min=8, max=20)
   @Pattern(regexp = "[a-zA-Z0-9]*")
   private String seller_password;          //판매자 비밀번호
   
   @Size(min=8, max=20)
   @Pattern(regexp = "[a-zA-Z0-9]*")
   private String seller_password_check;    //판매자 비밀번호 확인
   
   @Size(min=2, max=6)
   @Pattern(regexp = "[가-힣]*")
   private String seller_name;          //판매자 이름
   
   private String seller_address;          //판매자 주소
   
   @Pattern(regexp = "^[0-9]+$")
   private String seller_phone;          //판매자 핸드폰번호
   
   @Email
   private String seller_email;          //판매자 이메일
   
   private String seller_access_date;      // 판매자 회원가입 일자
   
   private String startDate; // 관리자 DB에 사용 할 날짜 범위 시작 날짜
   
   private String endDate;	// 관리자 DB에 사용 할 날짜 범위 끝 날짜
   
   private boolean sellerIdExist;          // 회원가입시 아이디 중복확인 

   private boolean sellerLogin;         // 회원 로그인 상태 확인
   
   private int seller_count; // 회원 수
   
   private String business_name; //사업자명
   
   private String business_number; //사업자번호
   
   private boolean business_report; //통신판매업신고
   
   private String business_account; //사업자 계좌번호
   

   //----- Getter / Setter ------------------------------------------------------------

   public int getSeller_num() {
      return seller_num;
   }

   public void setSeller_num(int seller_num) {
      this.seller_num = seller_num;
   }

   public String getSeller_id() {
      return seller_id;
   }

   public void setSeller_id(String seller_id) {
      this.seller_id = seller_id;
   }

   public String getSeller_password() {
      return seller_password;
   }

   public void setSeller_password(String seller_password) {
      this.seller_password = seller_password;
   }

   public String getSeller_password_check() {
      return seller_password_check;
   }

   public void setSeller_password_check(String seller_password_check) {
      this.seller_password_check = seller_password_check;
   }

   public String getSeller_name() {
      return seller_name;
   }

   public void setSeller_name(String seller_name) {
      this.seller_name = seller_name;
   }

   public String getSeller_address() {
      return seller_address;
   }

   public void setSeller_address(String seller_address) {
      this.seller_address = seller_address;
   }

   public String getSeller_phone() {
      return seller_phone;
   }

   public void setSeller_phone(String seller_phone) {
      this.seller_phone = seller_phone;
   }

   public String getSeller_email() {
      return seller_email;
   }

   public void setSeller_email(String seller_email) {
      this.seller_email = seller_email;
   }

   public String getSeller_access_date() {
      return seller_access_date;
   }

   public void setSeller_access_date(String seller_access_date) {
      this.seller_access_date = seller_access_date;
   }

   public boolean isSellerIdExist() {
      return sellerIdExist;
   }

   public void setSellerIdExist(boolean sellerIdExist) {
      this.sellerIdExist = sellerIdExist;
   }

   public boolean isSellerLogin() {
      return sellerLogin;
   }

   public void setSellerLogin(boolean sellerLogin) {
      this.sellerLogin = sellerLogin;
   }
   
   public int getSeller_count() {
	  return seller_count;
   }

   public void setSeller_count(int seller_count) {
	  this.seller_count = seller_count;
   }
   
   public String getStartDate() {
      return startDate;
   }

   public void setStartDate(String startDate) {
	  this.startDate = startDate;
   }

   public String getEndDate() {
	   return endDate;
   }

   public void setEndDate(String endDate) {
	   this.endDate = endDate;
   }

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