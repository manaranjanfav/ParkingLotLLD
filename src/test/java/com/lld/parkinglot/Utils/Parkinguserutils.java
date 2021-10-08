package com.lld.parkinglot.Utils;

import java.util.Random;

import com.lld.parkinglot.Models.ParkingUser;

public class Parkinguserutils {
    
    public static ParkingUser randomParkingUser()
    {
        Random rd = new Random();
        return new ParkingUser(rd.nextInt(100)+1);
    }
}
