package com.example.LockerManagmentSystem.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Locker {
    private final String id;
    private final List<Slot> slots;

    public Locker(String id) {
        this.id = id;
        this.slots = new ArrayList<>();
    }

    public void addSlots(final Slot newSlot)
    {
        this.slots.add(newSlot);
    }
    @NonNull
    public List<Slot> getAvailableSlots()
    {
        final List<Slot> result=new ArrayList<>();
        for (Slot slot:  slots)
        {
            if(slot.isAvailable())
            {
                result.add(slot);
            }
        }
        return result;
    }


}
