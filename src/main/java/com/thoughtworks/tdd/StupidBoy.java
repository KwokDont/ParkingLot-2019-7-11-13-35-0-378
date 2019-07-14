package com.thoughtworks.tdd;

public class StupidBoy extends ParkingBoy {

    @Override
    public Ticket parkingCar(Car car) {
        return super.parkingCar(car);
    }

    @Override
    public Car fetchCar(Ticket ticket) {
        Car car = null;
        if (ticket != null) {
            for(ParkingLot parkingLot:parkingLotList){
                car = parkingLot.fetchCar(ticket);
                if(car != null){
                    break;
                }
            }
            if(car == null){
                message = "Unrecognized parking ticket.";
            }
            return car;
        }
        message = "Please provide your parking ticket.";
        return null;
    }
}
