package com.example.LockerManagmentSystem.controller;

import com.example.LockerManagmentSystem.model.Buyer;
import com.example.LockerManagmentSystem.model.LockerItem;
import com.example.LockerManagmentSystem.model.Slot;
import com.example.LockerManagmentSystem.service.LockerService;
import com.example.LockerManagmentSystem.service.NotificationService;
import com.example.LockerManagmentSystem.service.OtpService;
import lombok.NonNull;

public class OrderController {
    private final OtpService otpService;
    private final NotificationService notificationService;
    private final LockerService lockerService;

    public OrderController(OtpService otpService, NotificationService notificationService, LockerService lockerService) {
        this.otpService = otpService;
        this.notificationService = notificationService;
        this.lockerService = lockerService;
    }
    public Slot allocateLocker(@NonNull final Buyer buyer,@NonNull final LockerItem lockerItem)
    {
       final Slot slot= lockerService.allcoateSlot(lockerItem);
       String otp=otpService.generateOtp(slot);
       notificationService.notifyToUSer(buyer,otp,slot);
       return slot;
    }
}
