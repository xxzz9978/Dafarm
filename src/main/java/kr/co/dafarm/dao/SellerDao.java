package kr.co.dafarm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.AdminSellerBoardBean;
import kr.co.dafarm.bean.SellerBean;
import kr.co.dafarm.bean.SellerPremiumBean;
import kr.co.dafarm.mapper.SellerMapper;

@Repository
public class SellerDao {
	
	@Autowired
	private SellerMapper sellerMapper;
	
	// 아이디 중복확인을 위한 Select sql문 반환
	public String checkSellerIdExist(String seller_id) {
		return sellerMapper.checkSellerIdExist(seller_id);
	}
	
	// 회원가입시 DB에 data를 입력하는 Insert sql문 반환
	public void addSellerInfo(SellerBean joinSellerBean) {
		sellerMapper.addSellerInfo(joinSellerBean);
	}

	// 회원가입시 Seller 사업자 관련 정보도 Insert를 같이 해주기 위함
	public void addSellerBusinessInfo(SellerBean joinSellerBean) {
		sellerMapper.addSellerBusinessInfo(joinSellerBean);
	}
	
	// 아이디 로그인시 DB에 있는 data와 일치하는지 확인하여 로그인을 시도하는 Select sql문 반환
	public SellerBean getLoginSellerInfo(SellerBean tempLoginSellerBean) {
		return sellerMapper.getLoginSellerInfo(tempLoginSellerBean);
	}
	
	// 마이페이지로 진입할때 회원 정보 수정을 위해 현재 로그인 되어있는 User의 정보를 조회하는 Select sql문 반환
	public SellerBean getModifySellerInfo(int seller_num){
		return sellerMapper.getModifySellerInfo(seller_num);
		}
	
	// 마이페이지로 진입할때 회원 정보 수정을 위해 현재 로그인 되어있는 User의 사업자 정보를 조회하는 Select sql문 반환
	public SellerBean getModifySellerShopInfo(int seller_num) {
		return sellerMapper.getModifySellerShopInfo(seller_num);
	}
	
	// 마이페이지에서 수정된 회원 정보를 DB에 적용하는 Update sql문 반환
	public void modifySellerInfo(SellerBean modifySellerBean) {
		sellerMapper.modifySellerInfo(modifySellerBean);
	}
	
	// 마이페이지에서 수정된 회원 사업자 정보를 DB에 적용하는 Update sql문 반환
	public void modifySellerShopInfo(SellerBean modifySellerBean) {
		sellerMapper.modifySellerShopInfo(modifySellerBean);
	}
	
	public List<AdminSellerBoardBean> getNoticeList(){
		return sellerMapper.getNoticeList();
	}
	
	public void addSellerPremiumInfo(int seller_num) {
		sellerMapper.addSellerPremiumInfo(seller_num);
	}
	
	public SellerPremiumBean getSellerPremiumInfo(int seller_num) {
		return sellerMapper.getSellerPremiumInfo(seller_num);
	}
}
