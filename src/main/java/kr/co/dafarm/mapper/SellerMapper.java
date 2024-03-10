package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.dafarm.bean.AdminSellerBoardBean;
import kr.co.dafarm.bean.SellerBean;

public interface SellerMapper {
	
	// Seller 아이디 중복확인
	@Select("select seller_name " + "from seller_table " +
	"where seller_id = #{seller_id}")
	String checkSellerIdExist(String seller_id);
	
	// Seller 회원가입
	@Insert("insert into seller_table(seller_num, seller_name, seller_id, seller_password, " + 
	"seller_phone, seller_email, seller_address, seller_access_date) " +
	"values (seller_seq.nextval, #{seller_name}, #{seller_id}, #{seller_password}, " + 
	"#{seller_phone}, #{seller_email}, #{seller_address}, #{seller_access_date}) ")
	void addSellerInfo(SellerBean joinSellerBean);
	
	// Seller 회원가입시 Seller_Business Table에도 동시 Insert
	@Insert("insert into seller_business_table(business_name, business_number, business_report, business_account, seller_num) " +
	"values (#{business_name}, #{business_number}, #{business_report}, #{business_account}, seller_business_seq.nextval)")
	void addSellerBusinessInfo(SellerBean joinSellerBean);
	
	// Seller 로그인
	@Select("select seller_num, seller_name " + "from seller_table " +
	"where seller_id=#{seller_id} and seller_password=#{seller_password}")
	SellerBean getLoginSellerInfo(SellerBean tempLoginSellerBean);
	
	// Seller 회원정보 페이지 진입시 로그인 되어있는 Seller 회원 정보 가져오기
	@Select("select seller_name, seller_id, seller_password, seller_phone, seller_email, seller_address " + 
			"from seller_table " + 
			"where seller_num = #{seller_num}")
	SellerBean getModifySellerInfo(int seller_num);
	
	// Seller 회원정보 페이지 진입시 로그인 되어있는 Seller 회원 정보 중 사업자 정보 가져오기
	@Select("select business_name, business_number, business_report, business_account "+
			"from seller_business_table " +
			"where seller_num = #{seller_num}")
	SellerBean getModifySellerShopInfo(int seller_num);
	
	// Seller 회원정보 수정시 업데이트
	@Update("update seller_table " + 
			"set seller_name = #{seller_name}, seller_id = #{seller_id}, " +
			"seller_password = #{seller_password}, " +
			"seller_phone = #{seller_phone}, " +
			"seller_email = #{seller_email}, seller_address = #{seller_address} " +
			"where seller_num = #{seller_num}")
	void modifySellerInfo(SellerBean modifySellerBean);
	
	@Update("update seller_business_table " +
			"set business_name = #{business_name}, business_number = #{business_number}, " + 
			"business_report = #{business_report}, business_account = #{business_account} "+
			"where seller_num = #{seller_num}")
	void modifySellerShopInfo(SellerBean modifySellerBean);
	
	@Select("select * from seller_board")
	List<AdminSellerBoardBean> getNoticeList();
	
	// 구매자 특정 글 확인
	@Select("select * from seller_board where seller_board_num = #{seller_board_num}")
	AdminSellerBoardBean select_one_seller_board(int seller_board_num);
}
