package main;

import java.util.ArrayList;
import java.util.List;

/**
 * The Activity class represents an activity that can be included in a travel package.
 * It contains information about the activity such as name, description, cost, capacity,
 * enrolled passengers, and the destination where the activity takes place.
 */
public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private List<Passenger> enrolledPassengers;
    private Destination destination;

    // Constructor
    public Activity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.enrolledPassengers = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }
    public Destination getDestination() { return destination; }

    // Setter method for the destination attribute
    public void setDestination(Destination destination) { this.destination = destination; }

    public void reduceCapacity() {
        capacity--; // Decrease capacity by 1
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Description: " + description + ", Cost: " + cost + ", Capacity: " + capacity;
    }
}
