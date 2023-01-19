package com.example.LockerManagmentSystem.repository;

import com.example.LockerManagmentSystem.model.Locker;
import com.example.LockerManagmentSystem.model.Slot;

import java.util.List;

public interface LockerRepo {

    Locker addLocker(Locker locker);

    List<Slot> getAllavailableSlots();
}
