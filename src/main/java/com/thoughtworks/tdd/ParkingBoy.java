package com.thoughtworks.tdd;

public class ParkingBoy {

    public Ticket parkingCar(ParkingLot parkingLot, Car car) {
        return parkingLot.parkingCar(car);
    }

    public Car fetchCar(ParkingLot parkingLot, Ticket ticket) {
        if (ticket != null) {
            return parkingLot.fetchCar(ticket);
        }
        return null;
    }
}
