package com.lld.parkinglot.Models;

import org.springframework.lang.NonNull;

public class ParkingTicket {
    final int id;
    public ParkingTicket(@NonNull final int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }

    
    
}
