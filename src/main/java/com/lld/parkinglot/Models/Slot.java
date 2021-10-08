package com.lld.parkinglot.Models;

import com.lld.parkinglot.Exceptions.SlotAlreadyOccupiedExceptions;

public class Slot {
    
    final int id;
    Car car;


    public Slot(int id) {
        this.id = id;
        car = null;
    }
     

    public int getId() {
        return this.id;
    }

    public Car getCar() {
        return this.car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    public void allocateCar(Car car)
    {
       if(this.car!=null)
       {
           throw new SlotAlreadyOccupiedExceptions();
       }
       this.car = car;
    }

    public void deallocatecar()
    {
        this.car = null;
    }

    public boolean isAvailable()
    {
        return (this.car==null);
    }
    
}
