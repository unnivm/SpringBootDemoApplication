package com.istvan.spring.demo.SpringDemo.repository;

import com.istvan.spring.demo.SpringDemo.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
