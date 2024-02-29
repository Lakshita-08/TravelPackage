package main;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private List<Activity> activities;

    // Constructor
    public Destination(String name) {
        this.name = name;
        activities = new ArrayList<>();
    }

    // Method to add activity
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
