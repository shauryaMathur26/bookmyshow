package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Movie extends BaseModel{
    private String name;
//    private List<String> actors;
}
