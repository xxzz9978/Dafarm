package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.co.dafarm.bean.AdminRevenueBean;

@Mapper
public interface AdminRevenueMapper {

	@Select("select * from admin_revenue")
	List<AdminRevenueBean> select_all_revenue();

	@Select("SELECT * FROM admin_revenue "
			+ "WHERE revenue_date "
			+ "BETWEEN to_date(#{startDate,jdbcType=VARCHAR}, 'YYYY-MM-DD') "
			+ "AND to_date(#{endDate,jdbcType=VARCHAR}, 'YYYY-MM-DD') "
			+ "order by revenue_date")
	List<AdminRevenueBean> selected_date_revenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	@Select("SELECT * "
			+ "FROM admin_revenue "
			+ "WHERE revenue_date BETWEEN SYSDATE - 7 AND SYSDATE "
			+ "order by revenue_date")
	List<AdminRevenueBean> one_week_revenue();
	
	@Select("SELECT * "
			+ "FROM admin_revenue "
			+ "WHERE revenue_date BETWEEN SYSDATE - 30 AND SYSDATE "
			+ "order by revenue_date")
	List<AdminRevenueBean> one_month_revenue();
	
}
