package kr.co.dafarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.AdminOrderBean;
import kr.co.dafarm.bean.AdminProfitBean;
import kr.co.dafarm.dao.AdminTradeLogDao;

@Service
public class AdminTradeLogService {
	
	@Autowired
	AdminTradeLogDao adminTradeLogDao;
	
	public List<AdminOrderBean> all_orderLog(){
		return adminTradeLogDao.all_orderLog();
	}
	
	public AdminProfitBean select_profit(int order_number){
		return adminTradeLogDao.select_profit(order_number);
	}
	
	public AdminOrderBean select_orderLog(int order_number){
		return adminTradeLogDao.select_orderLog(order_number);
	}
	
	public AdminProfitBean select_user_info(int user_num){
		return adminTradeLogDao.select_user_info(user_num);
	}
	 public List<AdminOrderBean> main_tradeLog(){
		 return adminTradeLogDao.main_tradeLog();	 
		 }
	public	List<AdminProfitBean> main_profitLog(){
		return adminTradeLogDao.main_profitLog();
	}
	public AdminProfitBean select_seller_profit(int seller_num) {
		return adminTradeLogDao.select_profit(seller_num);
	}

}
