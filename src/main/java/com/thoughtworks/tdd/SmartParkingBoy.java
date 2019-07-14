package com.thoughtworks.tdd;

public class SmartParkingBoy extends ParkingBoy {

    @Override
    public Ticket parkingCar(Car car) {
        if (car != null) {
            Ticket ticket = null;
            int temp = 0, index = -1;
            for (int i = 0; i < parkingLotList.size(); i++) {
                ParkingLot parkingLot = parkingLotList.get(i);
                if ( parkingLot.getRestPosition() > temp ){
                    temp = parkingLot.getRestPosition();
                    index = i;
                }
            }
            if (temp>0){
                ParkingLot parkingLot = parkingLotList.get(index);
                ticket = parkingLot.parkingCar(car);
                ticket.setParkingLot(parkingLot);
            }else{
                message = "Not enough position.";
            }
            return ticket;
        }
        return null;
    }
}
