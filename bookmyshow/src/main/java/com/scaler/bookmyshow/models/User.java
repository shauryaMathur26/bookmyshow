package com.scaler.bookmyshow.models;

import lombok.Data;

import java.util.List;
@Data
public class User extends BaseModel{
    private String name;
    private String email;
    private String phoneNumber;
    private List<Booking> bookings;
}
