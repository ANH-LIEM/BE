package com.example.itss20231.dao.request;

import com.example.itss20231.dto.Tour;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Data
public class TourCreationRequest {
    private String name;
    private double price;
    private String description;
    private String status;
    private boolean isClosed;
    private Date due;
    private int maxCapacity;
    private Date fromDate;
    private Date toDate;
    private String url;
    @Getter
    private List<Integer> locations;

    public TourCreationRequest() {
    }

    public Tour toTour() {
        return new Tour(name, price, description, status, isClosed, due, maxCapacity, fromDate, toDate, url);
    }
}
