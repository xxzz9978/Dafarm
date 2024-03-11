package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.co.dafarm.bean.AdminOrderBean;
import kr.co.dafarm.bean.AdminProfitBean;

@Mapper
public interface AdminTradeLogMapper {

	@Select("select * from seller_order_table order by order_number desc")
	List<AdminOrderBean> all_orderLog();
	
	@Select("SELECT * FROM (SELECT * FROM seller_order_table ORDER BY order_number DESC) WHERE ROWNUM <= 2")
    List<AdminOrderBean> main_tradeLog();
	
	@Select("SELECT * FROM (SELECT * FROM seller_profit_table ORDER BY order_number DESC) WHERE ROWNUM <= 2")
    List<AdminProfitBean> main_profitLog();
	
	@Select("SELECT * FROM (SELECT * FROM seller_order_table ORDER BY order_number DESC) WHERE ROWNUM <= 2")
    List<AdminOrderBean> select_dashboard_List(); 
	
	@Select("select * from seller_order_table where seller_num = #{seller_num} order by order_number desc")
	List<AdminOrderBean> selected_orderLog(int seller_num);
	
	@Select("select * from seller_profit_table where seller_num = #{seller_num} order by order_number desc")
	List<AdminProfitBean> selected_profitLog(int seller_num);
	

	@Select("select * from seller_profit_table where order_number=#{order_number}")
	AdminProfitBean select_profit(int order_number);
	
	@Select("select * from seller_profit_table where seller_num=#{seller_num}")
	AdminProfitBean select_seller_profit(int seller_num);

	@Select("select * from seller_order_table where order_number=#{order_number}")
	AdminOrderBean select_orderLog(int order_number);

	@Select("select count(so.order_number) AS orderCount, " +
            "sum(TO_NUMBER(sp.seller_profit)) AS totalProfit " +
            "from seller_profit_table sp " +
            "join seller_order_table so ON sp.order_number = so.order_number " +
            "where so.order_status = '배송완료' AND so.user_num = #{user_num}")
	AdminProfitBean select_user_info(int user_num);
}