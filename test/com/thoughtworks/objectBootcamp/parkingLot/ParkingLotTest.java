package com.thoughtworks.objectBootcamp.parkingLot;


import com.thoughtworks.objectBootcamp.parkingLot.event.IAmAParkingLotEvent;
import com.thoughtworks.objectBootcamp.parkingLot.people.ParkingLotOwner;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;


public class ParkingLotTest {

    private ParkingLotOwner mockParkingLotOwner;
    private IAmAParkingLotEvent firstEvent;
    private IAmAParkingLotEvent secondEvent;
    private List<IAmAParkingLotEvent> events;
    private ParkingLot parkingLot;

    @Before
    public void setup() {
        mockParkingLotOwner = mock(ParkingLotOwner.class);
        firstEvent = mock(IAmAParkingLotEvent.class);
        secondEvent = mock(IAmAParkingLotEvent.class);
        events = new ArrayList<>();
        events.add(firstEvent);
        events.add(secondEvent);
        parkingLot = new ParkingLot(2, new ArrayList<>(), events);

    }
    @Test
    public void shouldParkACarInAParkingLog() {
        assertTrue(parkingLot.park("MH 12 KJ 9134"));
    }

    @Test
    public void shouldNotParkCarIfAlreadyParked() {
        parkingLot.park("MH 12 KJ 9134");
        assertFalse(parkingLot.park("MH 12 KJ 9134"));
    }

    @Test
    public void shouldNotParkCarIfParkingLotIsFull() {
        parkingLot.park("MH 12 KJ 9134");
        parkingLot.park("MH 12 KL 9124");

        assertFalse(parkingLot.park("MH 31 AQ 3756"));
    }

    @Test
    public void shouldRaiseEventsWithWhatPercentageOfParkingLotIsFull() {
        parkingLot.park("MH 12 KJ 9134");

        verify(firstEvent).notifySubscribersIfThresholdBreachedFor(50.0);
        verify(secondEvent).notifySubscribersIfThresholdBreachedFor(50.0);
    }

    @Test
    public void shouldUnParkCarIfTheCarIsInParkingLot() {
        parkingLot.park("MH 12 KJ 9134");
        assertTrue(parkingLot.driveOut("MH 12 KJ 9134"));
    }

    @Test
    public void shouldNotUnParkCarIfTheCarIsNotInParkingLot() {
        parkingLot.park("MH 12 KJ 9134");
        assertFalse(parkingLot.driveOut("MH 31 AQ 3756"));
    }

}
