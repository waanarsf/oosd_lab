
class Room {
    int roomNumber;
    String roomType;
    double basePrice;

    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.basePrice = 500.0;
    }

    public Room(int roomNumber, String roomType, double basePrice) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.basePrice = basePrice;
    }

    public void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Base Price: " + basePrice);
    }
    public static void main(String[] args) {
        System.out.println("--- Standard Room Details ---");
        Room standard = new Room(101, "Single", 450.0);
        standard.displayRoomDetails();
        System.out.println("--Deluxe Room Details---");
        DeluxeRoom deluxe = new DeluxeRoom(202, "Suite", 1200.0, true, true);
        deluxe.displayDeluxeDetails();
    }
}

class DeluxeRoom extends Room {
    boolean FreeWiFi;
    boolean Breakfast;

    public DeluxeRoom(int roomNumber, String roomType, double basePrice, boolean FreeWiFi, boolean Breakfast) {
        super(roomNumber, roomType, basePrice); 
        this.FreeWiFi = FreeWiFi;
        this.Breakfast = Breakfast;
    }

    public void displayDeluxeDetails() {
        super.displayRoomDetails(); 
        System.out.println("Free WiFi: " + (FreeWiFi ? "Yes" : "No"));
        System.out.println("Complimentary Breakfast: " + (Breakfast ? "Yes" : "No"));
    }
}