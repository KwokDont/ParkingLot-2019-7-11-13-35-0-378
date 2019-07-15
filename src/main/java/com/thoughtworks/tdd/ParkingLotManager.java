package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.ParkingLotFullException;
import com.thoughtworks.tdd.exception.TicketMissingException;
import com.thoughtworks.tdd.exception.UnrecognizedTicketException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotManager implements Parkable {
    private List<Parkable> parkables = new ArrayList<>();

    public ParkingLotManager(Parkable... parkers){
        this.parkables.addAll(Arrays.asList(parkers));
    }

    @Override
    public Ticket parkingCar(Car car) {
        for(Parkable parkable : parkables){
            if(!parkable.isFull()){
                return parkable.parkingCar(car);
            }
        }
        throw new ParkingLotFullException();
    }

    @Override
    public Car fetchCar(Ticket ticket) throws TicketMissingException {
        for(Parkable parkable : parkables){
            if(parkable.containTicket(ticket)){
                return parkable.fetchCar(ticket);
            }
        }
        throw new UnrecognizedTicketException();
    }

    public void addParkable(Parkable parkable){
        parkables.add(parkable);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean containTicket(Ticket ticket) {
        return false;
    }

    public List<Parkable> getParkables() {
        return parkables;
    }

    public void setParkables(List<Parkable> parkables) {
        this.parkables = parkables;
    }
}
