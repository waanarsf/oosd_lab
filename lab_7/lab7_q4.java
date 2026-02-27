import java.util.Scanner;

public class lab7_q4{
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rooms to manage: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        Integer[] roomNumbers = new Integer[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Room Number " + (i + 1) + ": ");
            roomNumbers[i] = sc.nextInt();
        }
        sc.nextLine();
        String[] roomTypes = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Room Type " + (i + 1) + ": ");
            roomTypes[i] = sc.nextLine();
        }
        Double[] roomPrices = new Double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Room Price " + (i + 1) + ": ");
            roomPrices[i] = sc.nextDouble();
        }
        System.out.println("\n--- Summary Report ---");
        System.out.print("Room Numbers: ");
        printArray(roomNumbers);
        System.out.print("Room Types:   ");
        printArray(roomTypes);
        System.out.print("Room Prices:  ");
        printArray(roomPrices);
        sc.close();
    }
}