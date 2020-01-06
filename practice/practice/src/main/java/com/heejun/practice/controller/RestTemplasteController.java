package com.heejun.practice.controller;

import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestTemplasteController {
	@ResponseBody
	@GetMapping("/getKakao")
	public ResponseEntity<Map> getKakao() {
		RestTemplate rt = new RestTemplate();
		RequestEntity requestEntity = null;
		try {
			requestEntity = RequestEntity
					.get(new URI("https://dapi.kakao.com/v2/local/search/address.json?query="
							+ URLEncoder.encode("부산 연 제구 연산동 1000", "utf-8")))
					.header("Authorization", "KakaoAK d4be7b479f4b4cbd99bd19ae87f88b4b").build();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
		return entity;
	}
	
	@GetMapping("/naver")
	public String naver() {
		return "naver";
	}

	@GetMapping("/getNaver")
	public String getNaver(@RequestParam("text") String text) {
		RestTemplate rt = new RestTemplate();
		RequestEntity<Map<String, String>> requestEntity = null;
		try {
			Map<String, String> body = new HashMap<>();
			body.put("source", "ko");
			body.put("target", "en");
			body.put("text",  "안녕하세요. 저는 자바 개발자입 니다.");
			requestEntity = RequestEntity.post(new URI("https://openapi.naver.com/v1/papago/n2mt"))
					.header("X-Naver-Client-Id", "OpcnSsAIn37qIu6Iyad6").header("X-Naver-Client-Secret", "p7qtbsYx8N")
					.body(body);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
		return "redirect:/naver";
	}
}
