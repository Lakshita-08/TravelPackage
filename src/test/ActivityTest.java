package test;

import main.Activity;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityTest {

    @Test
    public void testReduceCapacity() {
        Activity activity = new Activity("Test Activity", "Description", 10.0, 5);
        activity.reduceCapacity();
        assertEquals(4, activity.getCapacity());
    }
}
