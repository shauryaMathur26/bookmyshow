package com.scaler.bookmyshow.dtos;

import java.util.List;

public class BookMovieRequestDTO {
    private List<Long> showSeatIds;
    //Optional
    private Long showId;

    private Long userId;

}
