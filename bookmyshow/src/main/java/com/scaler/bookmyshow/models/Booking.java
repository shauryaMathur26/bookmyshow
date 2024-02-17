package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import sun.jvm.hotspot.debugger.cdbg.BaseClass;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Booking extends BaseModel{

    //(1,CANCEL),(2,BOOKED)
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;

    //1:M
    //M:1 == M:M
    @ManyToMany
    private List<ShowSeat> showSeats;

    //1:1
    //M:1
    @ManyToOne
    private User user;
    private Date bookedAt;
    //Booking : Show
    //1:1
    //M:1
    @ManyToOne
    private Show show;
    private int amount;

    //Booking : Show
    // 1:M
    //1:1
    @OneToMany
    private List<Payment> payments;



}


// ORM - Object Relation Mapping
// JPA - Java Persistence API - standard/guidelines set by Java to achieve ORM techniques (RBI Guidelines)
// Hibernate - one of the most popular implementation is hibernate (ORM Tool) -> YesBank
