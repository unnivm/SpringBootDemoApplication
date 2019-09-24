package com.istvan.spring.demo.SpringDemo.service.impl;

import com.istvan.spring.demo.SpringDemo.entity.Tour;
import com.istvan.spring.demo.SpringDemo.repository.TourRepository;
import com.istvan.spring.demo.SpringDemo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository repository;

    @Override
    public void save(Tour tour) {
        repository.save(tour);
    }

    @Async("asyncBean")
    @Override
    public CompletableFuture<List<Tour>> findAllTours() {
        List<Tour> list = repository.findAll();
        return CompletableFuture.completedFuture(list);
    }

}
