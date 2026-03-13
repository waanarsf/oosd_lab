import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Room {
    int roomNumber;
    String type;
    double price;
    boolean isAvailable;

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " [" + type + "] - $" + price + " (Available: " + isAvailable + ")";
    }
}

class Customer {
    int id;
    String name;
    String contact;
    int allocatedRoom;

    public Customer(int id, String name, String contact, int allocatedRoom) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.allocatedRoom = allocatedRoom;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Contact: " + contact + " | Room: " + allocatedRoom;
    }
}

public class lab8_q1 {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static Map<Integer, Customer> roomAssignments = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n--- Hotel Management System ---");
                System.out.println("1. Add Room\n2. Display Available Rooms\n3. Book Room (Add Customer)");
                System.out.println("4. Checkout Customer\n5. Display All Customers\n6. Exit");
                System.out.print("Choose an option: ");

                String input = sc.nextLine(); // Read as string to handle typos like "1."
                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1: addRoom(); break;
                    case 2: displayAvailableRooms(); break;
                    case 3: bookRoom(); break;
                    case 4: checkout(); break;
                    case 5: displayCustomers(); break;
                    case 6: System.exit(0);
                    default: System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a whole number (e.g., 1, 2, 3).");
            }
        }
    }

    private static void addRoom() {
        try {
            System.out.print("Enter Room Number: ");
            int num = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Type (Single/Double/Suite): ");
            String type = sc.nextLine();
            System.out.print("Enter Price: ");
            double price = Double.parseDouble(sc.nextLine());

            rooms.add(new Room(num, type, price));
            rooms.sort(Comparator.comparingInt(r -> r.roomNumber));
            System.out.println("Room added successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input. Room not added.");
        }
    }

    private static void displayAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        boolean found = false;
        for (Room r : rooms) {
            if (r.isAvailable) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) System.out.println("No rooms available.");
    }

    private static void bookRoom() {
        displayAvailableRooms();
        System.out.print("\nEnter Room Number to Book: ");
        try {
            int rNum = Integer.parseInt(sc.nextLine());

            for (Room r : rooms) {
                if (r.roomNumber == rNum && r.isAvailable) {
                    System.out.print("Enter Customer ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();

                    Customer c = new Customer(id, name, contact, rNum);
                    customers.add(c);
                    roomAssignments.put(rNum, c);
                    r.isAvailable = false;

                    System.out.println("Room booked successfully for " + name);
                    return;
                }
            }
            System.out.println("Room not available or doesn't exist.");
        } catch (Exception e) {
            System.out.println("Invalid input. Booking failed.");
        }
    }

    private static void checkout() {
        System.out.print("Enter Room Number for Checkout: ");
        try {
            int rNum = Integer.parseInt(sc.nextLine());

            if (roomAssignments.containsKey(rNum)) {
                Customer c = roomAssignments.remove(rNum);
                customers.remove(c);

                for (Room r : rooms) {
                    if (r.roomNumber == rNum) r.isAvailable = true;
                }
                System.out.println("Checkout complete for " + c.name);
            } else {
                System.out.println("No customer found in this room.");
            }
        } catch (Exception e) {
            System.out.println("Invalid Room Number.");
        }
    }

    private static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers currently in the hotel.");
        } else {
            System.out.println("\nCurrent Guests:");
            Iterator<Customer> it = customers.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }
}