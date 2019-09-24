package com.istvan.spring.demo.SpringDemo.service;

import com.istvan.spring.demo.SpringDemo.entity.Tour;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TourService {
    public void save(Tour tour);
    public CompletableFuture<List<Tour>> findAllTours();
}
