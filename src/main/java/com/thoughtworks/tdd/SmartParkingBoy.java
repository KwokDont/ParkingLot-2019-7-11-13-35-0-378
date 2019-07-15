package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.ParkingLotFullException;

import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy {

    @Override
    public Ticket parkingCar(Car car) {
        if(isFull()){
            throw new ParkingLotFullException();
        }
        ParkingLot parkingLot = parkingLotList.stream().max(Comparator.comparingInt(ParkingLot::getRestPosition)).get();
        Ticket ticket = parkingLot.parkingCar(car);
        ticket.setParkingLot(parkingLot);
        return ticket;
    }
}
