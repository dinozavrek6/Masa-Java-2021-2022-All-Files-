import java.net.*;
import java.io.*;

public class ChatServer extends Thread {
    private int port1;

    public ChatServer(int port1) {
        this.port1 = port1;
    }

    public void run() {
        try {
            ServerSocket serverSocket;
            serverSocket = new ServerSocket(port1);
            System.out.println("SERVER PORT: " + port1);
            Socket socket = serverSocket.accept();
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("stop")) {
                str = din.readUTF();
                System.out.println("client says: " + str);
                str2 = br.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }

            din.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
