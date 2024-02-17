package com.scaler.bookmyshow.models;

import lombok.Data;

@Data
public class ShowSeatType extends BaseModel{
    private Show show;
    private SeatType seatType;
    private int price;
}
