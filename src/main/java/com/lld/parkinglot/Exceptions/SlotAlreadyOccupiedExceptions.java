package com.lld.parkinglot.Exceptions;

public class SlotAlreadyOccupiedExceptions extends RuntimeException {
    

    public SlotAlreadyOccupiedExceptions() {
        super("Slot is alreadyOccupied");
    }

}
