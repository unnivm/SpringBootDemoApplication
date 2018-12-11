package com.istvan.spring.demo.SpringDemo.service;

import com.istvan.spring.demo.SpringDemo.entity.Tour;

import java.util.Collection;

public interface TourService {
    public void save(Tour tour);
    public Collection<Tour> findAllTours();
}
