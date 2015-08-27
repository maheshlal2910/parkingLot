package com.thoughtworks.objectBootcamp.parkingLot;

import com.thoughtworks.objectBootcamp.parkingLot.people.ParkingLotOwner;

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
        if (parkingLotIsFull() || carIsAlreadyParked(carNumber))
            return false;
        parkingSlots.add(carNumber);
        if (parkingLotIsFull())
            parkingLotOwner.performAction();
        return true;
    }

    public boolean driveOut(String carNumber) {
        if(!carIsAlreadyParked(carNumber))
            return false;
        parkingSlots.remove(carNumber);
        return true;
    }

    private boolean carIsAlreadyParked(String carNumber) {
        return parkingSlots.contains(carNumber);
    }

    private boolean parkingLotIsFull() {
        return parkingSlots.size() >= numberOfSlots;
    }

}
