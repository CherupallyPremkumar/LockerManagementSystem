package com.example.LockerManagmentSystem.controller;


import com.example.LockerManagmentSystem.repository.LockerRepo;
import com.example.LockerManagmentSystem.repository.LockerRepoImplemntation;
import com.example.LockerManagmentSystem.repository.SlotOtpValidation;
import com.example.LockerManagmentSystem.repository.SlotOtpValidtionImplementation;
import com.example.LockerManagmentSystem.service.LockerService;
import com.example.LockerManagmentSystem.service.NotificationService;
import com.example.LockerManagmentSystem.service.OtpService;
import com.example.LockerManagmentSystem.strategy.*;
import org.junit.Before;
import org.mockito.Mock;

public class BaseTest {

        protected LockerController lockerController;
        protected OrderController orderController;
        protected OtpService otpService;
        protected LockerService lockerService;

        @Mock
        protected NotificationService notificationService;

        @Before
        public void setup() {

            final IrandomGeneratorImp randomGeneratorDefault = new IrandomGeneratorImp();
            final AssignmentStrategy lockerAssignmentStrategy = new AssignmentStrategyImp(randomGeneratorDefault);
            final LockerRepo lockerRepository = new LockerRepoImplemntation();
            final SlotFilteringStrategy slotFilteringStrategy = new SlotFilteringStrategyImpl();
            final SlotOtpValidation slotOtpRepository = new SlotOtpValidtionImplementation();
            final GenerateOtpImp otpGeneratorRandom = new GenerateOtpImp(5, randomGeneratorDefault);

            this.lockerService = new LockerService(lockerRepository, slotFilteringStrategy , lockerAssignmentStrategy);
            this.otpService = new OtpService(slotOtpRepository,otpGeneratorRandom );

            this.lockerController = new LockerController(lockerService, otpService);
            this.orderController = new OrderController(otpService,notificationService, lockerService);
        }
    }
}
