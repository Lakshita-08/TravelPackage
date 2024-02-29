package test;

import main.Activity;
import main.Destination;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DestinationTest {

    @Test
    public void testAddActivity() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Description", 10.0, 5);
        destination.addActivity(activity);
        assertEquals(1, destination.getActivities().size());
        assertEquals("Test Activity", destination.getActivities().get(0).getName());
    }
}
