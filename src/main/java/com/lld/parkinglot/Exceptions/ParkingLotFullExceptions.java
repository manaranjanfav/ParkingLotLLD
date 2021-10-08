package com.lld.parkinglot.Exceptions;

public class ParkingLotFullExceptions extends RuntimeException {

    public ParkingLotFullExceptions() {
        super("Space is full for the parking Lot");
    }
    
}
