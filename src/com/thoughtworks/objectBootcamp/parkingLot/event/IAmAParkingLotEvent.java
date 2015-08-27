package com.thoughtworks.objectBootcamp.parkingLot.event;

public interface IAmAParkingLotEvent {

    public void notifySubscribersIfThresholdBreachedFor(double parkingPercentageFull);

}
