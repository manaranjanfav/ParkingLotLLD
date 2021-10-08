package com.lld.parkinglot.Utils;

import java.util.Random;

import com.lld.parkinglot.Controllers.ParkingLotController;
import com.lld.parkinglot.Models.Car;
import com.lld.parkinglot.Models.GateKepper;
import com.lld.parkinglot.Models.ParkingLot;

import static com.lld.parkinglot.Utils.RandomUtils.randomString;

public class ParkingLotUtils {
    
    public static ParkingLot createParkingLotwithSlots(ParkingLotController parkingLotController, int numofSlots)
    {
        Random rd = new Random();
        GateKepper gateKepper = new GateKepper(rd.nextInt(100)+1);
        ParkingLot parkingLot = parkingLotController.creatParkingLot(rd.nextInt(100)+1, numofSlots, gateKepper);

        for(int i=0;i<numofSlots;i++)
        {
            parkingLotController.createSlot(parkingLot, rd.nextInt(100)+1);
        }
        return parkingLot;
    }

    public static Car randomCar()
    {
       return new Car(randomString());
    }
}
