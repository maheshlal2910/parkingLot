package com.thoughtworks.objectBootcamp.parkingLot.event;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ParkingFullTest {

    @Test
    public void shouldNotifySubscribersIfThethresholdIsBreached(){
        IAmASubscriber firstMockSubscriber = mock(IAmASubscriber.class);
        IAmASubscriber secondMockSubscriber = mock(IAmASubscriber.class);
        ArrayList<IAmASubscriber> subscribers = new ArrayList<>();
        subscribers.add(firstMockSubscriber);
        subscribers.add(secondMockSubscriber);
        ParkingFull parkingFull = new ParkingFull(subscribers, 100);
        parkingFull.notifySubscribersIfThresholdBreached(100);
        verify(firstMockSubscriber).performAction();
        verify(secondMockSubscriber).performAction();
    }

}