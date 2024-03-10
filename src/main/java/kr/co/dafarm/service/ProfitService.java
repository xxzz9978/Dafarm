package kr.co.dafarm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.ProfitBean;
import kr.co.dafarm.bean.SellerPremiumPiechartBean;
import kr.co.dafarm.dao.ProfitDao;

@Service
public class ProfitService {

	@Autowired
	private ProfitDao profitDao;
	
	public void addProfit(ProfitBean profitBean) {
		profitDao.addProfit(profitBean);
	}
	
	public List<ProfitBean> getProfitList(int seller_num){
		return profitDao.getProfitList(seller_num);
	}
	
	public Integer getProfitPrice(int seller_num) {
		
		return profitDao.getProfitPrice(seller_num);
	}
	
	public String getProfitSumByMonth(int month) {
		return profitDao.getProfitSumByMonth(month);
	}
	
	public List<SellerPremiumPiechartBean> getPiechartList(int seller_num){
		return profitDao.getPiechartList(seller_num);
	}
	
}
