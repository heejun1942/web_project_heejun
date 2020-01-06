package com.heejun.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.heejun.practice.model.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
