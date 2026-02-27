import java.util.Scanner;
class RoomDetails<T, U> {
    private T id;
    private U info;

    public RoomDetails(T id, U info) {
        this.id = id;
        this.info = info;
    }

    public void display(){

        System.out.println("room id:"+id+"\nroom type/price:"+info);

    }
}

public class lab7_q2 {
    public static <T> void processData(T data) {
        System.out.println("Processing System Update: " + data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter room id(alphanumeric):\n");
        String id = sc.nextLine();
        System.out.println("enter room price:/n");
        double price = sc.nextDouble();
        sc.nextLine();
        RoomDetails<String, Double> room1 = new RoomDetails<>(id,price);
        room1.display();
        System.out.println("enter room no:\n");
        int rnum = sc.nextInt();
        sc.nextLine();
        System.out.println("enter room type:/n");
        String rtype = sc.nextLine();
        RoomDetails<Integer, String> room2 = new RoomDetails<>(rnum, rtype);
        room2.display();
        sc.close();
    }
}