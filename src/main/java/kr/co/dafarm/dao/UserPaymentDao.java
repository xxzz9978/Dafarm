package kr.co.dafarm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.UserPaymentBean;
import kr.co.dafarm.mapper.UserPaymentMapper;

@Repository
public class UserPaymentDao {

	@Autowired
	UserPaymentMapper userPaymentMapper;
	/*
	// 결제창 내 로그인 되어있는 구매자의 회원 정보 가져오기 (이름/주소/전화번호 등)
	public List<UserPaymentBean> payment_user_info(int user_num){
		return userPaymentMapper.payment_user_info(user_num);
	}
	
	// 결제창 내 구매하려는 제품을 등록한 판매자의 정보 가져오기
	public List<UserPaymentBean> payment_seller_info(int user_num){
		return userPaymentMapper.payment_seller_info(user_num);
	}
	*/
	// 결제창 내 구매하려는 제품의 정보 가져오기
	public List<UserPaymentBean> payment_info(int user_num){
		return userPaymentMapper.payment_info(user_num);
	}
}
