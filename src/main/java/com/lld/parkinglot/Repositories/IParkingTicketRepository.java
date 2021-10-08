package com.lld.parkinglot.Repositories;

import com.lld.parkinglot.Models.ParkingTicket;

import org.springframework.lang.NonNull;

public interface IParkingTicketRepository {
    
    public void addSlotparkingticket(@NonNull final ParkingTicket parkingTicket, int slotId);
    public ParkingTicket getParkingTicket(int slotId);
    public int getParkingSlot(ParkingTicket parkingTicket);
    
}
