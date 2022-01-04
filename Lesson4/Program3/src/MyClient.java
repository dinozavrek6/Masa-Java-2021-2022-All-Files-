import java.net.*;
import java.io.*;

class MyClient {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 3333);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("stop")) {
            if (br.ready()) {
                str2 = br.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }

            if (din.available() > 0) {
                str = din.readUTF();
                System.out.println("server says: " + str);
            }

        }
        din.close();
        s.close();
        
    }
}