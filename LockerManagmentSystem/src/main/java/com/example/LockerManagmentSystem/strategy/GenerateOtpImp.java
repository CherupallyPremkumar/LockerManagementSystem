package com.example.LockerManagmentSystem.strategy;

import lombok.NonNull;

public class GenerateOtpImp implements OtpGenerator{
    private final int optLength;
    private final IrandomGenerator irandomGenerator;

    public GenerateOtpImp(int optLength, IrandomGenerator irandomGenerator) {
        this.optLength = 6;
        this.irandomGenerator = irandomGenerator;
    }

    @Override
    @NonNull
    public String generateOtp() {
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<optLength;i++)
        {
            stringBuilder.append(irandomGenerator.getRandomNumber(10));
        }
        return stringBuilder.toString();
    }
}
