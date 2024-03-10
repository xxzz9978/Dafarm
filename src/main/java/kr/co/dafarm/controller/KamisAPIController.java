package kr.co.dafarm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.dafarm.bean.KamisAPIBean;
import kr.co.dafarm.service.KamisAPIService;

@Controller
public class KamisAPIController {

	private final KamisAPIService kamisApiService;

	public KamisAPIController(KamisAPIService kamisApiService) {
		this.kamisApiService = kamisApiService;
	}

	@GetMapping(value="/KamisAPI",produces="text/plain;charset=UTF-8")
	public String KamisAPI(Model model) {
		KamisAPIBean kamisAPIBean = kamisApiService.getKamisAPIInfo();
		model.addAttribute("kamisAPIBean",kamisAPIBean);
		return "seller/include/KamisAPI";
		}


}
