import java.util.Scanner; 

class RoomServiceTask implements Runnable {
    private String taskname;
    private int duration;

    public RoomServiceTask(String taskname, int duration) {
        this.taskname = taskname;
        this.duration = duration;
    }

    @Override 
    public void run() {
        try {
            System.out.println("START " + taskname + " is in progress");
            Thread.sleep(duration);
            System.out.println("END " + taskname + " is completed.");
        } catch (InterruptedException e) { 
            System.out.println(" task was interrupted.");
        }
    }
}

public class hotelmanagementsystem_lab3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("No. service requests to create: ");
        int numtasks = sc.nextInt();
        sc.nextLine();

        Thread[] threads = new Thread[numtasks];

        for (int i = 0; i < numtasks; i++) {
            System.out.println("\nRequest :" + (i + 1));
            System.out.print("Enter service name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter time in seconds: ");
            int time = sc.nextInt() * 1000; 
            sc.nextLine();

            RoomServiceTask task = new RoomServiceTask(name, time);
            threads[i] = new Thread(task);
        }

        System.out.println("\n Initiating services concurrently\n");
        for (Thread t : threads) {
            t.start();
        }

        System.out.println("Main thread is free for other tasks.\n");
        sc.close();
    }
}