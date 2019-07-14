package com.thoughtworks.tdd;

public class ParkingBoy {

    public Ticket parkingCar(Car car) {
        Ticket ticket = new Ticket(car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        Car car = ticket.fecthCar();
        return car;
    }
}
