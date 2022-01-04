import java.net.*;
import java.io.*;

public class ChatClient extends Thread {
    private int port2;

    public ChatClient(int port2) {
        this.port2 = port2;
    }

    public void run() {
        try {
            boolean isConnected = false;
            String str = "";

            // Socket socket = new Socket();
            // SocketAddress socketAddress = new InetSocketAddress("localhost", port2);
            // System.out.println("CLIENT PORT: " + port2);
    
            while (!isConnected) {
                try {
                    System.out.println("CLIENT PORT: " + port2);
                    Socket socket = new Socket("localhost", port2);
                    isConnected = true;
                    System.out.println("Connected to server!");
                    DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                    dout.writeUTF(str);
                    dout.flush();
                } catch (Exception e) {
                    isConnected = false;
                    System.out.println("Waiting for server!");
                    continue;
                }
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (!str.equals("stop")) {
                str = br.readLine();
            }

            dout.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
