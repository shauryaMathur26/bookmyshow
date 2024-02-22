package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.ShowSeatType;
import com.scaler.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {

    @Autowired
    private ShowSeatTypeRepository showSeatTypeRepository;

    public int calculatePrice(List<ShowSeat> showSeatList, Show show){

        //1. Get all showSeatType for that show
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        //2. Get seatType of the showSeats
        //3. Add amount for all seats
        int amount = 0;

        for(ShowSeat showSeat : showSeatList){
            for(ShowSeatType showSeatType : showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;

    }
}

//ShowId SeatType Price
// 1 Gold 100
// 1 Platinum 200
// 2 Maharaje 500
// 3 Supreme 1000