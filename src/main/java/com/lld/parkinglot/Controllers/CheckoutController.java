package com.lld.parkinglot.Controllers;

import com.lld.parkinglot.Models.ParkingUser;
import com.lld.parkinglot.Models.Slot;
import com.lld.parkinglot.Services.NotificationService;
import com.lld.parkinglot.Services.ParkingLotServices;

public class CheckoutController {
    
    final ParkingLotServices parkingLotServices;
    final NotificationService notificationService;


    public CheckoutController(ParkingLotServices parkingLotServices, NotificationService notificationService) {
        this.parkingLotServices = parkingLotServices;
        this.notificationService = notificationService;
    }

   
    
    public void deallocateCar(ParkingUser parkingUser, Slot slot)
    {
           parkingLotServices.deallocateSlot(slot);
           notificationService.notifyParkingUserForCheckOut(parkingUser, slot);
           
    }
    
}
