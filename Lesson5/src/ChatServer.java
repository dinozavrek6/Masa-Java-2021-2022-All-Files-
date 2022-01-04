import java.net.*;  
import java.io.*;

public class ChatServer extends Thread {
    private int port1;

    public ChatServer(int port1){
        this.port1 = port1;
    }

    public void run(){
        System.out.println("runSrvr");
        try{
            ServerSocket ss=new ServerSocket(port1);  
        Socket s=ss.accept();  
        DataInputStream din=new DataInputStream(s.getInputStream());  
       // DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
       // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
          
        String str="";  
        while(!str.equals("stop")){ 
         
        str=din.readUTF();  
        System.out.println("server says: "+str);  
        //str2=br.readLine();  
        //dout.writeUTF(str2);  
        //dout.flush();
        
        
        }  
        din.close();  
        s.close();  
        ss.close();  
        }
        catch(Exception e){
            System.out.println(e);
        }  
        }
        
    }