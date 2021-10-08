package com.lld.parkinglot.Services;

import com.lld.parkinglot.Alogorithms.IParkingTicketGenerator;
import com.lld.parkinglot.Models.ParkingTicket;
import com.lld.parkinglot.Models.Slot;
import com.lld.parkinglot.Repositories.IParkingTicketRepository;

public class ParkingTicketService {
    
    
    final IParkingTicketGenerator parkingTicketGenerator;
    
    final IParkingTicketRepository parkingTicketRepository;


    public ParkingTicketService(IParkingTicketGenerator parkingTicketGenerator, IParkingTicketRepository parkingTicketRepository) {
        this.parkingTicketGenerator = parkingTicketGenerator;
        this.parkingTicketRepository = parkingTicketRepository;
    }

    public ParkingTicket generateParkingTicket(Slot slot)
    {
        ParkingTicket parkingTicket = parkingTicketGenerator.generateParkingTicket();
        parkingTicketRepository.addSlotparkingticket(parkingTicket, slot.getId());

        return parkingTicket;
    }

    public boolean validateParkingTicket(Slot slot, ParkingTicket parkingTicket)
    {
        ParkingTicket parkingTicket2 = parkingTicketRepository.getParkingTicket(slot.getId());
        return ( parkingTicket2!=null && parkingTicket.equals(parkingTicket2));
    }

    public boolean validateParkingSlotdeallocated(Slot slot)
    {
        return slot.isAvailable();
    }

    public int searchvehicle(ParkingTicket parkingTicket)
    {
        int slotId = parkingTicketRepository.getParkingSlot(parkingTicket);
        return slotId;
    }
    
    

}
