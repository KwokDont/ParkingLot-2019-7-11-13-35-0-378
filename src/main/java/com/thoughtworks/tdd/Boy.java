package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public abstract class Boy {
    protected String message = "";
    protected List<ParkingLot> parkingLotList = new ArrayList<>();

    public abstract Ticket parkingCar(Car car);

    public Car fetchCar(Ticket ticket) {
        if (ticket != null) {
            if(!parkingLotList.get(0).getCars().containsKey(ticket)){
                message = "Unrecognized parking ticket.";
                return null;
            }else{
                return parkingLotList.get(0).fetchCar(ticket);
            }
        }
        message = "Please provide your parking ticket.";
        return null;
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
