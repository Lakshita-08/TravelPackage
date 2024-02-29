package main;

import java.util.*;

/**
 * This class represents a travel management system that allows users to create travel packages, add destinations,
 * activities, and sign up passengers for activities within those packages.
 * The main method prompts users to enter passenger details, select a package, and sign up for activities.
 * It also allows viewing passenger details based on their assigned passenger number.
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Activity snorkeling = new Activity("Snorkeling", "Explore underwater life", 3.0, 3);
        Activity surfing = new Activity("Surfing", "Surfing in ocean", 2.0, 2);
        Activity sightseeing = new Activity("Sightseeing", "Visit historical landmarks", 2.0, 3);
        Activity desertSafari = new Activity("Desert Safari", "Desert Safari in Jeep", 2.5, 2);

        // Create destinations and add activities
        Destination beachDestination = new Destination("Beach Destination");
        beachDestination.addActivity(snorkeling);
        beachDestination.addActivity(surfing);
        snorkeling.setDestination(beachDestination);
        surfing.setDestination(beachDestination);

        Destination cityDestination = new Destination("City Destination");
        cityDestination.addActivity(sightseeing);
        cityDestination.addActivity(desertSafari);
        sightseeing.setDestination(cityDestination);
        desertSafari.setDestination(cityDestination);

        // Create travel packages and add destinations
        TravelPackage package1 = new TravelPackage("G","GOA", 3);
        package1.addDestination(beachDestination);

        TravelPackage package2 = new TravelPackage("RJ","RAJASTHAN", 3);
        package2.addDestination(cityDestination);

        package1.printItinerary();
        System.out.println();
        package2.printItinerary();

        System.out.println("------------------------------------------");
        System.out.println("You can now enter passenger details");


        List<Passenger> passengers = new ArrayList<>();
        Set<Integer> passengerIds = new HashSet<>();

        // Loop to add passengers
        boolean addAnotherPassenger = true;
        while (addAnotherPassenger) {
            // Collect passenger details from user
            System.out.print("Enter your ID number: ");
            int id = sc.nextInt();

            if (passengerIds.contains(id)) {
                System.out.println("Passenger with ID " + id + " already exists. Please enter a different ID.");
                continue; // Skip the rest of the loop iteration
            }

            passengerIds.add(id);

            System.out.print("Enter your name: ");
            sc.nextLine(); // Consume newline character
            String name = sc.nextLine();

            System.out.println("Select your passenger type:");
            System.out.println("1. STANDARD");
            System.out.println("2. GOLD");
            System.out.println("3. PREMIUM");

            System.out.print("Enter corresponding number: ");
            int passengerTypeChoice = sc.nextInt();
            PassengerType type = null;

            switch (passengerTypeChoice) {
                case 1:
                    type = PassengerType.STANDARD;
                    break;
                case 2:
                    type = PassengerType.GOLD;
                    break;
                case 3:
                    type = PassengerType.PREMIUM;
                    break;
                default:
                    System.out.println("Invalid choice. Setting type to STANDARD by default.");
                    type = PassengerType.STANDARD;
            }

            System.out.print("Enter amount of money: ");
            double money = sc.nextDouble();

            // Create passenger object
            Passenger passenger = new Passenger(name, id, type, money);
            //passenger.setPassengerNumber(passengers.size() + 1); // Set passenger number
            passengers.add(passenger);

            // Add passenger to the list
            passengers.add(passenger);

            // Print available packages
            System.out.println("Select a package you want to book:");
            System.out.println("1. " + package1.getName());
            System.out.println("2. " + package2.getName());
            // Add more packages as needed...

            System.out.print("Enter corresponding number: ");
            int packageChoice = sc.nextInt();

            TravelPackage selectedPackage = null;

            // Assign the selected package based on user input
            switch (packageChoice) {
                case 1:
                    selectedPackage = package1;
                    break;
                case 2:
                    selectedPackage = package2;
                    break;
                // Add cases for more packages...
                default:
                    System.out.println("Invalid choice.");
                    return; // Exit the program
            }

            // Signup process for each passenger
            for (Passenger currentPassenger : passengers) {
                for (Destination destination : selectedPackage.getDestinations()) {
                    // List all the activities of the current destination
                    System.out.println("Activities available at " + destination.getName() + ":");
                    for (Activity activity : destination.getActivities()) {
                        System.out.println("- " + activity.getName());
                        System.out.println("  - Remaining Capacity: " + activity.getCapacity()); // Display remaining capacity
                    }

                    // Prompt the user to sign up for each activity at the current destination
                    System.out.println("Do you want to sign up for any of these activities? (Y/N)");
                    String response = sc.next();
                    if (response.equalsIgnoreCase("Y")) {
                        for (Activity activity : destination.getActivities()) {
                            System.out.print("Do you want to sign up for " + activity.getName() + "? (Y/N): ");
                            response = sc.next();
                            if (response.equalsIgnoreCase("Y")) {
                                // Sign up the passenger for the activity
                                int signUpResult = currentPassenger.signUpForActivity(activity);
                                switch (signUpResult) {
                                    case 0:
                                        System.out.println("Signed up for " + activity.getName() + " successfully!");
                                        System.out.println("Remaining balance for " + currentPassenger.getName() + ": $" + currentPassenger.getBalance());
                                        break;
                                    case 1:
                                        System.out.println("Failed to sign up for " + activity.getName() + ". Activity capacity is full.");
                                        break;
                                    case 2:
                                        System.out.println("Failed to sign up for " + activity.getName() + ". Not enough funds.");
                                        break;
                                }
                            }
                        }
                    }
                }
            }

            // Ask if user wants to add another passenger
            System.out.println("Do you want to add another passenger? (Y/N)");
            String response = sc.next();
            addAnotherPassenger = response.equalsIgnoreCase("Y");
        }
        System.out.println();
        package1.printPassengerList();
        System.out.println();
        package2.printPassengerList();
        System.out.println();

        System.out.println("All passengers added.");

        // Prompt the user to enter passenger number for details
        System.out.print("Enter passenger number to view details: ");
        int passengerNumber = sc.nextInt();

        // Retrieve the passenger object based on the entered passenger number
        Passenger selectedPassenger = null;
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerNumber() == passengerNumber) {
                selectedPassenger = passenger;
                break;
            }
        }

        // If the passenger is found, print their details
        if (selectedPassenger != null) {
            selectedPassenger.printDetails();
        } else {
            System.out.println("Passenger not found.");
        }

    }
}
