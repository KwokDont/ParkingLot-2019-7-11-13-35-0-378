package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager extends ParkingBoy {
    private List<Boy> parkingBoyList = new ArrayList<>();

    public void addParkingBoy(Boy boy){
        parkingBoyList.add(boy);
    }

    public List<Boy> getParkingBoyList() {
        return parkingBoyList;
    }
}
