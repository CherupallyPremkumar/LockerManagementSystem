package com.example.LockerManagmentSystem.controller;

import com.example.LockerManagmentSystem.model.Buyer;
import com.example.LockerManagmentSystem.model.LockerItem;
import com.example.LockerManagmentSystem.model.Size;
import com.example.LockerManagmentSystem.model.Slot;
import com.example.LockerManagmentSystem.utils.LockerUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
    public class OtpVerificationTests extends BaseTest {

        @Test
        public void testOtpWorksCorrectly() {

            // Arrange
            LockerUtils.createTestLockerWithSlots(lockerController, 2, new Size(10, 10));
            final Buyer buyer = randomBuyer();
            final LockerItem item = LockerUtils.randomLockerItem(new Size(5, 5));

            // Act
            final Slot slot = orderController.allocateLocker(buyer, item);

            // Assert
            ArgumentCaptor<String> otpCaptor = ArgumentCaptor.forClass(String.class);
            verify(notificationService).notifyUser(eq(buyer), otpCaptor.capture(), eq(slot));
            final String otp = otpCaptor.getValue();
            assertNotNull(otp);
            boolean isSuccess = lockerController.unLockSlot(slot, otp);

            assertTrue(isSuccess);
        }

        @Test
        public void testInvalidOtpDoesNotUnlocksSlot() {

            // Arrange
            LockerUtils.createTestLockerWithSlots(lockerController, 2, new Size(10, 10));
            final Buyer buyer = randomBuyer();
            final LockerItem item = LockerUtils.randomLockerItem(new Size(5, 5));

            // Act
            final Slot slot = orderController.allocateLocker(buyer, item);

            // Assert
            boolean isSuccess = lockerController.unLockSlot(slot, randomOtp());

            assertFalse(isSuccess);
        }
    }

