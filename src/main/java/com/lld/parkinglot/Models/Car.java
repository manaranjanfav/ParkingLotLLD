package com.lld.parkinglot.Models;

import org.springframework.lang.NonNull;

public class Car {
    final String registrationId;


    public Car(@NonNull final String registrationId) {
        this.registrationId = registrationId;
    }
    

    public String getRegistrationId() {
        return this.registrationId;
    }

}
