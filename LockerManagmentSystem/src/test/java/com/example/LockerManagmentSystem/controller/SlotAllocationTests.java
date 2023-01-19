package com.example.LockerManagmentSystem.controller;

import com.example.LockerManagmentSystem.exception.NOSlotAvailableException;
import com.example.LockerManagmentSystem.model.Buyer;
import com.example.LockerManagmentSystem.model.LockerItem;
import com.example.LockerManagmentSystem.model.Size;
import com.example.LockerManagmentSystem.model.Slot;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.example.LockerManagmentSystem.utils.RndomUtils.createTestLockerWithSlots;
import static com.example.LockerManagmentSystem.utils.RndomUtils.randomLockerItem;

@RunWith(MockitoJUnitRunner.class)
public class SlotAllocationTests extends BaseTest {

    @Test
    public void testSlotAllocationToUser() {

        // Arrange
        createTestLockerWithSlots(lockerController, 2, new Size(10, 10));
        createTestLockerWithSlots(lockerController, 2, new Size(5, 5));
        final Buyer buyer1 = randomBuyer();
        final LockerItem item1 = randomLockerItem(new Size(7, 5));
        final LockerItem item2 = randomLockerItem(new Size(7, 5));

        // Act
        final List<Slot> allSlots = lockerController.getAllavailableSlots();

        final Slot slot1 = orderController.allocateLocker(buyer1, item1);
        List<Slot> availableSlotsPost1 = lockerController.getAllavailableSlots();

        final Slot slot2 = orderController.allocateLocker(buyer1, item2);
        List<Slot> availableSlotsPost2 = lockerController.getAllavailableSlots();

        // Assert

        // Slot1 should be available only initially.
        Assertions.assertTrue(allSlots.contains(slot1));
        Assertions.assertFalse(availableSlotsPost1.contains(slot1));
        Assertions.assertFalse(availableSlotsPost2.contains(slot1));

        // Slot2 should be available till item 2 is not allotted.
        Assertions.assertTrue(allSlots.contains(slot2));
        Assertions.assertTrue(availableSlotsPost1.contains(slot2));
        Assertions.assertFalse(availableSlotsPost2.contains(slot2));

        // After deallocating slot1, it should get available. Slot2 should still be occupied.
        lockerController.deAllocateSlot(slot1);
        Assertions.assertTrue(lockerController.getAllavailableSlots().contains(slot1));
        Assertions.assertFalse(lockerController.getAllavailableSlots().contains(slot2));

        // After deallocating slot2 also now, both should be available now;
        lockerController.deAllocateSlot(slot2);
        Assertions.assertTrue(lockerController.getAllavailableSlots().contains(slot1));
        Assertions.assertTrue(lockerController.getAllavailableSlots().contains(slot2));
    }

    @Test(expected = NOSlotAvailableException.class)
    public void testSlotAllocationWithoutAddingSlotsThrowsException() {
        orderController.allocateLocker(randomBuyer(), randomLockerItem(new Size(10, 10)));
    }

    @Test(expected = NOSlotAvailableException.class)
    public void testSlotAllocationWithoutMatchingSlotsThrowsException() {
        createTestLockerWithSlots(lockerController, 2, new Size(5, 5));
        orderController.allocateLocker(randomBuyer(), randomLockerItem(new Size(10, 10)));
    }
}