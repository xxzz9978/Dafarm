package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import kr.co.dafarm.bean.AdminSellerBoardBean;

@Mapper
public interface AdminSellerBoardMapper {

	/*user_board_num 1씩 늘리는 어노테이션*/
	@SelectKey(statement = "select content_seq2.nextval from dual", keyProperty = "seller_board_num",
	        before = true, resultType = int.class)
	
	// 구매자 글 작성	
	@Insert("insert into seller_board (seller_board_num, seller_board_title, seller_board_content, seller_board_access_date, seller_board_view_count) "
			+ " values (#{seller_board_num}, #{seller_board_title, jdbcType=VARCHAR}, #{seller_board_content, jdbcType=VARCHAR}, sysdate, 0)")
	void seller_new_post(AdminSellerBoardBean adminUserBoardBean);
	
	// 구매자 전체 글 확인
	@Select("select * from seller_board order by seller_board_num desc")
	List<AdminSellerBoardBean> select_all_seller_board();
	
	
	// 구매자 특정 글 확인
	@Select("select * from seller_board where seller_board_num = #{seller_board_num}")
	AdminSellerBoardBean select_one_seller_board(int seller_board_num);
	
	// 구매자 글 수정
	@Update("update user_board set seller_board=#{user_board_title, jdbcType=VARCHAR}, seller_board_content=#{seller_board_content, jdbcType=VARCHAR} where seller_board_num=#{seller_board_num}")
    void seller_modify_board(AdminSellerBoardBean adminUserBoardBean);
	
	// 구매자 글 삭제
	@Delete("delete from seller_board where seller_board_num = #{seller_board_num}")
    void seller_delete_board(int seller_board_num);
	
}
