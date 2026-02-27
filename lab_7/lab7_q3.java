import java.util.Scanner;

public class lab7_q3 {
    public static <T extends Number> void calculateRoomCharges(T price, T discount) {
        double p = price.doubleValue();
        double d = discount.doubleValue();
        double total = p;
        double discountedPrice = p - (p * (d / 100));
        System.out.println("--- Calculation Results ---");
        System.out.println("Original Price: " + total);
        System.out.println("Discounted Price: " + discountedPrice);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter room price: ");
        double price = sc.nextDouble();
        System.out.print("Enter discount percentage: ");
        double discount = sc.nextDouble();
        calculateRoomCharges(price, discount);
        sc.close();
    }
}