package com.example.LockerManagmentSystem.strategy;

import java.util.Random;

public class IrandomGeneratorImp implements IrandomGenerator{
    @Override
    public int getRandomNumber(int size) {
        return new Random().nextInt(size);
    }
}
