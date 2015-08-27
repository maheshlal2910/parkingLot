package com.thoughtworks.objectBootcamp.parkingLot;

import com.thoughtworks.objectBootcamp.parkingLot.event.IAmAParkingLotEvent;

import java.util.List;

public class ParkingLot {

    private int numberOfSlots;
    private List<String> parkingSlots;
    private List<IAmAParkingLotEvent> parkingLotEvents;

    public ParkingLot(int numberOfSlots, List<String> slots, List<IAmAParkingLotEvent> parkingLotEvents) {
        this.numberOfSlots = numberOfSlots;
        this.parkingSlots = slots;
        this.parkingLotEvents = parkingLotEvents;
    }

    public boolean park(String carNumber) {
        if (parkingLotIsFull() || carIsAlreadyParked(carNumber))
            return false;
        parkingSlots.add(carNumber);
        for(IAmAParkingLotEvent event : parkingLotEvents){
            event.notifySubscribersIfThresholdBreachedFor(percentageOfParkingSlotsFull());
        }
        return true;
    }

    private double percentageOfParkingSlotsFull() {
        return (parkingSlots.size()/(double)numberOfSlots)*100.0;
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
