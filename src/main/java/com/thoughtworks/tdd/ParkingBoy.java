package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.ParkingLotFullException;

public class ParkingBoy extends Boy implements Parkable {


    @Override
    public Ticket parkingCar(Car car) {
        if(isFull()){
            throw new ParkingLotFullException();
        }
        ParkingLot parkingLot = parkingLotList.stream().filter(parkingLot1 -> !parkingLot1.isFull()).findFirst().get();
        Ticket ticket = parkingLot.parkingCar(car);
        if(ticket != null){
            ticket.setParkingLot(parkingLot);
        }
        return ticket;
    }
}
