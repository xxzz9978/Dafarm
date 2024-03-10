package kr.co.dafarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.UserPaymentBean;
import kr.co.dafarm.dao.UserPaymentDao;

@Service
public class UserPaymentService {

	@Autowired
	private UserPaymentDao userPaymentDao;
	/*
	// 결제창 내 로그인 되어있는 구매자의 회원 정보 가져오기 (이름/주소/전화번호 등)
	public List<UserPaymentBean> payment_user_info(int user_num) {
		return userPaymentDao.payment_user_info(user_num);
	}

	// 결제창 내 구매하려는 제품을 등록한 판매자의 정보 가져오기
	public List<UserPaymentBean> payment_seller_info(int user_num) {
		return userPaymentDao.payment_seller_info(user_num);
	}
	*/
	// 결제창 내 구매하려는 제품의 정보 가져오기
	public List<UserPaymentBean> payment_info(int user_num) {
		
		return userPaymentDao.payment_info(user_num);
	}
	
	public int getTotalPrice(int user_num) {
		List<UserPaymentBean> list = userPaymentDao.payment_info(user_num);
		int result = 0;
		
		for (UserPaymentBean userPaymentBean : list) {
			int price = Integer.parseInt(userPaymentBean.getProduct_price());
			int count = Integer.parseInt(userPaymentBean.getProduct_quantity());
			
			result += price * count;
			
		}
				return result;
	}
}
