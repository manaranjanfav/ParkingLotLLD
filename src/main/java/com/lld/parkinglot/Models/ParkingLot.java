package com.lld.parkinglot.Models;

import java.util.ArrayList;
import java.util.List;

import com.lld.parkinglot.Exceptions.ParkingLotFullExceptions;

import org.springframework.lang.NonNull;

public class ParkingLot {
    
    final int id;
    List<Slot> slots;
    final int size;
    final GateKepper gateKepper;

    public ParkingLot(@NonNull final int id, @NonNull final int size ,@NonNull GateKepper gateKepper) {
        this.id = id;
        this.size = size;
        slots = new ArrayList<>();
        this.gateKepper = gateKepper;
    }

    public int getId() {
        return this.id;
    }

    public GateKepper getGateKepper() {
        return this.gateKepper;
    }


    public List<Slot> getSlots() {
        return this.slots;
    }

    
    public void addslot(Slot newslot)
    {
        if(slots.size()==this.size)
         {
             throw new ParkingLotFullExceptions();
         }
         this.slots.add(newslot);
    }

    public List<Slot> getallavailableslots()
    {
        List<Slot> result = new ArrayList<>();
        for(Slot slot:slots)
        {
            if(slot.isAvailable())
            {
                result.add(slot);
            }
        }
        return result;
    }
}
