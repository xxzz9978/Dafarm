package kr.co.dafarm.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.OrderPageBean;
import kr.co.dafarm.bean.SellerBean;
import kr.co.dafarm.bean.SellerOrderBean;
import kr.co.dafarm.bean.UserBean;
import kr.co.dafarm.dao.SellerOrderDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class SellerOrderService {

	@Autowired
	private SellerOrderDao sellerOrderDao;

	@Resource(name = "loginSellerBean")
	private SellerBean loginSellerBean;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@Value("${page.listcnt}")
	private int page_listcnt;

	@Value("${page.paginationcnt}")
	private int page_paginationcnt;

	public void addSellerOrderInfo(SellerOrderBean orderBean) {
		sellerOrderDao.addSellerOrderInfo(orderBean);
	}

	public List<SellerOrderBean> getOrderList(int seller_num, String order_status, int orderPage) {

		int start = (orderPage - 1) * page_listcnt;
		// 1페이지일 때, 0번 인덱스 글부터 시작(0~9)
		// 2페이지일 때, 10번 인덱스 글부터 시작(10~19)
		// 3페이지일 때 , 20번 인덱스 글부터 시작(20~29)
		RowBounds rowBounds = new RowBounds(start, page_listcnt);

		if (order_status.equals("전체")) {

			return sellerOrderDao.getOrderList(seller_num, rowBounds);
		} else {

			return sellerOrderDao.getOrderByStatus(seller_num, order_status, rowBounds);
		}

	}
	
	public List<SellerOrderBean> getOrderListVanila(int seller_num){
		return sellerOrderDao.getOrderListVanila(seller_num);
	}

	public OrderPageBean getPageBeanCnt(String order_status, int currentPage) {

		if (order_status.equals("전체")) {

			int pageBean_cnt = sellerOrderDao.getOrderCount(loginSellerBean.getSeller_num());
			OrderPageBean orderPageBean = new OrderPageBean(pageBean_cnt, currentPage, page_listcnt,
					page_paginationcnt);

			return orderPageBean;

		} else {

			int pageBean_cnt = sellerOrderDao.getOrderCountByStatus(loginSellerBean.getSeller_num(), order_status);
			OrderPageBean orderPageBean = new OrderPageBean(pageBean_cnt, currentPage, page_listcnt,
					page_paginationcnt);

			return orderPageBean;
		}

	}
	
	public SellerOrderBean getOrderListByOrderNumber(int seller_num, int order_number) {
		return sellerOrderDao.getOrderListByOrderNumber(seller_num, order_number);
	}

	public int getOrderCount(int seller_num) {
		return sellerOrderDao.getOrderCount(seller_num);
	}

	public int getOrderCountByStatus(int seller_num, String order_status) {
		return sellerOrderDao.getOrderCountByStatus(seller_num, order_status);
	}
	
	public void modifySellerOrderInfo(int order_number, String order_status, String delivery_company, String delivery_number)  {
				
		sellerOrderDao.modifySellerOrderInfo(order_number, order_status, delivery_company, delivery_number);
	}

}
