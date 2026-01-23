import java.util.Scanner;
class Orderprocessor implements Runnable{
    private String customername;
    private String productname;
    public Orderprocessor(String customername, String productname){
        this.customername = customername;
        this.productname = productname;
    }
    @Override
    public void run(){
        try{
            System.out.println("NEW ORDER : processing for "+ customername +"'s "+productname);
            System.out.println("validation order for "+customername);
            Thread.sleep(1500);
            System.out.println("processing payment for "+productname);
            Thread.sleep(2000);
            System.out.println("shipped "+productname);
        }
        catch(InterruptedException e){
            System.out.println(productname+"was cancelled due to error");
        }
    }
}
public class onlineordersystem_ques2_lab3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number of orders:");
        int count_orders = sc.nextInt();
        sc.nextLine();
        Thread[] orderThreads = new Thread[count_orders];
        for(int i=0;i<count_orders;i++){
            System.out.println("order "+(i+1));
            System.out.println("customer name:");
            String name = sc.nextLine();
            System.out.println("product name:");
            String product = sc.nextLine();
            Orderprocessor task = new Orderprocessor(name,product);
            orderThreads[i] = new Thread(task);
        }
        System.out.println("\nstarting order processing\n");
        for(Thread t: orderThreads){
            t.start();
        }
        sc.close();
    }
    
}