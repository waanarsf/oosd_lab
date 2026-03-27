import javafx.beans.property.*;

public class lab9_room { // 1. Class name must match filename
    private final StringProperty roomNumber;
    private final StringProperty roomType;
    private final DoubleProperty price;
    private final BooleanProperty isAvailable;

    // 2. FIX: Constructor name must match the class name "lab9_room"
    public lab9_room(String roomNumber, String roomType, double price) {
        this.roomNumber = new SimpleStringProperty(roomNumber);
        this.roomType = new SimpleStringProperty(roomType);
        this.price = new SimpleDoubleProperty(price);
        this.isAvailable = new SimpleBooleanProperty(true);
    }

    // Property getters for TableView data binding
    public StringProperty roomNumberProperty() { return roomNumber; }
    public StringProperty roomTypeProperty() { return roomType; }
    public DoubleProperty priceProperty() { return price; }
    public BooleanProperty isAvailableProperty() { return isAvailable; }

    // Standard getters and setters
    public String getRoomNumber() { return roomNumber.get(); }
    public boolean isAvailable() { return isAvailable.get(); }
    public void setAvailable(boolean available) { this.isAvailable.set(available); }
}