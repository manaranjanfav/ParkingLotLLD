package com.lld.parkinglot.Alogorithms;

import java.util.Random;

import com.lld.parkinglot.Models.ParkingTicket;

public class ParkingTicketGeneratorRandom implements IParkingTicketGenerator{

    @Override
    public ParkingTicket generateParkingTicket() {
        
        Random rd = new Random();
        int id = rd.nextInt(100);
        ParkingTicket parkingTicket = new ParkingTicket(id);
        return parkingTicket;
    }
    
}
