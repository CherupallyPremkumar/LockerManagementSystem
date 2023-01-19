package com.example.LockerManagmentSystem.strategy;

import com.example.LockerManagmentSystem.model.Slot;

import java.util.List;

public interface AssignmentStrategy {
    Slot pickSlot(List<Slot> filteredSlots);
}
