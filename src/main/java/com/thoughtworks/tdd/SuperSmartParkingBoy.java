package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.ParkingLotFullException;

public class SuperSmartParkingBoy extends Boy {

    @Override
    public Ticket parkingCar(Car car) {
        Ticket ticket = null;
        float temp = 0;
        int index = -1;
        if(isFull()){
            throw new ParkingLotFullException();
        }
        for (int i = 0; i < parkingLotList.size(); i++) {
            ParkingLot parkingLot = parkingLotList.get(i);
            float available = parkingLot.getRestPosition();
            float lotSize = parkingLot.getCapacity();
            float size = available / lotSize;
            if (size > temp) {
                temp = size;
                index = i;
            }
        }
        ParkingLot parkingLot = parkingLotList.get(index);
        ticket = parkingLot.parkingCar(car);
        ticket.setParkingLot(parkingLot);
        return ticket;
    }
}
