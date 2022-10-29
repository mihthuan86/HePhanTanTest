package Final_Examl;;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class server {
    
     public static void main(String[] args) throws Exception {
        int port = 1200;
        try(ServerSocket socket = new ServerSocket(port);){
            System.out.print("Server is listening on port " + port);
            
            while(true){
                Socket sk = socket.accept();
                System.out.println("New client connected!");
                
                new ServerThread(sk).start();
            }
        }catch(IOException ex){
            System.out.println("Server Exception: " + ex);
            ex.printStackTrace();
        }
    }
}
