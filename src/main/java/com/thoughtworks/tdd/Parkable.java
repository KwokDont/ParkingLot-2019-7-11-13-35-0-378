package com.thoughtworks.tdd;

public interface Parkable {

    Ticket parkingCar(Car car);

    Car fetchCar(Ticket ticket);

    boolean isFull();

    boolean containTicket(Ticket ticket);
}
