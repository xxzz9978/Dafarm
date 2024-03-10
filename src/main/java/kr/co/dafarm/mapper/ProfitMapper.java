package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.co.dafarm.bean.ProfitBean;
import kr.co.dafarm.bean.SellerPremiumPiechartBean;

@Mapper
public interface ProfitMapper {

	// ProfitBean에 데이터를 등록하는 쿼리
	@Insert("insert into seller_profit_table(seller_num, order_number, seller_profit, gen_date) "
			+ "values (#{seller_num}, order_seq.currval, #{seller_profit}, #{gen_date})")
	void addProfit(ProfitBean profitBean);
	
	// 판매자 번호로 profit 테이블을 불러오는 쿼리
	@Select("select seller_num, order_number, seller_profit, gen_date "
			+ "from seller_profit_table "
			+ "where seller_num = #{seller_num}")
	List<ProfitBean> getProfitList(@Param("seller_num") int seller_num);
	
	// 판매자 번호로 수익을 조회하는 쿼리
	@Select("select sum(seller_profit) from seller_profit_table where seller_num = #{seller_num}")
	Integer getProfitPrice(@Param("seller_num") int seller_num);
	
	// 특정 달을 검색해서 해당 수익의 합을 조회하는 쿼리
	@Select("select to_number(sum(seller_profit)) as total_profit "
			+ "from seller_profit_table "
			+ "where extract(year from gen_date) = extract(year from sysdate) "
			+ "and extract(month from gen_date) = #{month}")
	String getProfitSumByMonth(@Param("month") int month);
	
	@Select("select a1.seller_profit, a2.item_name "
			+ "from seller_profit_table a1 "
			+ "inner join seller_order_table a2 on a1.order_number = a2.order_number "
			+ "where a2.seller_num = #{seller_num} "
			+ "order by seller_profit asc")
	List<SellerPremiumPiechartBean> getPiechartList(@Param("seller_num") int seller_num);
}
