package kr.co.dafarm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.UserBean;
import kr.co.dafarm.mapper.UserMapper;

@Repository
public class UserDao {

	@Autowired
	private UserMapper userMapper;
	
	// 아이디 중복확인을 위한 Select sql문 반환
	public String checkUserIdExist(String user_id) {
		return userMapper.checkUserIdExist(user_id);
	}
	
	// 회원가입시 DB에 data를 입력하는 Insert sql문 반환
	public void addUserInfo(UserBean joinUserBean) {	
		userMapper.addUserInfo(joinUserBean);
	}
	
	// 아이디 로그인시 DB에 있는 data와 일치하는지 확인하여 로그인을 시도하는 Select sql문 반환
	public UserBean getLoginUserInfo(UserBean tempLoginUserBean) {
		return userMapper.getLoginUserInfo(tempLoginUserBean);
	}
	
	// 마이페이지로 진입할때 회원 정보 수정을 위해 현재 로그인 되어있는 User의 정보를 조회하는 Select sql문 반환
	public UserBean getModifyUserInfo(int user_num) {
		return userMapper.getModifyUserInfo(user_num);
	}
	
	// 마이페이에서 수정된 회원 정보를 DB에 적용하는 Update sql문 반환
	public void modifyUserInfo(UserBean modifyUserBean) {
		userMapper.modifyUserInfo(modifyUserBean);
	}
}
