package com.example.LockerManagmentSystem.controller;

import com.example.LockerManagmentSystem.model.Locker;
import com.example.LockerManagmentSystem.model.Size;
import com.example.LockerManagmentSystem.model.Slot;
import com.example.LockerManagmentSystem.service.LockerService;
import com.example.LockerManagmentSystem.service.OtpService;
import lombok.NonNull;

import java.util.List;

public class LockerController {
    private final LockerService lockerService;
    private final OtpService otpService;


    public LockerController(@NonNull LockerService lockerService, @NonNull OtpService otpService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
    }

    public Locker createLocker(final String lockerId) {
        return lockerService.createLocker(lockerId);
    }

    public Slot createSlot(final Locker locker, Size newSize) {
        return lockerService.createSlot(locker, newSize);
    }

    public List<Slot> getAllavailableSlots() {
        return lockerService.getAllavailableSlots();
    }

    public boolean unLockSlot(@NonNull Slot slot, @NonNull String otp) {
        return otpService.validate(slot, otp);
    }

    public void deAllocateSlot(@NonNull Slot slot) {
        lockerService.deAllocateSlot(slot);
    }
}
