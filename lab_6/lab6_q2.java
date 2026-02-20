import java.io.*;
import java.util.*;

class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    
    int number;
    String type;
    double price;
    boolean isBooked;
    String guestName;

    public Room(int number, String type, double price) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.isBooked = false;
        this.guestName = "N/A";
    }
}

public class lab6_q2 {
    static String fileName = "hotel_data.txt";
    static ArrayList<Room> roomList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadFromFile();

        while (true) {
            System.out.println("\n--- HOTEL MENU ---");
            System.out.println("1. Add Room\n2. Show All Rooms\n3. Search Room\n4. Book/Vacate Room\n5. Exit");
            System.out.print("Enter choice: ");
            
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
                continue;
            }

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Room Number: "); int num = sc.nextInt();
                System.out.print("Room Type: "); String type = sc.next();
                System.out.print("Price: "); double price = sc.nextDouble();
                roomList.add(new Room(num, type, price));
                saveToFile();
                System.out.println("Room added!");

            } else if (choice == 2) {
                if (roomList.isEmpty()) System.out.println("No rooms in system.");
                for (Room r : roomList) {
                    System.out.println("Room " + r.number + " [" + r.type + "] - $" + r.price + 
                                       " | Status: " + (r.isBooked ? "Booked by " + r.guestName : "Available"));
                }

            } else if (choice == 3) {
                System.out.print("Enter Room Number: ");
                int searchNum = sc.nextInt();
                boolean found = false;
                for (Room r : roomList) {
                    if (r.number == searchNum) {
                        System.out.println("Found: Room " + r.number + " is " + r.type);
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Room not found.");

            } else if (choice == 4) {
                System.out.print("Enter Room Number: ");
                int updateNum = sc.nextInt();
                boolean found = false;
                for (Room r : roomList) {
                    if (r.number == updateNum) {
                        found = true;
                        if (!r.isBooked) {
                            System.out.print("Enter Guest Name: ");
                            r.guestName = sc.next();
                            r.isBooked = true;
                            System.out.println("Booking Successful!");
                        } else {
                            r.isBooked = false;
                            r.guestName = "N/A";
                            System.out.println("Room is now Vacant!");
                        }
                        saveToFile();
                        break;
                    }
                }
                if (!found) System.out.println("Room not found.");

            } else if (choice == 5) {
                System.out.println("Data saved. Goodbye!");
                break;
            }
        }
        sc.close();
    }

    static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(roomList);
        } catch (IOException e) {
            System.out.println("Save Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    static void loadFromFile() {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            // Checking if the object is an ArrayList before casting
            if (obj instanceof ArrayList<?>) {
                roomList = (ArrayList<Room>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Load Error: " + e.getMessage());
        }
    }
}