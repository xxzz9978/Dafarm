package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.dafarm.bean.SellerBoardBean;
import kr.co.dafarm.bean.UserBoardBean;

@Mapper
public interface SellerNoticeMapper {
	
	@Select
	("SELECT * FROM seller_board ORDER BY seller_board_num DESC")
	List<SellerBoardBean> getContentList(RowBounds rowBounds);
	
	@Select
	("select * from seller_board where seller_board_num= #{seller_board_num}")
	SellerBoardBean getContentInfo(int seller_board_num);

	@Select("select count(*) from seller_board ")
	int getContentCnt(SellerBoardBean contentNum);
	
	
	@Update("UPDATE seller_board SET seller_board_view_count = seller_board_view_count + 1 WHERE seller_board_num = #{seller_board_num}")
	void updateVisit(int seller_board_num);
	 
	
}
