package com.example.LockerManagmentSystem.repository;


import com.example.LockerManagmentSystem.model.Slot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlotOtpValidtionImplementation implements SlotOtpValidation{
   final Map<String ,String> slotIdotpMap;

    public SlotOtpValidtionImplementation() {
        slotIdotpMap =new HashMap<>();
    }

    @Override
    public boolean validateotp(Slot slot, String otp) {
        for (String str : slotIdotpMap.keySet())
        {
            if(slot.getSlotId().equals(str) && slotIdotpMap.get(str).equals(otp)) return true;
        }
        return false;
    }

    @Override
    public void addOtp(String otp, Slot slot) {
        slotIdotpMap.put(slot.getSlotId(),otp);
    }
}
