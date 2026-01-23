interface IRoomAmenities {
    void provideWifi();
    void provideBreakfast();
}

abstract class AbstractRoom {
    int roomNumber;
    double basePrice;

    public AbstractRoom(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    public abstract void calculateTariff();

    public void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Base Price: $" + basePrice);
    }
}
class StdRoom extends AbstractRoom implements IRoomAmenities {
    private double acCharge = 500.0;

    public StdRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public void calculateTariff() {
        double total = basePrice + acCharge;
        System.out.println("Standard Room Total Tariff: $" + total);
    }

    @Override
    public void provideWifi() {
        System.out.println("Wifi: Limited access available.");
    }

    @Override
    public void provideBreakfast() {
        System.out.println("Breakfast: Not included in Standard Room.");
    }
}
class LuxRoom extends AbstractRoom implements IRoomAmenities {
    private double luxuryTax = 1500.0;

    public LuxRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public void calculateTariff() {
        double total = basePrice + luxuryTax;
        System.out.println("Luxury Room Total Tariff: $" + total);
    }

    @Override
    public void provideWifi() {
        System.out.println("Wifi: High-speed unlimited access included.");
    }

    @Override
    public void provideBreakfast() {
        System.out.println("Breakfast: Complimentary buffet included.");
    }
}

public class ques4{
    public static void main(String[] args) {
        System.out.println("=== Unique Hotel Management System ===\n");
        AbstractRoom myStandard = new StdRoom(101, 2000.0);
        AbstractRoom myLuxury = new LuxRoom(505, 5000.0);

        System.out.println("[Checking Standard Room]");
        myStandard.displayRoomDetails();
        myStandard.calculateTariff();
        ((IRoomAmenities) myStandard).provideWifi();
        ((IRoomAmenities) myStandard).provideBreakfast();

        System.out.println("\n---------------------------\n");
        System.out.println("Checking Luxury Room");
        myLuxury.displayRoomDetails();
        myLuxury.calculateTariff();
        ((IRoomAmenities) myLuxury).provideWifi();
        ((IRoomAmenities) myLuxury).provideBreakfast();
    }
}