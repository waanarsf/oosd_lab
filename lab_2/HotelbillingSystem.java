//QUES1
/*The Hotel Billing system should calculate the total bill amount for hotel guests based on room charges and additional service charges. 
Store numeric values such as room tariff, number of days stayed, and service charges using wrapper class objects (Integer, Double) instead of primitive data types
 */
/*Create a main class to:
i.
Initialize room tariff and number of days using primitive data types and store them in wrapper objects.
ii.
Perform total bill calculation using unboxed primitive values.
iii.
Display the final hotel bill. */
import java.util.Scanner;
public class HotelbillingSystem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====Hotel Billing System====");
        System.out.println("Enter Room Tariffs:");
        double ptariifs = sc.nextDouble();
        System.out.print("Enter Number of Days stayed: ");
        int pDays = sc.nextInt(); // primitive 

        System.out.print("Enter Additional Service Charges: ");
        double pService = sc.nextDouble(); // primitive 

        Double roomtariffs = ptariifs;
        Integer days_stayed = pDays;
        Double service_charges = pService;

        double totalBill = (roomtariffs * days_stayed) + service_charges;
        /*unboxing happens here as java automatically calls .doublevalue and . intvalue to use the primitive raw values  */
        System.out.println("Room Tariff (per day) : Rs. " + roomtariffs);
        System.out.println("Duration of Stay      : " + days_stayed + " days");
        System.out.println("Service Charges       : Rs. " + service_charges);
        System.out.println("TOTAL PAYABLE AMOUNT  : Rs. " + totalBill);

        sc.close();
    }
}

