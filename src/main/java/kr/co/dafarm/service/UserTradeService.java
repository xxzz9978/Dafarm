package kr.co.dafarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.UserInformationBean;
import kr.co.dafarm.bean.UserProductBean;
import kr.co.dafarm.dao.UserTradeDao;

@Service
public class UserTradeService {

	@Autowired
	private UserTradeDao userTradeDao;

	public List<UserProductBean> select_product_table() {
		return userTradeDao.select_product_table();
	}

	public UserProductBean select_one_product_table(int product_idx) {
		return userTradeDao.select_one_product_table(product_idx);
	}

	public List<UserInformationBean> trackingshipment(int user_num) {
		return userTradeDao.trackingshipment(user_num);
	}
	
}
