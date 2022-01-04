import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        int port1 = Integer.parseInt(args[0]);
        int port2 = Integer.parseInt(args[1]);
        ChatClient chatClient = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String trmStrIP;

        System.out.println("Starting Chat App...");
        
        ChatServer chatServer = new ChatServer(port1);
        chatServer.start();
        
        System.out.println("Inter client IP:");
        trmStrIP = br.readLine();

        if (trmStrIP.isEmpty())
        {
            
            while (chatServer.GetRemoteIP().isEmpty())
            {
                try {
                    chatClient = new ChatClient(chatServer.GetRemoteIP(), port2);
                } catch (Exception e) {
                    continue;
                }
            }
        }
        else
         {
            chatClient = new ChatClient(trmStrIP, port2);
        }

        
        chatClient.start();

    }
}