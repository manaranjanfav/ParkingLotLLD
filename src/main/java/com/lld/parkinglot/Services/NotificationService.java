package com.lld.parkinglot.Services;

import java.util.List;

import com.lld.parkinglot.Models.ParkingTicket;
import com.lld.parkinglot.Models.ParkingUser;
import com.lld.parkinglot.Models.Slot;

public class NotificationService {
    
    public void notifyParkingUserForCheckIn(ParkingUser parkingUser, ParkingTicket parkingTicket)
    {
        System.out.println("Send notification of check in "+ parkingTicket + " to " + parkingUser);
    }

    public void notifyParkingUserForCheckOut(ParkingUser parkingUser, Slot slot)
    {
        System.out.println("Send notification of checkout "+ slot + "to " + parkingUser);
    }

    public void notifySearchedVehicle(ParkingUser parkingUser, int slotId)
    {
        System.out.println("Send notification of Vehicle Search "+ slotId + "to " + parkingUser);
    }

    public void viewAvailableSlots(List<Slot> slots)
    {
        for(Slot slot: slots)
        {
            System.out.println(slot.getId());
        }
        
    }
    
    public void notifyParkingUserForAvailableSlots(ParkingUser parkingUser, List<Slot> slots)
    {
        System.out.println("Send notification of available slots " + "to " + parkingUser);
        viewAvailableSlots(slots);
    }

   
}
