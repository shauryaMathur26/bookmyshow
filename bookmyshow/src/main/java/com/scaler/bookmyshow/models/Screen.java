package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Feature;
import lombok.Data;

import java.util.List;

@Data
public class Screen extends BaseModel{
    private String name;
    private List<Seat> seats;
    private List<Feature> features;
    private Theatre theatre;
}
