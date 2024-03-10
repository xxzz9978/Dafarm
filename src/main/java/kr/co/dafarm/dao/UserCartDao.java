package kr.co.dafarm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.UserCartBean;
import kr.co.dafarm.mapper.UserCartMapper;

@Repository
public class UserCartDao {

	@Autowired
	UserCartMapper userCartMapper;

	// 장바구니 담기
	public void addCartInfo(UserCartBean addCartBean) {
		userCartMapper.addCartInfo(addCartBean);
	}

	// 장바구니 조회
	public List<UserCartBean> select_cart_table(int user_num) {
		return userCartMapper.select_cart_table(user_num);
	}

	// 장바구니 삭제
	public void delete_cart(int cart_num, int user_num) {
		userCartMapper.delete_cart(cart_num, user_num);
	}

	// 결제 완료 이후 결제된 상품 삭제하는것
	public void paySuccess_delete(int cart_num, int user_num) {
		userCartMapper.paySuccess_delete(cart_num, user_num);
	}
}
