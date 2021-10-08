package com.lld.parkinglot.Controllers;

import com.lld.parkinglot.Models.Car;
import com.lld.parkinglot.Models.ParkingTicket;
import com.lld.parkinglot.Models.ParkingUser;
import com.lld.parkinglot.Models.Slot;
import com.lld.parkinglot.Services.NotificationService;
import com.lld.parkinglot.Services.ParkingLotServices;
import com.lld.parkinglot.Services.ParkingTicketService;

public class CheckInController {

    final ParkingTicketService parkingTicketService;
    final ParkingLotServices parkingLotServices;
    final NotificationService notificationService;


    public CheckInController(ParkingTicketService parkingTicketService, ParkingLotServices parkingLotServices, NotificationService notificationService) {
        this.parkingTicketService = parkingTicketService;
        this.parkingLotServices = parkingLotServices;
        this.notificationService = notificationService;
    }
   
    
    public Slot allocateCar(ParkingUser parkingUser, Car car)
    {
           Slot slot = parkingLotServices.allocateSlot(car);
           ParkingTicket parkingTicket = parkingTicketService.generateParkingTicket(slot);
           notificationService.notifyParkingUserForCheckIn(parkingUser, parkingTicket);
           return slot;
    }
    
    

}
