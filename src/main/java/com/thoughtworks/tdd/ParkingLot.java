package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private int restPosition;
    private ParkingLotManager parkingLotManager;
    private Map<Ticket, Car> cars = new HashMap<>();

    public ParkingLot(){
        this.capacity = 1;
        this.restPosition = capacity;
    }

    public ParkingLot(int capacity){
        this.capacity = capacity;
        this.restPosition = capacity;
    }

    public Ticket parkingCar(Car car) {
        if(restPosition == 0){
            return null;
        }
        if(cars.containsValue(car)){
            return null;
        }
        Ticket ticket = new Ticket();
        cars.put(ticket, car);
        restPosition--;
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        if (cars.containsKey(ticket)) {
            Car car = cars.get(ticket);
            cars.remove(ticket);
            restPosition++;
            return car;
        }
        return null;
    }

    public boolean containsTicket(Ticket ticket){
        return cars.containsKey(ticket);
    }

    public boolean isFull(){ return restPosition == 0; }

    public int getCapacity() {
        return capacity;
    }

    public double getAvailableRate(){
        double cap = (double) getCapacity();
        return (double) restPosition / cap;
    }

    public ParkingLotManager getParkingLotManager() {
        return parkingLotManager;
    }

    public void setParkingLotManager(ParkingLotManager parkingLotManager) {
        this.parkingLotManager = parkingLotManager;
    }

    public int getRestPosition() {
        return restPosition;
    }

    public void setRestPosition(int restPosition) {
        this.restPosition = restPosition;
    }

    public Map<Ticket, Car> getCars() {
        return cars;
    }

    public void setCars(Map<Ticket, Car> cars) {
        this.cars = cars;
    }

}
