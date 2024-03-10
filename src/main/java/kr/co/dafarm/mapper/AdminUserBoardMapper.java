package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import kr.co.dafarm.bean.AdminUserBoardBean;

@Mapper
public interface AdminUserBoardMapper {

	/*user_board_num 1씩 늘리는 어노테이션*/
	@SelectKey(statement = "select content_seq.nextval from dual", keyProperty = "user_board_num",
	        before = true, resultType = int.class)
	
	// 구매자 글 작성	
	@Insert("insert into user_board (user_board_num, user_board_title, user_board_content, user_board_access_date, user_board_view_count) "
			+ " values (#{user_board_num}, #{user_board_title, jdbcType=VARCHAR}, #{user_board_content, jdbcType=VARCHAR}, sysdate, 0)")
	void user_new_post(AdminUserBoardBean adminUserBoardBean);
	
	// 구매자 전체 글 확인
	@Select("select * from user_board order by user_board_num desc")
	List<AdminUserBoardBean> select_all_user_board();
	
	
	// 구매자 특정 글 확인
	@Select("select * from user_board where user_board_num = #{user_board_num}")
	AdminUserBoardBean select_one_user_board(int user_board_num);
	
	// 구매자 글 수정
	@Update("update user_board set user_board_title=#{user_board_title, jdbcType=VARCHAR}, user_board_content=#{user_board_content, jdbcType=VARCHAR} where user_board_num=#{user_board_num}")
    void user_modify_board(AdminUserBoardBean adminUserBoardBean);
	
	// 구매자 글 삭제
	@Delete("delete from user_board where user_board_num = #{user_board_num}")
    void user_delete_board(int user_board_num);
	
}
