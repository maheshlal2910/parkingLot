package com.barclays.bootcamp.parkingLot;

import java.util.List;

public class ParkingLot {

    private int numberOfSlots;
    private List emptySlots;

    public ParkingLot(int numberOfSlots, List slots) {
        this.numberOfSlots = numberOfSlots;
        this.emptySlots = slots;
    }

    public boolean park(String carNumber) {

        if (emptySlots.size() >= numberOfSlots || emptySlots.contains(carNumber))
            return false;
        emptySlots.add(carNumber);
        return true;
    }

    public boolean unpark(String carNumber) {
        if(!emptySlots.contains(carNumber))
            return false;
        emptySlots.remove(carNumber);
        return true;
    }

}
