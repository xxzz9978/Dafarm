package kr.co.dafarm.bean;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class UserBoardBean {

	private int user_board_num; //게시물 아이디
	private String user_board_title; //게시물 제목
	private String user_board_content; //게시물 본문
	private String user_board_access_date; //작성시간
	private int user_board_view_count; //조회수
	
	/*
	 * public void adduser_board_view_count() { this.user_board_view_count++; }
	 */
	
	public int getUser_board_num() {
		return user_board_num;
	}
	public void setUser_board_num(int user_board_num) {
		this.user_board_num = user_board_num;
	}
	public String getUser_board_title() {
		return user_board_title;
	}
	public void setUser_board_title(String user_board_title) {
		this.user_board_title = user_board_title;
	}
	public String getUser_board_content() {
		return user_board_content;
	}
	public void setUser_board_content(String user_board_content) {
		this.user_board_content = user_board_content;
	}
	public String getUser_board_access_date() {
		return user_board_access_date;
	}
	public void setUser_board_access_date(String user_board_access_date) {
		this.user_board_access_date = user_board_access_date;
	}
	public int getUser_board_view_count() {
		return user_board_view_count;
	}
	public void setUser_board_view_count(int user_board_view_count) {
		this.user_board_view_count = user_board_view_count;
	}

}
