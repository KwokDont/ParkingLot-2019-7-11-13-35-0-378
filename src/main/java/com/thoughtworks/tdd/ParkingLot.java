package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<Ticket, Car> cars = new HashMap<>();

    public ParkingLot(){ this.capacity = 2; }

    public ParkingLot(int capacity){ this.capacity = capacity; }

    public Ticket parkingCar(Car car) {
        if (car != null) {
            Ticket ticket = new Ticket();
            cars.put(ticket, car);
            return ticket;
        }
        return null;
    }

    public Car fetchCar(Ticket ticket) {
        if (cars.containsKey(ticket)) {
            Car car = cars.get(ticket);
            cars.remove(ticket);
            return car;
        }
        return null;
    }
}
