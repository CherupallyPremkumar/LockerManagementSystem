package com.example.LockerManagmentSystem.repository;

import com.example.LockerManagmentSystem.model.Slot;

public interface SlotOtpValidation {
   boolean validateotp(Slot slot, String otp);

    void addOtp(String otp, Slot slot);
}
