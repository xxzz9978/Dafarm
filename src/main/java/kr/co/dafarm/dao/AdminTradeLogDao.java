package kr.co.dafarm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.AdminOrderBean;
import kr.co.dafarm.bean.AdminProfitBean;
import kr.co.dafarm.mapper.AdminTradeLogMapper;

@Repository
public class AdminTradeLogDao {

	@Autowired
	AdminTradeLogMapper adminTradeLogMapper;
	
	public List<AdminOrderBean> all_orderLog(){
		return adminTradeLogMapper.all_orderLog();
	}
	
	public AdminProfitBean select_profit(int order_number){
		return adminTradeLogMapper.select_profit(order_number);
	}
	
	public AdminOrderBean select_orderLog(int order_number){
		return adminTradeLogMapper.select_orderLog(order_number);
	}
	
	public AdminProfitBean select_user_info(int user_num){
		return adminTradeLogMapper.select_user_info(user_num);
	}
	
	public List<AdminOrderBean> main_tradeLog(){
		return adminTradeLogMapper.main_tradeLog();	 
	}
	
	public List<AdminProfitBean> main_profitLog(){
		return adminTradeLogMapper.main_profitLog();
	}
	
	public AdminProfitBean select_seller_profit(int seller_num) {
		return adminTradeLogMapper.select_profit(seller_num);
	}
	
	public List<AdminOrderBean> selected_orderLog(int seller_num){
		return adminTradeLogMapper.selected_orderLog(seller_num);
	}
	
	public List<AdminProfitBean> selected_profitLog(int seller_num){
		return adminTradeLogMapper.selected_profitLog(seller_num);
	}
	
}
