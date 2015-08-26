package com.barclays.bootcamp.parkingLot;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {

    @Test
    public void shouldParkACarInAParkingLog() {
        ArrayList<String> emptySlots = new ArrayList<String>();
        ParkingLot parkingLot = new ParkingLot(2, emptySlots);

        assertTrue(parkingLot.park("MH 12 KJ 9134"));
    }

    @Test
    public void shouldNotParkCarIfAlreadyParked() {
        ArrayList<String> emptySlots = new ArrayList<String>();
        ParkingLot parkingLot = new ParkingLot(2, emptySlots);

        parkingLot.park("MH 12 KJ 9134");
        assertFalse(parkingLot.park("MH 12 KJ 9134"));
    }

    @Test
    public void shouldNotParkCarIfParkingLotIsFull(){
        ArrayList<String> emptySlots = new ArrayList<String>();
        ParkingLot parkingLot = new ParkingLot(1, emptySlots);

        parkingLot.park("MH 12 KJ 9134");
        assertFalse(parkingLot.park("MH 31 AQ 3756"));
    }

    @Test
    public void shouldUnParkCarIfTheCarIsInParkingLot() {
        ArrayList<String> emptySlots = new ArrayList<String>();
        ParkingLot parkingLot = new ParkingLot(1, emptySlots);

        parkingLot.park("MH 12 KJ 9134");
        assertTrue(parkingLot.unpark("MH 12 KJ 9134"));
    }

}
