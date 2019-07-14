package com.thoughtworks.tdd;

public class ParkingBoy {

    private String talkContent;

    public Ticket parkingCar(ParkingLot parkingLot, Car car) {
        Ticket ticket = parkingLot.parkingCar(car);
        if(ticket == null){
            talkContent = "Park car failed for there is no position";
            talk();
        }
        return ticket;
    }

    public Car fetchCar(ParkingLot parkingLot, Ticket ticket) {
        if (ticket != null) {
            return parkingLot.fetchCar(ticket);
        }
        return null;
    }

    public void talk(){
        System.out.println(talkContent);
    }
}
