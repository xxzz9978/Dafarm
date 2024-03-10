package kr.co.dafarm.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.UserBoardBean;
import kr.co.dafarm.bean.UserBoardPageBean;
import kr.co.dafarm.dao.UserBoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class UserBoardService {
	
	@Value("${page.listcnt}")
	private int page_listcnt;
	
	@Value("${page.paginationcnt}")
	private int page_paginationcnt;
	
	@Autowired
	private UserBoardDao userboardDao;
	
	public List<UserBoardBean> getContentList(int page) {
		
		int start = (page -1) * page_listcnt;
		//1페이지 일때, 0번 인덱스 글부터 시작(0~9)
		//2페이지일 때, 10번 인덱스 글부터 시작(10~19)
		//3페이지일 때, 20번 인덱스 글부터 시작(20~29)
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		
	    return userboardDao.getContentList(rowBounds);

	}
	
	public UserBoardBean getContentInfo(int user_board_num) {
		return userboardDao.getContentInfo(user_board_num);
	}
	
	public UserBoardPageBean getContentCnt(UserBoardBean contentNum, int currentPage) {
		int content_cnt = userboardDao.getContentCnt(contentNum);
		
		UserBoardPageBean userPageBean = new UserBoardPageBean(content_cnt, currentPage, page_listcnt, page_paginationcnt);
		
		return userPageBean;
		
	}
	
	public void updateVisit(int user_board_num) {
	  
		userboardDao.updateVisit(user_board_num);
	  
	}
	 

}