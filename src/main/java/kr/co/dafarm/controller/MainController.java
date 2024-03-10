package kr.co.dafarm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.dafarm.bean.KamisAPIBean;
import kr.co.dafarm.service.KamisAPIService;

@Controller
public class MainController {

	@Resource
	private final KamisAPIService kamisApiService;

	public MainController(KamisAPIService kamisApiService) {
		this.kamisApiService = kamisApiService;
	}

	@GetMapping("/main")
	public String main(Model model) {
		KamisAPIBean kamisAPIBean = kamisApiService.getKamisAPIInfo();
		model.addAttribute("kamisAPIBean", kamisAPIBean);
		
		int randomNum[] = new int[4];
		
		for(int i=0;  i <randomNum.length;i++) {
			randomNum[i]=(int)(Math.random()*60)+1;
			
			
			for(int j=0;  j <i; j++) {				 
									                
				if(randomNum[j]==randomNum[i]) {	
					
					i--;							
					break;							
				}									
			}
		}

	for(int i=0;  i < randomNum.length; i++) {
		model.addAttribute("randomNum0", randomNum[0]);
		model.addAttribute("randomNum1", randomNum[1]);
		model.addAttribute("randomNum2", randomNum[2]);
		model.addAttribute("randomNum3", randomNum[3]);
		}
		
		return "main";
	}
	
	
}
