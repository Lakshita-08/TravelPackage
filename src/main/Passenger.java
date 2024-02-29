package main;

import java.util.ArrayList;
import java.util.List;

/**
 * The Passenger class represents a passenger in the travel management system.
 * It stores information about the passenger such as name, passenger number, balance,
 * passenger type, and a list of activities the passenger has signed up for.
 */
public class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private PassengerType type;
    private List<Activity> signedActivities;

    // Constructor
    public Passenger(String name, int passengerNumber, PassengerType type, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;
        this.balance = balance;
        signedActivities = new ArrayList<>();
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    /**
     * Signs up the passenger for a given activity.
     *
     * @param activity The activity to sign up for.
     * @return An integer representing the signup result:
     *         0 - Successfully signed up.
     *         1 - Activity capacity is full.
     *         2 - Not enough funds.
     */
    public int signUpForActivity(Activity activity) {
        if (activity.getCapacity() <= 0) {
            return 1; // Activity capacity is full
        } else if (type != PassengerType.PREMIUM && balance < activity.getCost()) {
            return 2; // Not enough funds
        } else {
            if (type == PassengerType.GOLD) {
                balance -= 0.9 * activity.getCost(); // Apply 10% discount
            } else if (type == PassengerType.STANDARD) {
                balance -= activity.getCost();
            }
            signedActivities.add(activity);
            activity.reduceCapacity(); // Decrease activity capacity
            return 0; // Successfully signed up
        }
    }

    /**
     * Prints details of the passenger including name, passenger number, balance,
     * and activities signed up for (if any).
     */
    public void printDetails() {
        System.out.println("Passenger Details:");
        System.out.println("- Name: " + name);
        System.out.println("- Passenger Number: " + passengerNumber);
        System.out.println("- Balance: $" + balance);

        if (signedActivities.isEmpty()) {
            System.out.println("- No activities signed up.");
        } else {
            System.out.println("- Activities Signed Up:");
            for (Activity activity : signedActivities) {
                System.out.println("  - Activity: " + activity.getName());
                System.out.println("    - Destination: " + activity.getDestination().getName());
                System.out.println("    - Price: $" + activity.getCost());
            }
        }
    }


            // Getters
    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Activity> getSignedActivities() {
        return signedActivities;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public PassengerType getType() {
        return type;
    }
}
