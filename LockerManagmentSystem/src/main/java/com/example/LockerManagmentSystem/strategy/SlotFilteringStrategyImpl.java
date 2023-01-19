package com.example.LockerManagmentSystem.strategy;

import com.example.LockerManagmentSystem.model.LockerItem;
import com.example.LockerManagmentSystem.model.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class SlotFilteringStrategyImpl implements SlotFilteringStrategy {
    @Override
    public List<Slot> filterSlots(List<Slot> availableSlots, LockerItem lockerItem) {
        return availableSlots.stream()
                .filter(a -> a.getSize().canAccomidate(lockerItem.getSize()))
                .collect(Collectors.toList());

    }
}
