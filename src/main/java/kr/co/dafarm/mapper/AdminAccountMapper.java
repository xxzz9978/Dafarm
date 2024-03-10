package kr.co.dafarm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.co.dafarm.bean.AdminAccountBean;

@Mapper
public interface AdminAccountMapper {

    @Select("select admin_id, admin_pw "
            + "from admin_account  "
            + "where admin_id=#{adminId} and admin_pw=#{adminPw}")
    AdminAccountBean getLoginAdminInfo(@Param("adminId") String adminId, @Param("adminPw") String adminPw);
}
