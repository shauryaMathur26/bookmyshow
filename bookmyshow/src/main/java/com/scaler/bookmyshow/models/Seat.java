package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    private int rowVal;
    private int colVal;
    //Seat SeatType
    //1 : 1
    //M : 1
    @ManyToOne
    private SeatType seatType;
}
