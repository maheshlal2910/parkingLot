package com.barclays.bootcamp.parkingLot;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class ParkingLotTest {

    @Test
    public void shouldParkACarInAParkingLog(){
        ArrayList<String> emptySlots = new ArrayList<String>();
        ParkingLot parkingLot = new ParkingLot(emptySlots);

        assertTrue(parkingLot.park("MH 12 KJ 9134"));
    }
}
