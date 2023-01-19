package com.example.LockerManagmentSystem.strategy;

import com.example.LockerManagmentSystem.model.LockerItem;
import com.example.LockerManagmentSystem.model.Slot;

import java.util.List;

public interface SlotFilteringStrategy{
    List<Slot> filterSlots(List<Slot> availableSlots, LockerItem lockerItem);

}
