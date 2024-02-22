package com.scaler.bookmyshow.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookMovieRequestDTO {
    private List<Long> showSeatIds;
    //Optional
    private Long showId;

    private Long userId;

}
