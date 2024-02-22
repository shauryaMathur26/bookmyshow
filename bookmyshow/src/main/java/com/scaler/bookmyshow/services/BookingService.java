package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.dtos.BookMovieResponseDTO;
import com.scaler.bookmyshow.enums.BookingStatus;
import com.scaler.bookmyshow.enums.ShowSeatStatus;
import com.scaler.bookmyshow.models.Booking;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositories.BookingRepository;
import com.scaler.bookmyshow.repositories.ShowRepository;
import com.scaler.bookmyshow.repositories.ShowSeatRepository;
import com.scaler.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;

    private ShowRepository showRepository;

    private ShowSeatRepository showSeatRepository;

    private BookingRepository bookingRepository;

    private PriceCalculatorService priceCalculatorService;



    @Autowired
    public BookingService(UserRepository userRepository,ShowRepository showRepository,ShowSeatRepository showSeatRepository,BookingRepository bookingRepository,PriceCalculatorService priceCalculatorService){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(Long userId, Long showId, List<Long> showSeatIds){

        //Start Transaction
        //1. Get the user with userId

        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User NOT Found :(");
        }
        User bookedBy = userOptional.get();

        //2. Get the show with showId

        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new RuntimeException("Show NOT Found :(");
        }
        Show bookedShow = showOptional.get();

        // -- START TRANSACTION -> COVERED IN PROJECT MODULE (PlatformTransactionManager)
        //3. Get all showSeats using showSeatIDs

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        // TODO :: That all showSeatIds may not be valid

        //4. Check if ALL show Seats are available
        //5. if NOT, throw an err

        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.EMPTY)){
                throw new RuntimeException("Not all selected seats are available");
            }
        }

        //6. If yes, mark the status of show Seats as LOCKED

        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            //7. Persist updated statuses in DB
            showSeatRepository.save(showSeat); //Update in DB
        }


        // -- END TRANSACTION
        //8. Create a Booking object and save in DB

        Booking booking = new Booking();
        booking.setStatus(BookingStatus.PENDING);
        booking.setShowSeats(showSeats);
        booking.setUser(bookedBy);
        booking.setShow(bookedShow);
        booking.setBookedAt(new Date());
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats,bookedShow));
        booking.setPayments(new ArrayList<>());

        return bookingRepository.save(booking);

        // End Transaction

    }
}
