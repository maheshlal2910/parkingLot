package com.thoughtworks.objectBootcamp.parkingLot.event;

import com.thoughtworks.objectBootcamp.parkingLot.people.IAmASubscriber;

import java.util.ArrayList;

public class Parking80PercentFull implements IAmAParkingLotEvent {

    private ArrayList<IAmASubscriber> subscribers;
    private int threshold;

    public Parking80PercentFull(ArrayList<IAmASubscriber> subscribers, int threshold) {
        this.subscribers = subscribers;
        this.threshold = threshold;
    }

    @Override
    public void notifySubscribersIfThresholdBreachedFor(double parkingPercentageFull) {
        subscribers.forEach(com.thoughtworks.objectBootcamp.parkingLot.people.IAmASubscriber::performAction);
    }
}
