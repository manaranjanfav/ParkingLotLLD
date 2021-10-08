package com.lld.parkinglot.Repositories;

import java.util.HashMap;
import java.util.Map;

import com.lld.parkinglot.Models.ParkingTicket;

public class ParkingTicketRepositoryInMemory implements IParkingTicketRepository{

   final Map<Integer,ParkingTicket> slotIdToTicketMap;
   final Map<ParkingTicket,Integer> TicketToSlot;

    public ParkingTicketRepositoryInMemory() {
        this.slotIdToTicketMap = new HashMap<>();
        this.TicketToSlot = new HashMap<>();
    }
       
    @Override
    public void addSlotparkingticket(ParkingTicket parkingTicket, int slotId) {
        
        slotIdToTicketMap.put(slotId, parkingTicket);
        TicketToSlot.put(parkingTicket, slotId);
        
    }

    @Override
    public ParkingTicket getParkingTicket(int slotId) {
        
        return slotIdToTicketMap.get(slotId);
    }

    @Override
    public int getParkingSlot(ParkingTicket parkingTicket) {
        
        return TicketToSlot.get(parkingTicket);
    }
    
}
