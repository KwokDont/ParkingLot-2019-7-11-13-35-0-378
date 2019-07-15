package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.TicketMissingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotManager extends Boy {
    private List<Boy> parkingBoys = new ArrayList<>();
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingLotManager(Boy... boys){
        this.parkingBoys.addAll(Arrays.asList(boys));
    }

    public ParkingLotManager(ParkingLot... Lots){
        this.parkingLots.addAll(Arrays.asList(Lots));
    }

    @Override
    public Ticket parkingCar(Car car) {
        for(Boy boy : parkingBoys){
            if(!boy.isFull()){
                return boy.parkingCar(car);
            }
        }
        for(ParkingLot parkingLot : parkingLots){
            if(!parkingLot.isFull()){
                return parkingLot.parkingCar(car);
            }
        }
        return null;
    }

    @Override
    public Car fetchCar(Ticket ticket) throws TicketMissingException {
        for(Boy boy : parkingBoys){
            if(boy.containTicket(ticket)){
                return boy.fetchCar(ticket);
            }
        }
        for(ParkingLot parkingLot : parkingLots){
            if(parkingLot.containsTicket(ticket)){
                return parkingLot.fetchCar(ticket);
            }
        }
        return null;
    }

    public void addParkingBoy(Boy boy){
        parkingBoys.add(boy);
    }

    public List<Boy> getParkingBoys() { return parkingBoys; }

    public void setParkingBoys(List<Boy> parkingBoys) { this.parkingBoys = parkingBoys; }
}
