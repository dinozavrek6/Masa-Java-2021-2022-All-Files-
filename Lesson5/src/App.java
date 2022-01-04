public class App {

    public static void main(String[] args) throws Exception {
        
        int port1 = Integer.parseInt(args [0]);
        int port2 = Integer.parseInt(args [1]);
        System.out.println("Starting RT Chat App..");
    
        ChatServer chatSrv = new ChatServer(port1);
        ChatClient chatCl = new ChatClient(port2);
    
        chatSrv.start();
        chatCl.start();
    }
}
