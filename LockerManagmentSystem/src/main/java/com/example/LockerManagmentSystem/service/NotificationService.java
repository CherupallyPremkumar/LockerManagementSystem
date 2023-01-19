package com.example.LockerManagmentSystem.service;

import com.example.LockerManagmentSystem.model.Buyer;
import com.example.LockerManagmentSystem.model.Size;
import com.example.LockerManagmentSystem.model.Slot;
import lombok.NonNull;

public class NotificationService {
     public  void notifyToUSer(@NonNull Buyer buyer, @NonNull String otp,@NonNull Slot slot) {
        System.out.println("sending notification of otp:" +otp+"to:"+buyer+"for solt:"+slot);
    }
}
