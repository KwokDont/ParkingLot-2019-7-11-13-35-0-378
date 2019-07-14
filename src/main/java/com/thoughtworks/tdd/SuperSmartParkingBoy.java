package com.thoughtworks.tdd;

public class SuperSmartParkingBoy extends Boy {

    @Override
    public Ticket parkingCar(Car car) {
        if (car != null) {
            Ticket ticket = null;
            float temp = 0;
            int index = -1;
            for (int i = 0; i < parkingLotList.size(); i++) {
                ParkingLot parkingLot = parkingLotList.get(i);
                float available = parkingLot.getRestPosition();
                float lotSize = parkingLot.getCapacity();
                float size = available / lotSize;
                if (size > temp) {
                    temp = size;
                    index = i;
                }
            }
            if (temp > 0) {
                ParkingLot parkingLot = parkingLotList.get(index);
                ticket = parkingLot.parkingCar(car);
                ticket.setParkingLot(parkingLot);
            } else {
                message = "Not enough position.";
            }
            return ticket;
        }
        return null;
    }
}
