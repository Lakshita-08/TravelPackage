package test;

import main.Activity;
import main.Destination;
import main.TravelPackage;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TravelPackageTest {

    @Test
    public void testAddDestination() {
        TravelPackage travelPackage = new TravelPackage("1", "Test Package", 5);
        Destination destination = new Destination("Test Destination");
        travelPackage.addDestination(destination);
        assertEquals(1, travelPackage.getDestinations().size());
        assertEquals("Test Destination", travelPackage.getDestinations().get(0).getName());
    }

    @Test
    public void testPrintItinerary() {
        TravelPackage travelPackage = new TravelPackage("1", "Test Package", 5);
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Description", 10.0, 5);
        destination.addActivity(activity);
        travelPackage.addDestination(destination);

        // Redirect System.out to check printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackage.printItinerary();

        String expectedOutput = "Travel Package Name: Test Package\n" +
                "Passenger Capacity: 5\n" +
                "Destinations and Activities:\n" +
                "- Destination: Test Destination\n" +
                "  - Activity: Test Activity\n" +
                "    - Description: Description\n" +
                "    - Cost: $10.0\n" +
                "    - Capacity: 5\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}

