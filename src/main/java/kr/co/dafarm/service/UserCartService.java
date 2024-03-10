package kr.co.dafarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.UserCartBean;
import kr.co.dafarm.dao.UserCartDao;

@Service
public class UserCartService {

	@Autowired
	private UserCartDao userCartDao;
	
	// 장바구니 담기
	public void addCartInfo(UserCartBean addCartBean) {
		userCartDao.addCartInfo(addCartBean);
	}
	
	// 장바구니 조회
	public List<UserCartBean> select_cart_table(int user_num){
		return userCartDao.select_cart_table(user_num);
	}
	
	// 장바구니에서 사용자가 삭제하는것
	public void delete_cart(int cart_num, int user_num) {
		userCartDao.delete_cart(cart_num, user_num);
	}
	
	// 결제 완료 이후 결제된 상품 삭제하는것
	public void paySuccess_delete(int cart_num, int user_num) {
		userCartDao.paySuccess_delete(cart_num, user_num);
	}
}
