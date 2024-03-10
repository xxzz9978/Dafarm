package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.dafarm.bean.AdminUserBean;

@Mapper
public interface AdminUserMapper {
    
	@Select("SELECT * FROM users order by user_num desc")
    List<AdminUserBean> select_data();
    
	@Select("SELECT * FROM (SELECT * FROM users ORDER BY user_num DESC) WHERE ROWNUM <= 5")
    List<AdminUserBean> select_dashboard_List();
	
	@Select("SELECT User_Access_Date, count(User_Num) as user_count "
    		+ "FROM Users "
    		+ "WHERE User_Access_Date BETWEEN to_char(sysdate - 7, 'YYYY-MM-DD') AND to_char(sysdate, 'YYYY-MM-DD') "
    		+ "GROUP BY User_Access_Date "
    		+ "ORDER BY User_Access_Date")
    List<AdminUserBean> select_buyer_count_week();
    
    @Select("SELECT User_Access_Date, count(User_Num) as user_count "
    		+ "FROM Users "
    		+ "WHERE User_Access_Date BETWEEN to_char(sysdate - 30, 'YYYY-MM-DD') AND to_char(sysdate, 'YYYY-MM-DD') "
    		+ "GROUP BY User_Access_Date "
    		+ "ORDER BY User_Access_Date")
    List<AdminUserBean> select_buyer_count_month();
	
	@Select("SELECT User_Access_Date, count(User_Num) as user_count "
    		+ "FROM Users "
			+ "WHERE User_Access_Date "
			+ "BETWEEN to_date(#{startDate,jdbcType=VARCHAR}, 'YYYY-MM-DD') "
			+ "AND to_date(#{endDate,jdbcType=VARCHAR}, 'YYYY-MM-DD') "
			+ "GROUP BY User_Access_Date "
			+ "ORDER BY User_Access_Date")
	List<AdminUserBean> selected_date_buyer(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	@Select("select * from users where user_num = #{user_num}")
	AdminUserBean select_user_info(int user_num);
	
    @Update("update users set user_name=#{user_name, jdbcType=VARCHAR}, user_phone=#{user_phone, jdbcType=VARCHAR}, user_email=#{user_email, jdbcType=VARCHAR}, user_address=#{user_address, jdbcType=VARCHAR}, user_id=#{user_id, jdbcType=VARCHAR}, user_password=#{user_password, jdbcType=VARCHAR} where user_num=#{user_num}")
    void modify_user(AdminUserBean adminUserBean);
    
    @Delete("delete from users where user_num = #{user_num}")
    void delete_user(int user_num);
}