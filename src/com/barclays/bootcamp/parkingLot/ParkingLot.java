package com.barclays.bootcamp.parkingLot;

import java.util.List;

public class ParkingLot {

    private int numberOfSlots;
    private List parkingSlots;

    public ParkingLot(int numberOfSlots, List slots) {
        this.numberOfSlots = numberOfSlots;
        this.parkingSlots = slots;
    }

    public boolean park(String carNumber) {

        if (parkingSlots.size() >= numberOfSlots || parkingSlots.contains(carNumber))
            return false;
        parkingSlots.add(carNumber);
        return true;
    }

    public boolean unpark(String carNumber) {
        if(!parkingSlots.contains(carNumber))
            return false;
        parkingSlots.remove(carNumber);
        return true;
    }

}
