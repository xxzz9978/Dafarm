package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.dafarm.bean.AdminPremiumBean;
import kr.co.dafarm.bean.AdminSellerBean;
import kr.co.dafarm.bean.AdminSellerProfitBean;

@Mapper
public interface AdminSellerMapper {
	
    @Select("select * from seller_table order by seller_num desc")
    List<AdminSellerBean> select_data();
    
    @Select("SELECT * FROM (SELECT * FROM seller_table ORDER BY seller_num DESC) WHERE ROWNUM <= 5")
    List<AdminSellerBean> select_dashboard_List();
    
    @Select("SELECT seller_access_date, count(seller_num) as seller_count "
    		+ "FROM seller_table "
    		+ "WHERE seller_access_date BETWEEN to_char(sysdate - 7, 'YYYY-MM-DD') AND to_char(sysdate, 'YYYY-MM-DD') "
    		+ "GROUP BY seller_access_date "
    		+ "ORDER BY seller_access_date")
    List<AdminSellerBean> select_seller_count_week();
    
    @Select("SELECT seller_access_date, count(seller_num) as seller_count "
    		+ "FROM seller_table "
    		+ "WHERE seller_access_date BETWEEN to_char(sysdate - 30, 'YYYY-MM-DD') AND to_char(sysdate, 'YYYY-MM-DD') "
    		+ "GROUP BY seller_access_date "
    		+ "ORDER BY seller_access_date")
    List<AdminSellerBean> select_seller_count_month();
    
    @Select("SELECT seller_access_date, count(seller_num) as seller_count "
    		+ "FROM seller_table "
			+ "WHERE seller_access_date "
			+ "BETWEEN to_date(#{startDate,jdbcType=VARCHAR}, 'YYYY-MM-DD') "
			+ "AND to_date(#{endDate,jdbcType=VARCHAR}, 'YYYY-MM-DD') "
			+ "GROUP BY seller_access_date "
			+ "ORDER BY seller_access_date")
	List<AdminSellerBean> selected_date_seller(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
    @Select("select * from seller_table where seller_num = #{seller_num}")
    AdminSellerBean select_seller_info(int seller_num);
    @Select("select business_name, business_number, business_account from seller_business_table where seller_num = #{seller_num}")
    AdminSellerBean select_business_info(int seller_num);
    
    @Update("update seller_table set seller_name=#{seller_name}, seller_phone=#{seller_phone}, seller_email=#{seller_email}, seller_address=#{seller_address} where seller_num=#{seller_num}")
    void modify_seller(AdminSellerBean adminModifySellerBean);
    
    @Update("update seller_business_table set business_name=#{business_name}, business_number=#{business_number}, business_account=#{business_account} where seller_num=#{seller_num}")
    void modify_business(AdminSellerBean adminModifySellerBean);
    
    @Delete("delete from seller_table where seller_num = #{seller_num}")
    void delete_seller(int seller_num);
    
    @Delete("delete from seller_business_table where seller_num = #{seller_num}")
    void delete_business(int seller_num);
    
    @Select("select gen_date, sum(seller_profit) as seller_profit "
    		+ "from seller_profit_table "
    		+ "where gen_date BETWEEN sysdate - INTERVAL '7' DAY AND sysdate "
    		+ "group by gen_date "
    		+ "order by gen_date")
    List<AdminSellerProfitBean> select_seller_profit_week();
    
    @Select("select gen_date, sum(seller_profit) as seller_profit "
    		+ "from seller_profit_table "
    		+ "where gen_date BETWEEN sysdate - INTERVAL '30' DAY AND sysdate "
    		+ "group by gen_date "
    		+ "order by gen_date")
    List<AdminSellerProfitBean> select_seller_profit_month();
    
    @Select("select gen_date, sum(seller_profit) as seller_profit "
    		+ "from seller_profit_table "
    		+ "where gen_date between TO_DATE(#{startDate,jdbcType=VARCHAR}, 'YYYY-MM-DD') and TO_DATE(#{endDate,jdbcType=VARCHAR}, 'YYYY-MM-DD') "
    		+ "group by gen_date "
    		+ "order by gen_date")
	List<AdminSellerProfitBean> selected_date_seller_profit(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
    @Select("select * from premium_seller_table where seller_num = #{seller_num}")

    AdminPremiumBean select_premium(int seller_num);
}