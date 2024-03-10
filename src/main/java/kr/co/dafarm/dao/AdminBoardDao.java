package kr.co.dafarm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.AdminSellerBoardBean;
import kr.co.dafarm.bean.AdminUserBoardBean;
import kr.co.dafarm.mapper.AdminSellerBoardMapper;
import kr.co.dafarm.mapper.AdminUserBoardMapper;

@Repository
public class AdminBoardDao {
	
	@Autowired
	AdminUserBoardMapper adminUserBoardMapper;
	
	@Autowired
	AdminSellerBoardMapper adminSellerBoardMapper;
	
	public void user_new_post(AdminUserBoardBean adminUserBoardBean) {
		adminUserBoardMapper.user_new_post(adminUserBoardBean);
	}
	
	public List<AdminUserBoardBean> select_all_user_board(){
		return adminUserBoardMapper.select_all_user_board();
	}
	
	public AdminUserBoardBean select_one_user_board(int user_board_num) {
		return adminUserBoardMapper.select_one_user_board(user_board_num);
	}
	
	public void user_modify_board(AdminUserBoardBean adminUserBoardBean) {
		adminUserBoardMapper.user_modify_board(adminUserBoardBean);
	}
	
	public void user_delete_board(int user_board_num) {
		adminUserBoardMapper.user_delete_board(user_board_num);
	}
	
	
	
	
	public void seller_new_post(AdminSellerBoardBean adminSellerBoardBean) {
		adminSellerBoardMapper.seller_new_post(adminSellerBoardBean);
	}
	
	public List<AdminSellerBoardBean> select_all_seller_board(){
		return adminSellerBoardMapper.select_all_seller_board();
	}
	
	public AdminSellerBoardBean select_one_seller_board(int seller_board_num) {
		return adminSellerBoardMapper.select_one_seller_board(seller_board_num);
	}
	
	public void seller_modify_board(AdminSellerBoardBean adminSellerBoardBean) {
		adminSellerBoardMapper.seller_modify_board(adminSellerBoardBean);
	}
	
	public void seller_delete_board(int seller_board_num) {
		adminSellerBoardMapper.seller_delete_board(seller_board_num);
	}
	
}
