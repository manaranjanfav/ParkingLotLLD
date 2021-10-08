package com.lld.parkinglot.Utils;

import java.util.UUID;

public class RandomUtils {
    
    public static String randomString()
    {
        return UUID.randomUUID().toString();
    }
}
