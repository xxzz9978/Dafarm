package kr.co.dafarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dafarm.bean.AdminSellerBoardBean;
import kr.co.dafarm.bean.AdminUserBoardBean;
import kr.co.dafarm.dao.AdminBoardDao;

@Service
public class AdminBoardService {
	
	@Autowired
	AdminBoardDao adminBoardDao;
	
	public void user_new_post(AdminUserBoardBean adminUserBoardBean) {
		adminBoardDao.user_new_post(adminUserBoardBean);
	}
	
	public List<AdminUserBoardBean> select_all_user_board(){
		return adminBoardDao.select_all_user_board();
	}
	
	public AdminUserBoardBean select_one_user_board(int user_board_num) {
		return adminBoardDao.select_one_user_board(user_board_num);
	}
	
	public void user_modify_board(AdminUserBoardBean adminUserBoardBean) {
		adminBoardDao.user_modify_board(adminUserBoardBean);
	}
	
	public void user_delete_board(int user_board_num) {
		adminBoardDao.user_delete_board(user_board_num);
	}
	
	
	
	
	public void seller_new_post(AdminSellerBoardBean adminSellerBoardBean) {
		adminBoardDao.seller_new_post(adminSellerBoardBean);
	}
	
	public List<AdminSellerBoardBean> select_all_seller_board(){
		return adminBoardDao.select_all_seller_board();
	}
	
	public AdminSellerBoardBean select_one_seller_board(int seller_board_num) {
		return adminBoardDao.select_one_seller_board(seller_board_num);
	}
	
	public void seller_modify_board(AdminSellerBoardBean adminSellerBoardBean) {
		adminBoardDao.seller_modify_board(adminSellerBoardBean);
	}
	
	public void seller_delete_board(int seller_board_num) {
		adminBoardDao.seller_delete_board(seller_board_num);
	}
	
}
