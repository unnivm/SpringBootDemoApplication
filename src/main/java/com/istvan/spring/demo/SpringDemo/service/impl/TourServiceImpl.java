package com.istvan.spring.demo.SpringDemo.service.impl;

import com.istvan.spring.demo.SpringDemo.entity.Tour;
import com.istvan.spring.demo.SpringDemo.repository.TourRepository;
import com.istvan.spring.demo.SpringDemo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository repository;

    @Override
    public void save(Tour tour) {
        repository.save(tour);
    }

    @Override
    public Collection<Tour> findAllTours() {
        return repository.findAll();
    }

}
