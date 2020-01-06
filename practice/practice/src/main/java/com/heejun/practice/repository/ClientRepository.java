package com.heejun.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.heejun.practice.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
