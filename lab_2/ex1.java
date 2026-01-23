// Main class
class Testing {

    enum Fruits {
        Apple(120),
        Kiwi(60),
        Banana(20),
        Orange(80);

        private int price;

        // Constructor
        Fruits(int pr) { 
            this.price = pr; 
        }

        int totalPrice() { 
            return price; 
        }
    }

    public static void main(String[] args) {
        
        System.out.println("Total price of fruits:");


        for (Fruits f : Fruits.values()) {

            System.out.println(f + " costs " + f.totalPrice() + " rupees per kg.");
        }
    }
}
System.out.println("------------------------------------------------")


            System.out.println("\n--- Booking Summary ---");
            System.out.println("Room Selected : " + selectedRoom);
            System.out.println("Base Tariff   : Rs. " + selectedRoom.getBaseTariff());
            System.out.println("Stay Duration : " + days + " days");
            System.out.println("------------------------");
            System.out.println("Total Cost    : Rs. " + totalCost);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid Room Type entered.");
        }

        sc.close();
    }
}