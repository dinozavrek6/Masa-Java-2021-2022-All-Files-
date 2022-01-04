public class App {
    public static void main(String[] args) throws Exception {
        int port1 = Integer.parseInt(args[0]);
        int port2 = Integer.parseInt(args[1]);

        System.out.println("Starting Chat App...");
    
        ChatServer chatServer = new ChatServer(port1);
        ChatClient chatClient = new ChatClient(port2);

        chatClient.start();
        chatServer.start();
    }
}