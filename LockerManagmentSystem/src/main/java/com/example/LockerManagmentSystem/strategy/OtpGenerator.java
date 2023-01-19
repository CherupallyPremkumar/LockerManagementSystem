package com.example.LockerManagmentSystem.strategy;

import lombok.NonNull;

public interface OtpGenerator {
    @NonNull
    String generateOtp();
}
