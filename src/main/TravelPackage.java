package main;

import java.util.ArrayList;
import java.util.List;

/**
 * The TravelPackage class represents a travel package offered by the travel management system.
 * It contains information about the package such as ID, name, passenger capacity, destinations,
 * and enrolled passengers.
 */
public class TravelPackage {
    private String id;
    private String name;
    private int passengerCapacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;

    // Constructor
    public TravelPackage(String id, String name, int passengerCapacity) {
        this.id = id;
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        destinations = new ArrayList<>();
        passengers = new ArrayList<>();
    }

    // Method to add destination
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Prints the itinerary of the travel package, including destinations and activities.
     */
    public void printItinerary() {
        System.out.println("Travel Package Name: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Destinations and Activities:");
        for (Destination destination : destinations) {
            System.out.println("- Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("  - Activity: " + activity.getName());
                System.out.println("    - Description: " + activity.getDescription());
                System.out.println("    - Cost: $" + activity.getCost());
                System.out.println("    - Capacity: " + activity.getCapacity());
            }
        }
    }

    /**
     * Prints the list of passengers enrolled in the travel package.
     */
    public void printPassengerList() {
        System.out.println("Travel Package Name: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        System.out.println("Passenger List:");
        for (Passenger passenger : passengers) {
            System.out.println("- Name: " + passenger.getName());
            System.out.println("  - Passenger Number: " + passenger.getPassengerNumber());
        }
    }
}
