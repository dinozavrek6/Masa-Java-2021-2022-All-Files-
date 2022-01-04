import java.net.*;
import java.io.*;

public class ChatClient extends Thread {
    private int port2;
    private String ip;

    public ChatClient(String ip, int port2) {
        this.port2 = port2;
    }

    public void run() {
        try {
            boolean isConnected = false;
            String str = "";            
            Socket socket = null;
            
            // SocketAddress socketAddress = new InetSocketAddress("localhost", port2);
            // System.out.println("CLIENT PORT: " + port2);
    
            while (!isConnected) {
                try {
                    socket = new Socket(ip, port2);
                    isConnected = true;

                } catch (Exception e) {
                    isConnected = false;
                    System.out.println("Waiting for server!");
                    continue;
                }
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Connected to server!");
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

            while (!str.equals("stop")) {
                str = br.readLine();
                dout.writeUTF(str);
                dout.flush();
            }

            dout.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
