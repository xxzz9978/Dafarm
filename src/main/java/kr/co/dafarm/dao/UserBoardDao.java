package kr.co.dafarm.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.UserBoardBean;
import kr.co.dafarm.mapper.UserBoardMapper;

@Repository
public class UserBoardDao {
	
	@Autowired
	private UserBoardMapper userboardMapper;
	
	public List<UserBoardBean> getContentList(RowBounds rowBounds){
		return userboardMapper.getContentList(rowBounds);
	}
	
	public UserBoardBean getContentInfo(int user_board_num) {
		return userboardMapper.getContentInfo(user_board_num);
	}
	
	public int getContentCnt(UserBoardBean contentNum) {
		return userboardMapper.getContentCnt(contentNum);
	}
	
	
	public void updateVisit(int user_board_num) {
		userboardMapper.updateVisit(user_board_num);
	}
	 

}
