package com.example.LockerManagmentSystem.utils;

public class RandomUtils {

    public static String randomString() {
        return UUID.randomUUID().toString();
    }

    public static String randomOtp() {
        return randomString();
    }

    public static String randomEmail() {
        return randomString() + "@uditagarwal.com";
    }
}
