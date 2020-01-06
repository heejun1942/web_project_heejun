package com.heejun.practice.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {
	@GetMapping("/movie")
	public String movie(Model model) {
		RestTemplate rq = new RestTemplate();
		Map<String, Object> result = rq.getForObject(
				"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20191229",
				Map.class);
		model.addAttribute("movies", result);
		return "movie";
	}

	
}
