package com.lld.parkinglot.Alogorithms;

import java.util.List;
import java.util.Random;

import com.lld.parkinglot.Models.Slot;

public class SlotAssigmentAlgorithmRandom implements ISlotAssignmentAlgorithm{

    @Override
    public Slot pickSlot(List<Slot> slots) {
        int size = slots.size();
        Random rd = new Random();
        int index = rd.nextInt(size);
        return slots.get(index);
    }
    
}
