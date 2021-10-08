package com.lld.parkinglot.Controller;

import com.lld.parkinglot.Alogorithms.ISlotAssignmentAlgorithm;
import com.lld.parkinglot.Alogorithms.ParkingTicketGeneratorRandom;
import com.lld.parkinglot.Alogorithms.SlotAssigmentAlgorithmRandom;
import com.lld.parkinglot.Controllers.CheckInController;
import com.lld.parkinglot.Controllers.CheckoutController;
import com.lld.parkinglot.Controllers.ParkingLotController;

import com.lld.parkinglot.Repositories.IParkingLotRespository;
import com.lld.parkinglot.Repositories.ParkingLotRepositoryInMemory;
import com.lld.parkinglot.Repositories.ParkingTicketRepositoryInMemory;
import com.lld.parkinglot.Services.NotificationService;
import com.lld.parkinglot.Services.ParkingLotServices;
import com.lld.parkinglot.Services.ParkingTicketService;


import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.mock.mockito.MockBean;

public class BaseTest {
    
    ParkingLotController parkingLotController;
    CheckInController checkInController;
    ParkingTicketService parkingTicketService;
    ParkingLotServices parkingLotServices;
    CheckoutController checkoutController;

    @MockBean
    NotificationService notificationService;

    @BeforeAll
    public void setup()
    {

      ISlotAssignmentAlgorithm slotAssignmentAlgorithm = new SlotAssigmentAlgorithmRandom();
      IParkingLotRespository parkingLotRespository = new ParkingLotRepositoryInMemory();
      ParkingTicketRepositoryInMemory parkingTicketRepositoryInMemory = new ParkingTicketRepositoryInMemory();
      ParkingTicketGeneratorRandom parkingTicketGeneratorRandom = new ParkingTicketGeneratorRandom();

      this.parkingLotServices = new ParkingLotServices(parkingLotRespository, slotAssignmentAlgorithm);
      this.parkingTicketService = new ParkingTicketService(parkingTicketGeneratorRandom, parkingTicketRepositoryInMemory);

      this.checkInController = new CheckInController(parkingTicketService, parkingLotServices, notificationService);
      this.parkingLotController = new ParkingLotController(parkingLotServices, parkingTicketService);
      this.checkoutController = new CheckoutController(parkingLotServices, notificationService);


    }
}
