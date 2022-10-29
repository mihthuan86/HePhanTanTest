package Final_Examl;;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
public class client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            String message = "";
            do{
                Socket socket = new Socket("localhost", 1200);
                OutputStream out = socket.getOutputStream();
                DataOutputStream dout = new DataOutputStream(out);
                
                System.out.println("Moi nhap thong tin: ");
                message = sc.nextLine();
                System.out.println("[SEND]: " + message);
                
                dout.writeUTF(message);
                dout.flush();               
        DataInputStream din = new DataInputStream(socket.getInputStream());               
        String result = din.readUTF();
                if(!result.equalsIgnoreCase("stop")){
                    System.out.println("[RECV]: " + result);
                }
            }while(!message.equalsIgnoreCase("stop"));
        }catch(IOException ex){
            System.out.println("" + ex.getMessage());
        }
    }
    
}
