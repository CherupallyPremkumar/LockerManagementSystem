package com.example.LockerManagmentSystem.strategy;

import com.example.LockerManagmentSystem.model.Slot;

import java.util.List;

public class AssignmentStrategyImp implements AssignmentStrategy{
    private final IrandomGenerator irandomGenerator;

    public AssignmentStrategyImp(IrandomGenerator irandomGenerator) {
        this.irandomGenerator = irandomGenerator;
    }

    @Override
    public Slot pickSlot(List<Slot> filteredSlots) {
        if(filteredSlots.isEmpty()) return null;
        int slotNum=irandomGenerator.getRandomNumber(filteredSlots.size());
        return filteredSlots.get(slotNum);
    }
}
