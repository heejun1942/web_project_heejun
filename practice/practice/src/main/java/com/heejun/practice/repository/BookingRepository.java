package com.heejun.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heejun.practice.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long> {
//	public Booking findBystoreCode(String storeCode);
}
