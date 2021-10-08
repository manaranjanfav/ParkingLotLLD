package com.lld.parkinglot.Controllers;

import java.util.List;

import com.lld.parkinglot.Models.GateKepper;
import com.lld.parkinglot.Models.ParkingLot;
import com.lld.parkinglot.Models.ParkingTicket;
import com.lld.parkinglot.Models.Slot;
import com.lld.parkinglot.Services.ParkingLotServices;
import com.lld.parkinglot.Services.ParkingTicketService;

public class ParkingLotController {
    
    final ParkingLotServices parkingLotServices;
    final ParkingTicketService parkingTicketService;


    public ParkingLotController(ParkingLotServices parkingLotServices, ParkingTicketService parkingTicketService) {
        this.parkingLotServices = parkingLotServices;
        this.parkingTicketService = parkingTicketService;
    }

    public ParkingLot creatParkingLot(int id, int size, GateKepper gateKepper)
    {
        return parkingLotServices.createParkingSlot(id, size, gateKepper);
    }

    public Slot createSlot(ParkingLot parkingLot, int id)
    {
        return parkingLotServices.createSlot(parkingLot, id);

    }

    public List<Slot> getAllAvailabaleSlots()
    {
        return parkingLotServices.getallavailableslots();
    }

    public boolean unlockSlot(Slot slot, ParkingTicket parkingTicket)
    {
        return parkingTicketService.validateParkingTicket(slot, parkingTicket);
    }

    public void deallocateSlot(Slot slot)
    {
        parkingLotServices.deallocateSlot(slot);
    }

    public boolean checkSlotdeallocatedsuccesfully(Slot slot)
    {
     
        return parkingTicketService.validateParkingSlotdeallocated(slot);
               
    }
    

}
