package com.example.LockerManagmentSystem.service;

import com.example.LockerManagmentSystem.model.Slot;
import com.example.LockerManagmentSystem.repository.SlotOtpValidation;
import com.example.LockerManagmentSystem.strategy.OtpGenerator;

public class OtpService {



    private final SlotOtpValidation slotOtpValidation;
    private final OtpGenerator otpGenerator;


    public OtpService(SlotOtpValidation slotOtpValidation, OtpGenerator otpGenerator) {
        this.slotOtpValidation = slotOtpValidation;
        this.otpGenerator = otpGenerator;
    }

    public boolean validate(Slot slot, String otp) {
       return slotOtpValidation.validateotp(slot,otp);
    }

    public String generateOtp(Slot slot) {
        final String otp=otpGenerator.generateOtp();
        slotOtpValidation.addOtp(otp,slot);
        return otp;
    }
}
