

import java.util.Scanner;

public class lab7_q2 {
    public static <T> void display(T data) {
        System.out.println("Processing System Update: " + data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter room number: ");
        int roomNum = sc.nextInt();
        display(roomNum);
        System.out.print("Enter room type: ");
        sc.nextLine();
        String roomType = sc.nextLine();
        display(roomType);
        System.out.print("Enter price per night: ");
        double price = sc.nextDouble();
        display(price); 
        System.out.print("Is the room booked? (true/false): ");
        boolean isBooked = sc.nextBoolean();
        display(isBooked); 

        sc.close();
    }
}