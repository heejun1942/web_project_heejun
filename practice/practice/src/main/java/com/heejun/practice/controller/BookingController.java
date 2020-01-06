package com.heejun.practice.controller;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.heejun.practice.model.Booking;
import com.heejun.practice.model.Client;
import com.heejun.practice.repository.BookingRepository;
import com.heejun.practice.repository.ClientRepository;

@Controller
public class BookingController {	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@GetMapping("/")
	public String home() {
		return "dugudu/home";
	}
	
	@GetMapping("/store/{id}")
	public String booking(@PathVariable("id") long id, Model model) {
		// 예약정보 보내기
		Optional<Booking> status = bookingRepository.findById(id);
		
		Booking booking = status.orElse(new Booking());
		model.addAttribute(booking);
		
		
		// 현재시간 보내기
		LocalTime nowTime = LocalTime.now();
		int nowHour = nowTime.getHour();
		model.addAttribute("nowHour",nowHour);
		return "dugudu/store";
		
	}
	
	@PostMapping("/store/{id}")
	public String postBooking(@PathVariable("id") long id, @ModelAttribute Client client, @ModelAttribute Booking booking) {
		clientRepository.save(client);
		
		booking.storeCode=client.bookingStore;
		booking.time=client.bookingTime;
		bookingRepository.save(booking);
		
		return "redirect:/store/" + id;
	}
	

}
