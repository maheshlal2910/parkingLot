package com.thoughtworks.objectBootcamp.parkingLot.event;

import com.thoughtworks.objectBootcamp.parkingLot.people.IAmASubscriber;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class Parking80PercentFullTest {

    @Test
    public void shouldNotifySubscribersIfTheThresholdIsBreached(){
        IAmASubscriber firstMockSubscriber = mock(IAmASubscriber.class);
        IAmASubscriber secondMockSubscriber = mock(IAmASubscriber.class);
        ArrayList<IAmASubscriber> subscribers = new ArrayList<>();
        subscribers.add(firstMockSubscriber);
        subscribers.add(secondMockSubscriber);
        Parking80PercentFull parking80PercentFull = new Parking80PercentFull(subscribers, 80);

        parking80PercentFull.notifySubscribersIfThresholdBreachedFor(80);

        verify(firstMockSubscriber).performAction();
        verify(secondMockSubscriber).performAction();
    }

}