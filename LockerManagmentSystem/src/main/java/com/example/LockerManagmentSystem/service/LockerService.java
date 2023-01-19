package com.example.LockerManagmentSystem.service;

import com.example.LockerManagmentSystem.exception.NOSlotAvailableException;
import com.example.LockerManagmentSystem.model.Locker;
import com.example.LockerManagmentSystem.model.LockerItem;
import com.example.LockerManagmentSystem.model.Size;
import com.example.LockerManagmentSystem.model.Slot;
import com.example.LockerManagmentSystem.repository.LockerRepo;
import com.example.LockerManagmentSystem.strategy.AssignmentStrategy;
import com.example.LockerManagmentSystem.strategy.SlotFilteringStrategy;

import java.util.List;
import java.util.UUID;

public class LockerService {

    private LockerRepo lockerRepo;
    private SlotFilteringStrategy slotFilteringStrategy;
    private AssignmentStrategy assignmentStrategy;

    public LockerService(LockerRepo lockerRepo, SlotFilteringStrategy slotFilteringStrategy, AssignmentStrategy assignmentStrategy) {
        this.lockerRepo = lockerRepo;
        this.slotFilteringStrategy = slotFilteringStrategy;
        this.assignmentStrategy = assignmentStrategy;
    }

    public Locker createLocker(String lockerId) {
        Locker locker = new Locker(lockerId);
        lockerRepo.addLocker(locker);
        return locker;
    }

    public Slot createSlot(Locker locker, Size newSize) {
        final Slot slot = new Slot(UUID.randomUUID().toString(), newSize, locker);
        locker.addSlots(slot);
        return slot;
    }

    public List<Slot> getAllavailableSlots() {
        return this.lockerRepo.getAllavailableSlots();
    }

    public void deAllocateSlot(Slot slot) {
        slot.deallocateSlot();
    }

    public Slot allcoateSlot(LockerItem lockerItem) {
        List<Slot> allavailableSlots = lockerRepo.getAllavailableSlots();
        List<Slot> filterSlots = slotFilteringStrategy.filterSlots(allavailableSlots, lockerItem);
        Slot slotTobeAllocated = assignmentStrategy.pickSlot(filterSlots);
        if (slotTobeAllocated == null)
            throw new NOSlotAvailableException();

        slotTobeAllocated.allocatePackage(lockerItem);
        return slotTobeAllocated;
    }
}
