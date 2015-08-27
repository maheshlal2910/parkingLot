package com.thoughtworks.objectBootcamp.parkingLot.event;

public interface IAmAParkingLotEvent {

    public void notifySubscribersIfThresholdBreached(int parkingPercentageFull);

}
