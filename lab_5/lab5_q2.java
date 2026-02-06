import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class lab5_q2 {
    public static void main(String[] args) {
        String sourcefile = "input.txt";
        String destfile = "output.txt";
        
        try (FileReader reader = new FileReader(sourcefile);
             FileWriter writer = new FileWriter(destfile)) {
             
            int character;
            while ((character = reader.read()) != -1) { 
                writer.write(character);
            }
                        System.out.println("text file copied\n");

        } catch (IOException e) {
            System.out.println("error: ");
        }
    }
}