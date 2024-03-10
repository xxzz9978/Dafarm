package kr.co.dafarm.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.SellerBoardBean;
import kr.co.dafarm.bean.UserBoardBean;
import kr.co.dafarm.mapper.SellerNoticeMapper;
import kr.co.dafarm.mapper.UserBoardMapper;

@Repository
public class SellerNoticeDao {
	
	@Autowired
	private SellerNoticeMapper sellerNoticeMapper;
	
	public List<SellerBoardBean> getContentList(RowBounds rowBounds){
		return sellerNoticeMapper.getContentList(rowBounds);
	}
	
	public SellerBoardBean getContentInfo(int seller_board_num) {
		return sellerNoticeMapper.getContentInfo(seller_board_num);
	}
	
	public int getContentCnt(SellerBoardBean contentNum) {
		return sellerNoticeMapper.getContentCnt(contentNum);
	}
	
	
	public void updateVisit(int seller_board_num) {
		sellerNoticeMapper.updateVisit(seller_board_num);
	}
	 

}
