package com.thoughtworks.objectBootcamp.parkingLot.event;

import java.util.List;

public class ParkingFull implements IAmAParkingLotEvent{

    private List<IAmASubscriber> subscribers;
    private int threshold;

    public ParkingFull(List<IAmASubscriber> subscribers, int threshold) {
        this.subscribers = subscribers;
        this.threshold = threshold;
    }


    @Override
    public void notifySubscribersIfThresholdBreached(int parkingPercentageFull) {
        if (parkingPercentageFull <= threshold)
            subscribers.forEach(com.thoughtworks.objectBootcamp.parkingLot.event.IAmASubscriber::performAction);
    }
}
