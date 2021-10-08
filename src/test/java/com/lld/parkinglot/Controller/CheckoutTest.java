package com.lld.parkinglot.Controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import com.lld.parkinglot.Models.Car;
import com.lld.parkinglot.Models.ParkingUser;
import com.lld.parkinglot.Models.Slot;
import com.lld.parkinglot.Utils.ParkingLotUtils;
import com.lld.parkinglot.Utils.RandomUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@TestInstance(Lifecycle.PER_CLASS)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckoutTest extends BaseTest{
    
    @Test
     public void testCheckoutWorksProperly()
     {
       // Arrange
       ParkingLotUtils.createParkingLotwithSlots(parkingLotController, 10);
       ParkingUser parkingUser = new ParkingUser(2);
       Car car = new Car(RandomUtils.randomString());
 
       //Act 
       Slot slot = checkInController.allocateCar(parkingUser, car);
       checkoutController.deallocateCar(parkingUser, slot);
 
       //Assert
 
       ArgumentCaptor<Slot> otpCaptor = ArgumentCaptor.forClass(Slot.class);
       verify(notificationService).notifyParkingUserForCheckOut(eq(parkingUser), otpCaptor.capture());
 
       Slot resultslot = otpCaptor.getValue();
       assertNotNull(resultslot);
 
       boolean issuccess = parkingLotController.checkSlotdeallocatedsuccesfully(resultslot);
 
       assertTrue(issuccess);

     }
    
}
