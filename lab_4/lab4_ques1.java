package lab_4;
import java.util.Scanner;

class Hotel {
    private int availableRooms;

    public Hotel(int initialRooms) {
        this.availableRooms = initialRooms;
    }

    public synchronized void bookRoom(String customerName) {
        while (availableRooms == 0) {
            System.out.println("Hotel: No rooms for " + customerName + ". " + customerName + " is now waiting...");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        availableRooms--;
        System.out.println(">> " + customerName + " BOOKED a room. Rooms left: " + availableRooms);
    }

    public synchronized void releaseRoom(String customerName) {
        availableRooms++;
        System.out.println("<< " + customerName + " RELEASED a room. Rooms available: " + availableRooms);
        notifyAll();
    }
}

public class lab4_ques1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter initial number of rooms in hotel: ");
        int startRooms = input.nextInt();
        Hotel grandHotel = new Hotel(startRooms);

        while (true) {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("1. Book a Room");
            System.out.println("2. Release a Room");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 3) break;

            System.out.print("Enter Customer Name: ");
            String name = input.nextLine();

            if (choice == 1) {
                new Thread(() -> grandHotel.bookRoom(name)).start();
            } else if (choice == 2) {
                new Thread(() -> grandHotel.releaseRoom(name)).start();
            }
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }

        System.out.println("System closed.");
        input.close();
    }
}