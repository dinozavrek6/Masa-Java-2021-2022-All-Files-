import java.net.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.Scanner;
 

public class App {
    final static int N_SRVR = 2;
    public static void main(String[] args) throws Exception {
        
        int port1 = Integer.parseInt(args[0]);
        int port2 = Integer.parseInt(args[1]);
       // chatClient chatCl = null;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String trmStrIP = "";
        chatSrvr serverList[] = new chatSrvr[N_SRVR];
        chatClient clientList[] = new chatClient[N_SRVR];
        File file = new File ("clients_ips.txt");
        Scanner scanner = new Scanner(file);

        
        for (int i = 0; i <N_SRVR;i++){
            serverList[i] = new chatSrvr(port1 + i );
            serverList[i].start();
        }
        /*

        System.out.println("Enter client IP");
            trmStrIP = br.readLine();
            
        if (trmStrIP.isEmpty()){
            for (int i = 0; i <N_SRVR;i++){
                while (serverList[i].GetRemoteIP().isEmpty()){
                    TimeUnit.SECONDS.sleep(1);     
                     
                 }
                 clientList[i] = new chatClient(serverList[i].GetRemoteIP(),port1);
                 clientList[i].start();
            }
                
            
        }
        else{
            */
            String[] clList = new String[N_SRVR];
            for (int i = 0; i <N_SRVR;i++){
                clList[i] = scanner.nextLine();
                clientList[i] = new chatClient(clList[i],port2 +i);
                System.out.println("Starting client" + i + "with IP" + trmStrIP);
                clientList[i].start();
            //}
          // chatCl = new chatClient(trmStrIP,port2); 
        }

        System.out.println("Starting MT Chat App...");
        
        scanner.close();
        
        

        
    }
}