package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.dafarm.bean.UserBoardBean;

@Mapper
public interface UserBoardMapper {
	
	/*board_list(board_inquiry)*/
	@Select
	("SELECT * FROM user_board ORDER BY user_board_num DESC")
	List<UserBoardBean> getContentList(RowBounds rowBounds);
	
	@Select
	("select * from user_board where user_board_num= #{user_board_num}")
	UserBoardBean getContentInfo(int user_board_num);

	@Select("select count(*) from user_board ")
	int getContentCnt(UserBoardBean contentNum);
	
	
	@Update("UPDATE user_board SET user_board_view_count = user_board_view_count + 1 WHERE user_board_num = #{user_board_num}")
	void updateVisit(int user_board_num);
	 
	
}
