package com.thoughtworks.objectBootcamp.parkingLot.event;

import com.thoughtworks.objectBootcamp.parkingLot.people.IAmASubscriber;

import java.util.List;

public class PercentageOfParkingFullEvent implements IAmAParkingLotEvent{

    private List<IAmASubscriber> subscribers;
    private int threshold;

    public PercentageOfParkingFullEvent(List<IAmASubscriber> subscribers, int threshold) {
        this.subscribers = subscribers;
        this.threshold = threshold;
    }

    @Override
    public void notifySubscribersIfThresholdBreachedFor(double parkingPercentageFull) {
        if (parkingPercentageFull <= threshold)
            subscribers.forEach(IAmASubscriber::performAction);
    }
}
