package com.example.LockerManagmentSystem.utils;

import com.example.LockerManagmentSystem.model.Buyer;
import com.example.LockerManagmentSystem.model.Contact;

public class BuyerUtils {

    public static Buyer randomBuyer() {
        return new Buyer(new Contact(randomString(), randomEmail()));
    }
}