package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.ShowSeatStatus;
import lombok.Data;

@Data
public class ShowSeat extends BaseModel{
    private Show show;
    private Seat seat;
    private ShowSeatStatus status;
}
