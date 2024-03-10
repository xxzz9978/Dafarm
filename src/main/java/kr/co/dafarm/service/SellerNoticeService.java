package kr.co.dafarm.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.SellerBoardBean;
import kr.co.dafarm.bean.SellerBoardPageBean;
import kr.co.dafarm.bean.UserBoardBean;
import kr.co.dafarm.bean.UserBoardPageBean;
import kr.co.dafarm.dao.SellerNoticeDao;
import kr.co.dafarm.dao.UserBoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class SellerNoticeService {
	
	@Value("${page.listcnt}")
	private int page_listcnt;
	
	@Value("${page.paginationcnt}")
	private int page_paginationcnt;
	
	@Autowired
	private SellerNoticeDao sellerNoticeDao;
	
	public List<SellerBoardBean> getContentList(int page) {
		
		int start = (page -1) * page_listcnt;
		//1페이지 일때, 0번 인덱스 글부터 시작(0~9)
		//2페이지일 때, 10번 인덱스 글부터 시작(10~19)
		//3페이지일 때, 20번 인덱스 글부터 시작(20~29)
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		
	    return sellerNoticeDao.getContentList(rowBounds);

	}
	
	public SellerBoardBean getContentInfo(int seller_board_num) {
		return sellerNoticeDao.getContentInfo(seller_board_num);
	}
	
	public SellerBoardPageBean getContentCnt(SellerBoardBean contentNum, int currentPage) {
		int content_cnt = sellerNoticeDao.getContentCnt(contentNum);
		
		SellerBoardPageBean sellerPageBean = new SellerBoardPageBean(content_cnt, currentPage, page_listcnt, page_paginationcnt);
		
		return sellerPageBean;
		
	}
	
	public void updateVisit(int seller_board_num) {
	  
		sellerNoticeDao.updateVisit(seller_board_num);
	  
	}
	 

}