package kr.co.dafarm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.SellerOrderBean;
import kr.co.dafarm.mapper.SellerOrderMapper;

@Repository
public class SellerOrderDao {
	
	@Autowired
	private SellerOrderMapper sellerOrderMapper;
	
	public void addSellerOrderInfo(SellerOrderBean orderBean) {
		sellerOrderMapper.addOrderInfo(orderBean);
	}
	
	public List<SellerOrderBean> getOrderListVanila(int seller_num){
		return sellerOrderMapper.getOrderListVanila(seller_num);
	}
	
	public List<SellerOrderBean> getOrderList(int seller_num, RowBounds rowBounds){
		return sellerOrderMapper.getOrderList(seller_num, rowBounds);
	}

	public List<SellerOrderBean> getOrderByStatus(int seller_num, String order_status, RowBounds rowBounds) {
		return sellerOrderMapper.getOrderByStatus(seller_num, order_status, rowBounds);
	}
	
	public List<SellerOrderBean> getOrderListByDate(int seller_num, String order_date){
		return sellerOrderMapper.getOrderListByDate(seller_num, order_date);
	}
	
	public List<SellerOrderBean> getOrderListByBetweenDate(int seller_num, String order_date_from, String order_date_to){
		return sellerOrderMapper.getOrderListByBetweenDate(seller_num, order_date_from, order_date_to);
	}
	
	public SellerOrderBean getOrderListByOrderNumber(int seller_num, int order_number) {
		return sellerOrderMapper.getOrderListByOrderNumber(seller_num, order_number);
	}
	
	public int getOrderCount(int seller_num) {
		return sellerOrderMapper.getOrderCount(seller_num);
	}
	
	public int getOrderCountByStatus(int seller_num, String order_status) {
		return sellerOrderMapper.getOrderCountByStatus(seller_num, order_status);
	}
	
	public void modifySellerOrderInfo(SellerOrderBean modifySellerOrderBean) {
		sellerOrderMapper.modifySellerOrderInfo(modifySellerOrderBean);
	}

}
