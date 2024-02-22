package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.BookMovieRequestDTO;
import com.scaler.bookmyshow.dtos.BookMovieResponseDTO;
import com.scaler.bookmyshow.enums.ResponseStatus;
import com.scaler.bookmyshow.models.Booking;
import com.scaler.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    public BookMovieResponseDTO bookTicket(BookMovieRequestDTO bookMovieRequestDTO){
        BookMovieResponseDTO responseDTO = new BookMovieResponseDTO();
        try{
            Booking booking = bookingService.bookTicket(bookMovieRequestDTO.getUserId(), bookMovieRequestDTO.getShowId(), bookMovieRequestDTO.getShowSeatIds());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setBookingId(booking.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
