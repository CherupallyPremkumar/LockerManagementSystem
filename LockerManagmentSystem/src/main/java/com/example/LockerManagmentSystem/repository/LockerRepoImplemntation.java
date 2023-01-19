package com.example.LockerManagmentSystem.repository;

import com.example.LockerManagmentSystem.exception.LockerAlreadyExistsException;
import com.example.LockerManagmentSystem.model.Locker;
import com.example.LockerManagmentSystem.model.Slot;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class LockerRepoImplemntation implements LockerRepo{
    final List<Locker> lockerList;

    public LockerRepoImplemntation() {
        lockerList=new ArrayList<>();
    }

    @Override
    @NonNull
    public Locker addLocker(Locker locker) {
      if(lockerList.contains(locker))
      {
          throw new LockerAlreadyExistsException();
      }
      lockerList.add(locker);
      return locker;
    }

    @Override
    @NonNull
    public List<Slot> getAllavailableSlots() {
        final List<Slot> slots=new ArrayList<>();
        for (Locker l : lockerList) {
            slots.addAll(l.getAvailableSlots());
        }
        return slots;
    }


}
