package com.lld.parkinglot.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.lld.parkinglot.Exceptions.ParkingLotAlreadyExistExceptions;
import com.lld.parkinglot.Models.GateKepper;
import com.lld.parkinglot.Models.ParkingLot;
import com.lld.parkinglot.Models.Slot;

public class ParkingLotRepositoryInMemory implements IParkingLotRespository {
    
    List<ParkingLot> allParkingLots;


    public ParkingLotRepositoryInMemory() {
        allParkingLots = new ArrayList<>();
    }

    public ParkingLot getParkingLot(int Id)
    {
        for(ParkingLot parkingLot:allParkingLots)
        {
            if(parkingLot.getId()==Id)
             return parkingLot;
        } 

        return null;
    }

    public ParkingLot createParkingLot(int Id, int size, GateKepper gateKepper)
    {
        if(getParkingLot(Id)!=null)
        {
           throw new ParkingLotAlreadyExistExceptions();
        }

        ParkingLot parkingLot = new ParkingLot(Id, size, gateKepper);
        allParkingLots.add(parkingLot);
        return parkingLot;
    }

    public List<Slot> getAllAvailabaleSlots()
    {
        List<Slot> result = new ArrayList<>();
        for(ParkingLot parkingLot:allParkingLots)
        {
            result.addAll(parkingLot.getallavailableslots());
        }
        return result;
    }
        
}
