import java.net.*;
import java.io.*;

public class Program {
    public static void main(String[] args) throws Exception {
        String line;
        FileWriter myWriter = new FileWriter("example.html");
        try{
            URL u = new URL("http://example.com");
            DataInputStream htmlPage = new DataInputStream(u.openStream());
            while ((line = htmlPage.readLine()) != null) {
                myWriter.write(line);
                myWriter.write("/n");
                System.out.println(line);

            }
            
        } catch (Exception e){
            System.err.println();
        }
        myWriter.close();
    }    

}