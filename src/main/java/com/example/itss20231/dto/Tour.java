package com.example.itss20231.dto;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Table(name= "tours")
@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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

    public Tour() {
    }

    public Tour(String name, double price, String description, String status, boolean isClosed, Date due, int maxCapacity, Date fromDate, Date toDate, String url) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.status = status;
        this.isClosed = isClosed;
        this.due = due;
        this.maxCapacity = maxCapacity;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.url = url;
    }
}
