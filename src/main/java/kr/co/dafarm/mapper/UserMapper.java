package kr.co.dafarm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.dafarm.bean.UserBean;

public interface UserMapper {

	// User 아이디 중복확인 : User 회원 가입시 DB에 해당 user_id값이 있는지 확인 하는 sql문
	@Select("select user_name from users where user_id = #{user_id}")
	String checkUserIdExist(String user_id);
	
	// User 회원가입 : User 회원 가입시 DB에 값이 Insert 되는 sql문
	@Insert("insert into users (user_num, user_id, user_password, user_name, user_address, user_email, user_phone, user_access_date) "
			+ "values (user_seq.nextval, #{user_id}, #{user_password}, #{user_name}, "
			+ "#{user_address}, #{user_email}, #{user_phone}, #{user_access_date})")
	void addUserInfo(UserBean joinUserBean);
	// #{user_num} -> user_seq.nextval 시퀀스로 차후 변경 필요
	
	// User 로그인 : User 로그인시 DB에 현재 Login창에 입력된 아이디 (user_id) 와 비밀번호 (user_password)의 Data를 가지고 있는 비교
	// 데이터를 비교하여 일치하는 Data가 있다면 로그인 완료 처리로 넘길 것이며, 반대의 상황일 경우 alert로 경고창 Display 이후 Login창으로 되돌림
	@Select("select user_num, user_name from users where user_id=#{user_id} and user_password=#{user_password}")
	UserBean getLoginUserInfo(UserBean tempLoginUserBean);
	
	// 회원 정보 수정시 필요한 회원 저보 Data를 Select하는 sql문
	@Select("select * from users where user_num = #{user_num}")
	UserBean getModifyUserInfo(int user_num);
	
	// User 회원 정보 수정 : User Modify Info 페이지에서 정보 수정 완료 이후 DB에 후 처리를 해주기 위한 sql문
	@Update("update users set user_password = #{user_password}, user_address = #{user_address}, " 
			+ "user_email = #{user_email}, user_phone = #{user_phone} where user_num = #{user_num}")
	void modifyUserInfo(UserBean modifyUserBean);
	
	// User의 장바구니 DB는 만들지 말지 고민중
}
