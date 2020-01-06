package com.heejun.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String userId;
	public String password;
	public String bookingStore;
	public int bookingTime;
}
