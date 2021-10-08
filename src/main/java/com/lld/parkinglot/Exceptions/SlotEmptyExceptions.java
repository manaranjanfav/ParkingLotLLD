package com.lld.parkinglot.Exceptions;

public class SlotEmptyExceptions extends RuntimeException{

    public SlotEmptyExceptions() {
        super("All slots are exhausted");
    }
    
}
