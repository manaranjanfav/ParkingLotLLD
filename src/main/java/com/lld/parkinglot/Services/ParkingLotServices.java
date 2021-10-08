package com.lld.parkinglot.Services;

import java.util.List;

import com.lld.parkinglot.Alogorithms.ISlotAssignmentAlgorithm;
import com.lld.parkinglot.Exceptions.SlotEmptyExceptions;
import com.lld.parkinglot.Models.Car;
import com.lld.parkinglot.Models.GateKepper;
import com.lld.parkinglot.Models.ParkingLot;
import com.lld.parkinglot.Models.Slot;
import com.lld.parkinglot.Repositories.IParkingLotRespository;

public class ParkingLotServices {
    
    final IParkingLotRespository parkingLotRespository;
    final ISlotAssignmentAlgorithm assignmentAlgorithm;


    public ParkingLotServices(IParkingLotRespository parkingLotRespository, ISlotAssignmentAlgorithm assignmentAlgorithm) {
        this.parkingLotRespository = parkingLotRespository;
        this.assignmentAlgorithm = assignmentAlgorithm;
    }


    public ParkingLot createParkingSlot(int Id, int size, GateKepper gateKepper)
    {
       return parkingLotRespository.createParkingLot(Id, size, gateKepper);
    }

    public Slot createSlot(ParkingLot parkingLot, int id)
    {
      Slot slot = new Slot(id);
      parkingLot.addslot(slot);
      return slot;    
    }

    public List<Slot> getallavailableslots()
    {
       return parkingLotRespository.getAllAvailabaleSlots();
    }

    public Slot allocateSlot(Car car)
    {
        List<Slot> allAvalaibleSlots = parkingLotRespository.getAllAvailabaleSlots();
        Slot slottobeallocated = assignmentAlgorithm.pickSlot(allAvalaibleSlots);
        if(slottobeallocated == null)
        {
            throw new SlotEmptyExceptions();
        }
        slottobeallocated.allocateCar(car);
        return slottobeallocated;
        
    }

    public void deallocateSlot(Slot slot)
    {
        slot.deallocatecar();
    }

    

}
