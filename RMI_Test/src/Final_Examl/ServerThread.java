package Final_Examl;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.Math.sqrt;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
public class ServerThread extends Thread{
    private Socket socket;  
    public ServerThread(Socket sk){
        this.socket = sk;
    }
    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            DataInputStream din = new DataInputStream(in);
            
            String message = din.readUTF();
            System.out.println("[SERVER] [RECV]: " + message );
            OutputStream out = socket.getOutputStream();
            DataOutputStream dout = new DataOutputStream(out);
            System.out.println("Sending string to the Client");
            if(!message.equalsIgnoreCase("stop")){
                int[] Arr = Arrays.stream(message.split(" ")).mapToInt(Integer::parseInt).toArray();
                int a = Arr[0];
                int b = Arr[1];
                int c = Arr[2];
                String data = giaiPTTrungPhuong(a, b, c);
                System.out.println(data);
                dout.writeUTF(data);
                dout.flush();
            }else{
                dout.writeUTF("stop");
                dout.flush();
            }
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Final_Examl.ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    String giaiPTTrungPhuong(float a, float b, float c) {
        float X1 = 0, X2 = 0;
        String result = "";
        float delta = b * b - 4 * a * c;
        if (delta < 0) {
            X1 = X2 = (float) 0.0;
            
        } else if (delta == 0) {
            X1 = X2 = -b / (2 * a);
            
        } else {
            delta = (float) sqrt(delta);
            X1 = (-b + delta) / (2 * a);
            X2 = (-b - delta) / (2 * a);
            
        }
        if (delta < 0) {
            result = "Phuong trinh vo nghiem";
        } else if (delta == 0) {
            if (X1 < 0) {
                result = "Phuong trinh vo nghiem";
            } else if (X1 == 0) {
                result = "Phuong trinh co mot nghiem x: " + 0;
            } else {
                result = "Phuong trinh co hai nghiem x1: " + sqrt(X1) + " x2: " + -sqrt(X1);
            }
        } else {
            if (X1 < 0) {
                if (X2 < 0) {
                    result = "Phuong trinh vo nghiem";
                } else if (X2 == 0) {
                    result = "Phuong trinh co mot nghiem x: " + 0;
                } else {
                    result = "Phuong trinh co hai nghiem x1: " + sqrt(X2) + " x2: " + -sqrt(X2);
                }

            } else if (X1 == 0) {
                if (X2 <= 0) {
                    result = "Phuong trinh co mot nghiem x: " + 0;
                } else {
                    result = "Phuong trinh co ba nghiem x1: " + sqrt(X2) + " x2: " + -sqrt(X2) + " x3: " + 0;
                }
            } else {
                if (X2 < 0) {
                    result = "Phuong trinh co hai nghiem x1: " + sqrt(X1) + " x2: " + -sqrt(X1);
                } else if (X2 == 0) {
                    result = "Phuong trinh co ba nghiem x1: " + sqrt(X1) + " x2: " + -sqrt(X1) + " x3: " + 0;
                } else {
                    result = "Phuong trinh co bon nghiem x1: " + sqrt(X1) + " x2: " + -sqrt(X1) + " x3: " + sqrt(X2) + " x4: " + -sqrt(X2);

                }
            }

        }
        return result;
    }
}
