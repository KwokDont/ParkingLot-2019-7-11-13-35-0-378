package com.thoughtworks.tdd;

public class ParkingBoy {

    private String talkContent;

    public Ticket parkingCar(ParkingLot parkingLot, Car car) {
        if(parkingLot.getRestPosition() == 0){
            talkContent = "Not enough position.";
            return null;
        }
        Ticket ticket = parkingLot.parkingCar(car);
        return ticket;
    }

    public Car fetchCar(ParkingLot parkingLot, Ticket ticket) {
        if (ticket != null) {
            if(!parkingLot.getCars().containsKey(ticket)){
                talkContent = "Unrecognized parking ticket.";
                return null;
            }else{
                return parkingLot.fetchCar(ticket);
            }
        }
        talkContent = "Please provide your parking ticket.";
        return null;
    }

    public String showMessage(){
        return talkContent;
    }
}
