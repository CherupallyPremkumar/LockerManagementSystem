package com.example.LockerManagmentSystem.utils;

import com.example.LockerManagmentSystem.controller.LockerController;
import com.example.LockerManagmentSystem.model.Locker;
import com.example.LockerManagmentSystem.model.LockerItem;
import com.example.LockerManagmentSystem.model.Size;
import com.example.LockerManagmentSystem.model.Slot;

public class LockerUtils {

    public static Locker createTestLockerWithSlots(LockerController lockerController, Integer numSlots, Size slotSize) {
        final Locker locker = lockerController.createLocker(randomString());
        for (int i = 0; i < numSlots; i++) {
            final Slot slot1 = lockerController.createSlot(locker, slotSize);
        }
        return locker;
    }

    public static LockerItem randomLockerItem(Size itemSize) {
        return new Package(randomString(), itemSize);
    }
}
