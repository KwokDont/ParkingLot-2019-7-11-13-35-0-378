package com.thoughtworks.tdd;

public class Ticket {

    private ParkingLot parkingLot;

    public Ticket(){}

    public Ticket(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
