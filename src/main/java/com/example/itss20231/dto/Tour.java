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
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean closed) {
        isClosed = closed;
    }


    public void setDue(Date due) {
        this.due = due;
    }


    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }


    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }


    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    private Date toDate;
}
