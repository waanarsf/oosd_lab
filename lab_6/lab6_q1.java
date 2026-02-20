import java.io.*;
import java.util.Scanner;                   
class Room {
    int id;
    String type;
    double price;
    boolean isBooked;

    public Room(int id, String type, double price, boolean isBooked) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.isBooked = isBooked;
    }
}
class BookingSystem {
    private static final String FILE_NAME = "hotel.dat";
    private static final int TYPE_LEN = 20;
    private static final int RECORD_SIZE = 53; // 4 + 40 + 8 + 1

    public void save(Room r) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "rw")) {
            raf.seek((long) (r.id - 1) * RECORD_SIZE);
            raf.writeInt(r.id);
            String padded = String.format("%-" + TYPE_LEN + "s", r.type).substring(0, TYPE_LEN);
            raf.writeChars(padded);
            raf.writeDouble(r.price);
            raf.writeBoolean(r.isBooked);
        }
    }

    public Room getRoom(int id) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "r")) {
            long pos = (long) (id - 1) * RECORD_SIZE;
            if (pos >= raf.length()) return null;

            raf.seek(pos);
            int roomId = raf.readInt();
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < TYPE_LEN; i++) sb.append(raf.readChar());
            
            double price = raf.readDouble();
            boolean status = raf.readBoolean();
            
            return new Room(roomId, sb.toString().trim(), price, status);
        }
    }

    public void flipStatus(int id) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "rw")) {
            long statusPos = ((long) (id - 1) * RECORD_SIZE) + 52; 
            if (statusPos >= raf.length()) return;

            raf.seek(statusPos);
            boolean current = raf.readBoolean();
            raf.seek(statusPos); 
            raf.writeBoolean(!current);
        }
    }
}
public class lab6_q1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BookingSystem system = new BookingSystem();

        while (true) {
            System.out.println("\n--- Hotel Menu ---");
            System.out.println("1. Add Room  2. View Room  3. Check-in/out  4. Exit \nENTER CHOICE:");
            int choice = sc.nextInt();
            if (choice == 4) break;

            System.out.print("Room Number: ");
            int id = sc.nextInt();

            if (choice == 1) {
                System.out.print("Type:(STANDARD/DELUXE/SUITE) "); String type = sc.next();
                System.out.print("Price: "); double price = sc.nextDouble();
                system.save(new Room(id, type, price, false));
                System.out.println("Room Saved.");
            } 
            else if (choice == 2) {
                Room r = system.getRoom(id);
                if (r != null) {
                    System.out.println("Room: " + r.id + " | Type: " + r.type + 
                                       " | Price: " + r.price + " | Status: " + (r.isBooked ? "Booked" : "Empty"));
                } else {
                    System.out.println("Empty Record.");
                }
            } 
            else if (choice == 3) {
                system.flipStatus(id);
                System.out.println("Status Updated.");
            }
        }
        sc.close();
    }



    
}
