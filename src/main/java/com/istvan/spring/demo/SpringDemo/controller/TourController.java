package com.istvan.spring.demo.SpringDemo.controller;

import com.istvan.spring.demo.SpringDemo.utils.Util;
import com.istvan.spring.demo.SpringDemo.entity.Tour;
import com.istvan.spring.demo.SpringDemo.service.TourService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class TourController {

     Logger logger = Logger.getLogger(TourController.class.getName());

    /** internal server error code **/
    private static final int INTERNAL_SERVER_ERROR = 500;

    /** HTTP status code **/
    private static final int OK_CODE = 200;

    /** HTTP status code for not authorized **/
    private static final int NOT_AUTHORIZED = 403;

    @Autowired
    private TourService tourService;

    @PostMapping(value = "/v/1.0/tours/refresh")
    public String refresh(@RequestParam("filter") String filter, HttpServletRequest request) {
        if(!request.isUserInRole("ROLE_ADMIN")) {
            logger.info("[ ... insufficient privilege ...]");
            return ResponseEntity.status(403).build().getStatusCode().toString();
        }

        Util util = new Util();
        List<Tour> tours = null;
        try {
            tours  = util.downloadTourData(filter);
        }catch (Exception e) {
            logger.severe(e.getMessage());
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build().getStatusCode().toString();
        }

        // saving all the new tour information
        for(Tour tour: tours) tourService.save(tour);
        logger.info("[ ... tour information saved successfully...]");
        return ResponseEntity.status(OK_CODE).build().getStatusCode().toString();
    }

    @GetMapping(value = "/v/1.0/tours", produces = "application/json")
    public String getTours(@RequestParam("filter") String filter) {
        Iterator<Tour> tourIter = tourService.findAllTours().iterator();
        JSONArray array = new JSONArray();
        while(tourIter.hasNext()){
            Tour tour = (Tour) tourIter.next();
            if(filter == null || filter.isEmpty())
                array.put(tour.getName());
            else if(tour.getShortDesc().toLowerCase().contains(filter.toLowerCase()))
                array.put(tour.getName());
        }
        /// build a json response
        JSONObject jobj = new JSONObject();
        jobj.put("tours", array);
        return jobj.toString();
    }
}