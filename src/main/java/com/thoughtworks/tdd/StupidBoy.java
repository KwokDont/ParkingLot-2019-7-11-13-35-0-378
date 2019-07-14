package com.thoughtworks.tdd;

public class StupidBoy extends ParkingBoy {

    @Override
    public Ticket parkingCar(Car car) {
        if(car == null){
            return null;
        }
        Ticket ticket = null;
        for(ParkingLot parkingLot:parkingLotList){
            ticket = parkingLot.parkingCar(car);
            if(ticket != null){
                break;
            }
        }
        if(ticket == null){
            message = "Not enough position.";
        }
        return ticket;
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
