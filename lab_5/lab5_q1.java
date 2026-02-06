import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class lab5_q1 {
    public static void main(String[] args){
        String sourcefile = "source.dat";
        String destfile = "destination.dat";

        try(FileInputStream in = new FileInputStream(sourcefile);
            FileOutputStream out = new FileOutputStream(destfile)){
                int bytedata;
                while((bytedata = in.read()) != -1){
                    out.write(bytedata);
                }
                System.out.println("file copied\n");
            }catch(IOException e){
                System.out.println("error occurred");
            }
    }
    
}
/*NOTE:
As soon as the code leaves the try block (either because it finished successfully or because an error occurred), Java automatically calls in.close() and out.close() for you behind the scenes.*/
