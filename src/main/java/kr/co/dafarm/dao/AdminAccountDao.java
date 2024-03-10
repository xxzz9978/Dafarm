package kr.co.dafarm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.AdminAccountBean;
import kr.co.dafarm.mapper.AdminAccountMapper;

@Repository
public class AdminAccountDao {
	
	@Autowired
	private AdminAccountMapper adminAccountMapper;
	
	public AdminAccountBean getLoginAdminInfo(String adminId, String adminPw) {
        return adminAccountMapper.getLoginAdminInfo(adminId, adminPw);
    }
	
}
