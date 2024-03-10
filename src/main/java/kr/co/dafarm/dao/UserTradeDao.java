package kr.co.dafarm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.AdminProfitBean;
import kr.co.dafarm.bean.UserInformationBean;
import kr.co.dafarm.bean.UserProductBean;
import kr.co.dafarm.mapper.UserTradeMapper;

@Repository
public class UserTradeDao {

	@Autowired
	UserTradeMapper userTradeMapper;

	public List<UserProductBean> select_product_table() {
		return userTradeMapper.select_product_table();
	}

	public UserProductBean select_one_product_table(int product_idx) {
		return userTradeMapper.select_one_product_table(product_idx);
	}

	public List<UserInformationBean> trackingshipment(int user_num) {
		return userTradeMapper.trackingshipment(user_num);
	}
	

}
