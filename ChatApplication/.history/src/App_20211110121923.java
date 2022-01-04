import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        int port1 = Integer.parseInt(args[0]);
        int port2 = Integer.parseInt(args[1]);
        Boolean clientConnected = false; 

        String trmStrIP;

        System.out.println("Starting Chat App...");
        
        ChatServer chatServer = new ChatServer(port1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        if (chatServer.IsConnected())
        {
            ChatClient chatClient = new ChatClient(trmStrIP, port2);
        }
        else
         {   
            System.out.println("Inter client IP:");
            trmStrIP = br.readLine();
            ChatClient chatClient = new ChatClient(trmStrIP, port2);
        }

        

        chatClient.start();
        chatServer.start();
    }
}