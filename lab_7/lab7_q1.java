 import  java.util.Scanner;

class room<T,U>{
    private T ridentifier;
    private U rattribute;
    public room(T identifier, U attribute){
        this.ridentifier = identifier;
        this.rattribute = attribute;
    }
    public void display(){
        System.out.println("room id:"+ridentifier+"\nroom type/price:"+rattribute);
    }
}


public class lab7_q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter room id(alphanumeric):\n");
        String rid = sc.nextLine();
        System.out.println("enter room price:/n");
        double rprice = sc.nextDouble();
        sc.nextLine();
        room<String,Double> r1 = new room<>(rid,rprice);
        r1.display();
        System.out.println("enter room no:\n");
        int rnum = sc.nextInt();
        sc.nextLine();
        System.out.println("enter room type:/n");
        String rtype = sc.nextLine();
        room<Integer,String> r2 = new room<>(rnum,rtype);
        r2.display();
        sc.close();
    }
} 
