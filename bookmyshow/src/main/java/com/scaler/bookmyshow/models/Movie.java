package com.scaler.bookmyshow.models;

import lombok.Data;

import java.util.List;

@Data
public class Movie extends BaseModel{
    private String name;
    List<String> actors;
}
