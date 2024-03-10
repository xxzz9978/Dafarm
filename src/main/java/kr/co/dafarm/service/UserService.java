package kr.co.dafarm.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.UserBean;
import kr.co.dafarm.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	// 아이디 중복확인을 위한 Select sql문 DAO 연결 
	public boolean checkUserIdExist(String user_id) {

		String user_name = userDao.checkUserIdExist(user_id);
		
		// user_name이 null일 경우 DB에 해당 아이디가 없다는 뜻이므로 true 반환
		if(user_name == null) { 
			return true;
		}else {
			return false;
		}
	}

	// 회원가입시 DB에 data를 입력하는 Insert DAO 연결 
	public void addUserInfo(UserBean joinUserBean) {
		
		// 회원가입 일자 user_access_date 변수에 값 할당
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(currentDate);
		joinUserBean.setUser_access_date(formattedDate);
		
		// 최종 회원가입시 기입된 Data들 UserBean으로 추가해줌
		userDao.addUserInfo(joinUserBean);
	}

	// 아이디 로그인시 DB에 있는 data와 일치하는지 확인하여 로그인을 시도하는 Select DAO 연결 
	public void getLoginUserBean(UserBean tempLoginUserBean) {
		
		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
		
		if(tempLoginUserBean2 != null) {
			loginUserBean.setUser_num(tempLoginUserBean2.getUser_num());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUserLogin(true);
		}
	}

	// 마이페이지로 진입할때 회원 정보 수정을 위해 현재 로그인 되어있는 User의 정보를 조회하는 Select DAO 연결 
	public void getModifyUserInfo(UserBean modifyUserBean) {
		
		UserBean tempModifyUserBean = userDao.getModifyUserInfo(loginUserBean.getUser_num());
		
		modifyUserBean.setUser_id(tempModifyUserBean.getUser_id());				// 수정하려는 현재 회원의 id 가져오기
		modifyUserBean.setUser_name(tempModifyUserBean.getUser_name());			// 수정하려는 현재 회원의 name 가져오기
		modifyUserBean.setUser_phone(tempModifyUserBean.getUser_phone());		// 수정하려는 현재 회원의 phone 가져오기
		modifyUserBean.setUser_email(tempModifyUserBean.getUser_email());		// 수정하려는 현재 회원의 email 가져오기
		modifyUserBean.setUser_address(tempModifyUserBean.getUser_address());	// 수정하려는 현재 회원의 address 가져오기
		
		modifyUserBean.setUser_num(loginUserBean.getUser_num()); // 로그인 되어있는 User의 회원번호 가져오기
	}

	// 마이페이에서 수정된 회원 정보를 DB에 적용하는 Update DAO 연결 
	public void modifyUserInfo(UserBean modifyUserBean) {
		modifyUserBean.setUser_num(loginUserBean.getUser_num());
		userDao.modifyUserInfo(modifyUserBean);
	}
}
