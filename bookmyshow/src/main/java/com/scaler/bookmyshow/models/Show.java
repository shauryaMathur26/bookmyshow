package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Feature;
import com.scaler.bookmyshow.enums.ShowStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Show extends BaseModel{
    private Movie movie;
    private Date startingTime;
    private Date endTime;
    private Screen screen;
    private List<Feature> features;
    private ShowStatus status;

}
