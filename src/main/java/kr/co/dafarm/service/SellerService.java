package kr.co.dafarm.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.AdminPremiumBean;
import kr.co.dafarm.bean.AdminSellerBoardBean;
import kr.co.dafarm.bean.SellerBean;
import kr.co.dafarm.bean.SellerPremiumBean;
import kr.co.dafarm.dao.SellerDao;

@Service
public class SellerService {

	@Autowired
	private SellerDao sellerDao;

	@Resource(name = "loginSellerBean")
	private SellerBean loginSellerBean;

	// 아이디 중복확인을 위한 Select sql문 DAO 연결
	public boolean checkSellerIdExist(String seller_id) {

		String seller_name = sellerDao.checkSellerIdExist(seller_id);

		// seller_name이 null일 경우 DB에 해당 아이디가 없다는 뜻이므로 true 반환
		if (seller_name == null) {
			return true;
		} else {
			return false;
		}
	}

	// 회원가입시 DB에 data를 입력하는 Insert DAO 연결
	public void addSellerInfo(SellerBean joinSellerBean) {

		// 회원가입 일자 seller_access_date 변수에 값 할당
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(currentDate);
		joinSellerBean.setSeller_access_date(formattedDate);

		// 최종 회원가입시 기입된 Data들 SellerBean으로 추가해줌
		sellerDao.addSellerInfo(joinSellerBean);
	}

	// 회원가입시 SellerBusiness Table Insert DAO 연결
	public void addSellerBusinessInfo(SellerBean joinSellerBean) {
		// 최종 회원가입시 기입된 Data들 SellerBean으로 추가해줌
		sellerDao.addSellerBusinessInfo(joinSellerBean);
	}

	// 아이디 로그인시 DB에 있는 data와 일치하는지 확인하여 로그인을 시도하는 Select DAO 연결
	public void getLoginSellerBean(SellerBean tempLoginSellerBean) {
		SellerBean tempLoginSellerBean2 = sellerDao.getLoginSellerInfo(tempLoginSellerBean);
		if (tempLoginSellerBean2 != null) {
			loginSellerBean.setSeller_num(tempLoginSellerBean2.getSeller_num());
			loginSellerBean.setSeller_name(tempLoginSellerBean2.getSeller_name());
			loginSellerBean.setSellerLogin(true);
		}
	}

	// 마이페이지로 진입할때 회원 정보 수정을 위해 현재 로그인 되어있는 User의 정보를 조회하는 Select DAO 연결
	public void getModifySellerInfo(SellerBean modifySellerBean) {
		// 회원 기본 정보 DAO 객체
		SellerBean tempModifySellerBean = sellerDao.getModifySellerInfo(loginSellerBean.getSeller_num());
		// 회원 사업자 정보 DAO 객체
		SellerBean tempModifySellerShopBean = sellerDao.getModifySellerShopInfo(loginSellerBean.getSeller_num());

		// 회원 기본 정보 데이터 주입
		modifySellerBean.setSeller_num(loginSellerBean.getSeller_num());
		modifySellerBean.setSeller_id(tempModifySellerBean.getSeller_id());
		modifySellerBean.setSeller_name(tempModifySellerBean.getSeller_name());
		modifySellerBean.setSeller_password(tempModifySellerBean.getSeller_password());
		modifySellerBean.setSeller_password_check(tempModifySellerBean.getSeller_password_check());
		modifySellerBean.setSeller_phone(tempModifySellerBean.getSeller_phone());
		modifySellerBean.setSeller_email(tempModifySellerBean.getSeller_email());
		modifySellerBean.setSeller_address(tempModifySellerBean.getSeller_address());

		// 회원 사업자 정보 데이터 주입
		modifySellerBean.setSeller_num(loginSellerBean.getSeller_num());
		modifySellerBean.setBusiness_name(tempModifySellerShopBean.getBusiness_name());
		modifySellerBean.setBusiness_number(tempModifySellerShopBean.getBusiness_number());
		modifySellerBean.setBusiness_report(tempModifySellerShopBean.getBusiness_report());
		modifySellerBean.setBusiness_account(tempModifySellerShopBean.getBusiness_account());

	}

	// 마이페이지에서 수정된 회원 정보를 DB에 적용하는 Update DAO 연결
	public void modifySellerInfo(SellerBean modifySellerBean) {
		modifySellerBean.setSeller_num(loginSellerBean.getSeller_num());
		sellerDao.modifySellerInfo(modifySellerBean);
		sellerDao.modifySellerShopInfo(modifySellerBean);
	}

	public List<AdminSellerBoardBean> getNoticeList() {
		return sellerDao.getNoticeList();
	}

	public void addSellerPremiumInfo(SellerPremiumBean sellerPremiumBean) {
		sellerDao.addSellerPremiumInfo(loginSellerBean.getSeller_num());
	}

	public SellerPremiumBean getSellerPremiumInfo(int seller_num) {
		return sellerDao.getSellerPremiumInfo(seller_num);
	}
}
