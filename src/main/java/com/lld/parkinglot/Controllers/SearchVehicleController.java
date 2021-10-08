package com.lld.parkinglot.Controllers;

import com.lld.parkinglot.Models.ParkingTicket;
import com.lld.parkinglot.Models.ParkingUser;
import com.lld.parkinglot.Services.NotificationService;
import com.lld.parkinglot.Services.ParkingTicketService;

public class SearchVehicleController {

    final ParkingTicketService parkingTicketService;
    final NotificationService notificationService;

    public SearchVehicleController(ParkingTicketService parkingTicketService, NotificationService notificationService) {
        this.parkingTicketService = parkingTicketService;
        this.notificationService = notificationService;
    }
     
    public void searchVehicle(ParkingUser parkingUser, ParkingTicket parkingTicket)
    {
        int slotId = parkingTicketService.searchvehicle(parkingTicket);
        notificationService.notifySearchedVehicle(parkingUser, slotId);
    }
    
}
