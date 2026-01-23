class HotelRoom {
    int roomNumber;
    double baseTariff;

    public HotelRoom(int roomNumber, double baseTariff) {
        this.roomNumber = roomNumber;
        this.baseTariff = baseTariff;
    }

    public void calculateTariff() {
        System.out.println("Total Tariff for Room " + roomNumber + ": " + baseTariff);
    }
}
class StdHotelRoom extends HotelRoom {
    double acCharge = 500.0;

    public StdHotelRoom(int roomNumber, double baseTariff) {
        super(roomNumber, baseTariff);
    }

    @Override
    public void calculateTariff() {
        double total = baseTariff + acCharge;
        System.out.println("Standard Room " + roomNumber + " (Base + AC): " + total);
    }
}
class LuxHotelRoom extends HotelRoom {
    double serviceTax = 1000.0;
    double amenitiesCharge = 1500.0;

    public LuxHotelRoom(int roomNumber, double baseTariff) {
        super(roomNumber, baseTariff);
    }

    @Override
    public void calculateTariff() {
        double total = baseTariff + serviceTax + amenitiesCharge;
        System.out.println("Luxury Room " + roomNumber + " (Base + Tax + Amenities): " + total);
    }
}

public class ques3 {
    public static void main(String[] args) {
        double basePrice = 2000.0; 

        System.out.println("--- Booking Summary ---");
        HotelRoom room1 = new StdHotelRoom(101, basePrice);
        room1.calculateTariff();
        HotelRoom room2 = new LuxHotelRoom(505, basePrice);
        room2.calculateTariff();
    }
}
