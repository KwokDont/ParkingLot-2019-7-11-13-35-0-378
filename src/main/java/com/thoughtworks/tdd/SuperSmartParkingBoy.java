package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.ParkingLotFullException;

import java.util.Comparator;

public class SuperSmartParkingBoy extends Boy implements Parkable {

    @Override
    public Ticket parkingCar(Car car) {
        if(isFull()){
            throw new ParkingLotFullException();
        }
        ParkingLot parkingLot = parkingLotList.stream().max(Comparator.comparingDouble(ParkingLot::getAvailableRate)).orElse(null);
        Ticket ticket = parkingLot.parkingCar(car);
        ticket.setParkingLot(parkingLot);
        return ticket;
    }
}
