package kr.co.dafarm.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dafarm.bean.UserBean;
import kr.co.dafarm.bean.UserBoardBean;
import kr.co.dafarm.bean.UserBoardPageBean;
import kr.co.dafarm.dao.UserBoardDao;
import kr.co.dafarm.service.UserBoardService;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/users/board")
public class UserBoardController {
	
	@Autowired
	private UserBoardService userBoardService;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	// User 게시물 메인(리스트)
	@GetMapping("/main")
	public String inquiry(@RequestParam(value = "page", defaultValue = "1")int page,
							Model model) {
		
		// 콘텐츠 목록 가져오기
	    List<UserBoardBean> contentList = userBoardService.getContentList(page);
	    model.addAttribute("contentList", contentList);
	    
	    // 총 콘텐츠 개수와 페이지 정보를 가져와서 페이지 빈 객체에 설정
	    UserBoardPageBean pageBean = userBoardService.getContentCnt(null, page);
	    model.addAttribute("pageBean", pageBean);
	    
	    // 현재 페이지 정보를 모델에 추가
	    model.addAttribute("page", page);
	    
	    return "users/board/main";
	}
	
	// 게시판 리스트 제목, 내용 화면전환
	@GetMapping("/read")
	public String read(@RequestParam("user_board_num")int user_board_num,
						@RequestParam(value = "page", defaultValue = "1") int page,
						Model model,
						HttpServletRequest request,
						HttpServletResponse response) {
		
		// 조회수 증가 로직 추가
		userBoardService.updateVisit(user_board_num);
		
		model.addAttribute("user_board_num", user_board_num);
		
		UserBoardBean readContentBean =
				userBoardService.getContentInfo(user_board_num);
		
		model.addAttribute("readContentBean", readContentBean);
		
		model.addAttribute("page", page);
		
		return "users/board/read";
	}

}
