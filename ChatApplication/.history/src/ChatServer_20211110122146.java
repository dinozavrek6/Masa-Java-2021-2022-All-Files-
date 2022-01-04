import java.net.*;
import java.io.*;


public class ChatServer extends Thread {
    private int port1;
    Boolean isConnected = false;
    

    public ChatServer(int port1) {
        this.port1 = port1;
    }

    public String IsConnected()
    {
        return this.isConnected;
    }

    public void run() {
        try {
            ServerSocket serverSocket;
            serverSocket = new ServerSocket(port1);
            System.out.println("SERVER PORT: " + port1);
            Socket socket = serverSocket.accept();

            DataInputStream din = new DataInputStream(socket.getInputStream());
            this.isConnected = true;
            String str = "";
            while (!str.equals("stop")) {
                str = din.readUTF();
                System.out.println("client says: " + str);
            }

            din.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
