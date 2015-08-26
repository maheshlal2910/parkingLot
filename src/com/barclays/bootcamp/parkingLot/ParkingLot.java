package com.barclays.bootcamp.parkingLot;

import java.util.List;

public class ParkingLot {

    private int numberOfSlots;
    private List<String> parkingSlots;
    private ParkingLotOwner parkingLotOwner;

    public ParkingLot(int numberOfSlots, List<String> slots, ParkingLotOwner parkingLotOwner) {
        this.numberOfSlots = numberOfSlots;
        this.parkingSlots = slots;
        this.parkingLotOwner = parkingLotOwner;
    }

    public boolean park(String carNumber) {
        if (parkingSlots.size() >= numberOfSlots) {
            parkingLotOwner.putUpParkingFullSign();
            return false;
        }
        else if (parkingSlots.contains(carNumber))
            return false;
        parkingSlots.add(carNumber);
        return true;
    }

    public boolean driveOut(String carNumber) {
        if(!parkingSlots.contains(carNumber))
            return false;
        parkingSlots.remove(carNumber);
        return true;
    }

}
