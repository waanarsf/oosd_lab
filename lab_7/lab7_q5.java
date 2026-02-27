import java.util.Scanner;
class Pair<T, U> {
    private T first; 
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    public void displayBooking() {
        System.out.println("Booking Confirmed -> Room: " + first + ", Guest: " + second);
    }
}

public class lab7_q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of bookings to record: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        @SuppressWarnings("unchecked")
        Pair<Integer, String>[] bookings = new Pair[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Booking " + (i + 1) + " ---");
            System.out.print("Enter Room Number: ");
            int roomNum = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Enter Guest Name: ");
            String guestName = sc.nextLine();
            bookings[i] = new Pair<>(roomNum, guestName);
        }
        System.out.println("\n--- Current Booking Records ---");
        for (Pair<Integer, String> record : bookings) {
            record.displayBooking();
        }

        sc.close();
    }
}