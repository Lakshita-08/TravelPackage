package test;

import main.Activity;
import main.Passenger;
import main.PassengerType;
import org.junit.Test;
import static org.junit.Assert.*;

public class PassengerTest {

    @Test
    public void testSignUpForActivity() {
        Passenger passenger = new Passenger("Test Passenger", 1, PassengerType.STANDARD, 50.0);
        Activity activity = new Activity("Test Activity", "Description", 10.0, 5);
        int result = passenger.signUpForActivity(activity);
        assertEquals(0, result); // Successfully signed up
        assertEquals(1, passenger.getSignedActivities().size());
        assertEquals(40.0, passenger.getBalance(), 0.001);
    }

    @Test
    public void testSignUpForActivityWithInsufficientFunds() {
        Passenger passenger = new Passenger("Test Passenger", 1, PassengerType.STANDARD, 5.0);
        Activity activity = new Activity("Test Activity", "Description", 10.0, 5);
        int result = passenger.signUpForActivity(activity);
        assertEquals(2, result); // Insufficient funds
        assertEquals(0, passenger.getSignedActivities().size());
    }
}
