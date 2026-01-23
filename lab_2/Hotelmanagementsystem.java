import java.util.Scanner;
enum RoomType {
    STANDARD(2000),
    DELUXE(3500),/* dont use semicolon while writing constants */
    SUITE(5000);

    private final int baseTariff;
    RoomType(int baseTariff) {/*NOte the constructor name must always match with enum name */
        this.baseTariff = baseTariff;
        System.out.println("Initializing " + this.name() + " with tariff: " + baseTariff);
    }

    public int getBaseTariff() {
        return baseTariff;
    }

    public int calculateTotalCost(int days) {
        return this.baseTariff * days;
    }
}

public class Hotelmanagementsystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nHotel Room types");
        System.out.println("Available rooms:\n");
        
        for (RoomType type : RoomType.values()) {
            System.out.println("- " + type + " (Rs. " + type.getBaseTariff() + "/night)");
        }

        System.out.print("\n--ENTER ROOM TYPE--: ");
        String userInput = sc.next().toUpperCase();
         
        try {
            // Added the missing dot for the static method valueOf
            RoomType selectedRoom = RoomType.valueOf(userInput);
            
            System.out.print("Enter number of days to stay: ");
            int days = sc.nextInt();
            
            int totalcost = selectedRoom.calculateTotalCost(days);
            
            System.out.println("\nBooking summary");
            System.out.println("Room selected: " + selectedRoom);
            System.out.println("Room tariff Rs: " + selectedRoom.getBaseTariff());
            System.out.println("Stay duration (days): " + days);
            System.out.println("Total cost: " + totalcost);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid room type entered!");
        } finally {
            sc.close();
        }
    }
}