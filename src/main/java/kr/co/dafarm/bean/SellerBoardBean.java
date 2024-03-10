package kr.co.dafarm.bean;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SellerBoardBean {

	private int seller_board_num; //게시물 아이디
	private String seller_board_title; //게시물 제목
	private String seller_board_content; //게시물 본문
	private String seller_board_access_date; //작성시간
	private int seller_board_view_count; //조회수
	
	public int getSeller_board_num() {
		return seller_board_num;
	}
	public void setSeller_board_num(int seller_board_num) {
		this.seller_board_num = seller_board_num;
	}
	public String getSeller_board_title() {
		return seller_board_title;
	}
	public void setSeller_board_title(String seller_board_title) {
		this.seller_board_title = seller_board_title;
	}
	public String getSeller_board_content() {
		return seller_board_content;
	}
	public void setSeller_board_content(String seller_board_content) {
		this.seller_board_content = seller_board_content;
	}
	public String getSeller_board_access_date() {
		return seller_board_access_date;
	}
	public void setSeller_board_access_date(String seller_board_access_date) {
		this.seller_board_access_date = seller_board_access_date;
	}
	public int getSeller_board_view_count() {
		return seller_board_view_count;
	}
	public void setSeller_board_view_count(int seller_board_view_count) {
		this.seller_board_view_count = seller_board_view_count;
	}
	


}
