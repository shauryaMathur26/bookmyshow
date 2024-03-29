package com.scaler.bookmyshow.dtos;


import com.scaler.bookmyshow.enums.ResponseStatus;
import lombok.Data;

@Data
public class BookMovieResponseDTO {
    private int amount;
    private Long bookingId;
    private ResponseStatus responseStatus;
}
