package kr.co.dafarm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.AdminAccountBean;
import kr.co.dafarm.dao.AdminAccountDao;

@Service
public class AdminLoginService {
	
	@Autowired
	 AdminAccountDao adminAccountDao;
	
	@Autowired
	private AdminAccountBean loginAdminBean;
	 
	public boolean login(String adminId, String adminPw) {
	        // 데이터베이스에서 아이디와 비밀번호로 어드민 정보를 가져옵니다.
	        AdminAccountBean adminAccount = adminAccountDao.getLoginAdminInfo(adminId, adminPw);

	        // 가져온 어드민 정보가 없거나, 비밀번호가 일치하지 않으면 로그인 실패를 반환합니다.
	        if (adminAccount == null || !adminAccount.getAdmin_pw().equals(adminPw)) {
	            return false;
	        }

	        // 로그인 성공을 반환합니다.
	        return true;
	    }

}
