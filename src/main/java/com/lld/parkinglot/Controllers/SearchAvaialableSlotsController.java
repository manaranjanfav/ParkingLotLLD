package com.lld.parkinglot.Controllers;

import java.util.List;

import com.lld.parkinglot.Models.ParkingUser;
import com.lld.parkinglot.Models.Slot;
import com.lld.parkinglot.Services.NotificationService;
import com.lld.parkinglot.Services.ParkingLotServices;

public class SearchAvaialableSlotsController {
    final ParkingLotServices parkingLotServices;
    final NotificationService notificationService;


    public SearchAvaialableSlotsController(ParkingLotServices parkingLotServices, NotificationService notificationService) {
        this.parkingLotServices = parkingLotServices;
        this.notificationService = notificationService;
    }
    

    public void searchAvailableSlots(ParkingUser parkingUser)
    {
        List<Slot> slots = parkingLotServices.getallavailableslots();
        notificationService.notifyParkingUserForAvailableSlots(parkingUser, slots);
    }

}
