package com.lld.parkinglot.Alogorithms;

import java.util.List;

import com.lld.parkinglot.Models.Slot;

public interface ISlotAssignmentAlgorithm {
    public Slot pickSlot(List<Slot> slots);
}
