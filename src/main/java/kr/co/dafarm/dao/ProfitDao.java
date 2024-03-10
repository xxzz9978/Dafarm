package kr.co.dafarm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.ProfitBean;
import kr.co.dafarm.bean.SellerPremiumPiechartBean;
import kr.co.dafarm.mapper.ProfitMapper;

@Repository
public class ProfitDao {

	@Autowired
	private ProfitMapper profitMapper;
	
	public void addProfit(ProfitBean profitBean) {
		profitMapper.addProfit(profitBean);
	}
	
	public List<ProfitBean> getProfitList(int seller_num){
		return profitMapper.getProfitList(seller_num);
	}
	
	public Integer getProfitPrice(int seller_num) {
		return profitMapper.getProfitPrice(seller_num);
	}
	
	public String getProfitSumByMonth(int month) {
		return profitMapper.getProfitSumByMonth(month);
	}
	
	public List<SellerPremiumPiechartBean> getPiechartList(int seller_num){
		return profitMapper.getPiechartList(seller_num);
	}
}
