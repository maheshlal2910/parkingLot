package com.thoughtworks.objectBootcamp.parkingLot;


import com.thoughtworks.objectBootcamp.parkingLot.people.ParkingLotOwner;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;


public class ParkingLotTest {

    ParkingLotOwner mockParkingLotOwner = mock(ParkingLotOwner.class);

    @Test
    public void shouldParkACarInAParkingLog() {
        ArrayList<String> emptySlots = new ArrayList<String>();
        ParkingLot parkingLot = new ParkingLot(2, emptySlots, mockParkingLotOwner);
        assertTrue(parkingLot.park("MH 12 KJ 9134"));
    }

    @Test
    public void shouldNotParkCarIfAlreadyParked() {
        ArrayList<String> emptySlots = new ArrayList<String>();
        ParkingLot parkingLot = new ParkingLot(1, emptySlots, mockParkingLotOwner);
        parkingLot.park("MH 12 KJ 9134");
        assertFalse(parkingLot.park("MH 12 KJ 9134"));
    }

    @Test
    public void shouldNotParkCarIfParkingLotIsFull() {
        ArrayList<String> emptySlots = new ArrayList<String>();
        ParkingLot parkingLot = new ParkingLot(1, emptySlots, mockParkingLotOwner);

        parkingLot.park("MH 12 KJ 9134");
        assertFalse(parkingLot.park("MH 31 AQ 3756"));
    }

    @Test
    public void shouldNotifyParkingLotOwnerIfParkingIsFull() {
        ArrayList<String> emptySlots = new ArrayList<String>();
        ParkingLot parkingLot = new ParkingLot(1, emptySlots, mockParkingLotOwner);
        parkingLot.park("MH 12 KJ 9134");
        parkingLot.park("MH 31 AQ 3756");
        verify(mockParkingLotOwner).performAction();
    }

    @Test
    public void shouldUnParkCarIfTheCarIsInParkingLot() {
        ArrayList<String> emptySlots = new ArrayList<String>();
        ParkingLot parkingLot = new ParkingLot(1, emptySlots, mockParkingLotOwner);

        parkingLot.park("MH 12 KJ 9134");
        assertTrue(parkingLot.driveOut("MH 12 KJ 9134"));
    }

    @Test
    public void shouldNotUnParkCarIfTheCarIsNotInParkingLot() {
        ArrayList<String> emptySlots = new ArrayList<String>();
        ParkingLot parkingLot = new ParkingLot(1, emptySlots, mockParkingLotOwner);

        parkingLot.park("MH 12 KJ 9134");
        assertFalse(parkingLot.driveOut("MH 31 AQ 3756"));
    }

    @Test
    public void shouldNotifySecurityWhenTheParkingLotIs80PercentFull() {
        ArrayList<String> emptySlots = new ArrayList<String>();
        ParkingLot parkingLot = new ParkingLot(1, emptySlots, mockParkingLotOwner);

        parkingLot.park("MH 12 KJ 9134");
        assertFalse(parkingLot.driveOut("MH 31 AQ 3756"));
    }

}
