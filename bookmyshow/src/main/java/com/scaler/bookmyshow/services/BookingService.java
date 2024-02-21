package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.dtos.BookMovieResponseDTO;

import java.util.List;

public class BookingService {
    public BookMovieResponseDTO bookTicket(Long userId, Long showId, List<Long> showSeatIds){

        //Start Transaction
        //1. Get the user with userId
        //2 Get the show with showId
        //3. Get all showSeats using showSeatIDs
        //4. Check if ALL show Seats are available
        //5. if NOT, throw an err
        //6. If yes, mark the status of show Seats as LOCKED
        //7. Persist updated statuses in DB
        //8. Create a Booking object and save in DB
        //9. Create and Return BookMovieResponseDTO
        // End Transaction

        return null;

    }
}
