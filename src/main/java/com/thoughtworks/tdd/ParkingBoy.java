package com.thoughtworks.tdd;

import java.security.PublicKey;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ParkingBoy extends Boy{


    @Override
    public Ticket parkingCar(Car car) {
        if(car == null){
            return null;
        }
        Ticket ticket = null;
        ticket = parkingLotList.get(0).parkingCar(car);
        if(ticket == null){
            message = "Not enough position.";
        }
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        if (ticket != null) {
            if(!parkingLotList.get(0).getCars().containsKey(ticket)){
                message = "Unrecognized parking ticket.";
                return null;
            }else{
                return parkingLotList.get(0).fetchCar(ticket);
            }
        }
        message = "Please provide your parking ticket.";
        return null;
    }
}
