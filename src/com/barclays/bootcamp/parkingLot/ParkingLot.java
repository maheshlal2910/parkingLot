package com.barclays.bootcamp.parkingLot;

import java.util.List;

public class ParkingLot {

    private List emptySlots;

    public ParkingLot(List slots) {
        this.emptySlots = slots;
    }

    public boolean park(String carNumber) {
        emptySlots.add(carNumber);
        return true;
    }
}
