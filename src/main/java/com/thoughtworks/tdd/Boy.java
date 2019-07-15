package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.TicketMissingException;
import com.thoughtworks.tdd.exception.UnrecognizedTicketException;

import java.util.ArrayList;
import java.util.List;

public abstract class Boy implements Parkable{
    protected String message = "";
    protected List<ParkingLot> parkingLotList = new ArrayList<>();

    public abstract Ticket parkingCar(Car car);

    public Car fetchCar(Ticket ticket) throws TicketMissingException{
        if (ticket == null) {
            throw new TicketMissingException();
        }
        if(!containTicket(ticket)){
            throw new UnrecognizedTicketException();
        }
        ParkingLot parkingLot = parkingLotList.stream().filter(parkingLot1 -> parkingLot1.containTicket(ticket)).findFirst().get();
        return parkingLot.fetchCar(ticket);
    }

    public boolean isFull(){
        return parkingLotList.stream().allMatch(parkingLot1 -> parkingLot1.isFull());
    }

    public boolean containTicket(Ticket ticket){
        return parkingLotList.stream().anyMatch(parkingLot -> parkingLot.containTicket(ticket));
    }

    public void addParkingLot(ParkingLot parkingLot){
        this.parkingLotList.add(parkingLot);
    }

    public String showMessage(){
        return message;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }
}
