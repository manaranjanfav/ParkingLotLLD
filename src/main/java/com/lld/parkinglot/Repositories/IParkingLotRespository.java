package com.lld.parkinglot.Repositories;

import java.util.List;

import com.lld.parkinglot.Models.GateKepper;
import com.lld.parkinglot.Models.ParkingLot;
import com.lld.parkinglot.Models.Slot;

public interface IParkingLotRespository {
    
    public ParkingLot createParkingLot(int Id, int size, GateKepper gateKepper);
    public List<Slot> getAllAvailabaleSlots();
}
