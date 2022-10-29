
package Bai4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class bai4Server {
     public static void main(String args[]) {
 
       ServerSocket listener = null;
       BufferedReader is;
       BufferedWriter os;
       Socket socketOfServer = null;
       
       try {
           listener = new ServerSocket(7890);
       } catch (IOException e) {
           System.out.println(e);
           System.exit(1);
       }
 
       try {
           System.out.println("Server is waiting to accept user...");
           socketOfServer = listener.accept();
           System.out.println("Accept a client!"); 
      
           is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
           os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream())); 
           
           int a,b,k,p; 
           String line;
           line = is.readLine();
           os.write(">> cac tham so la " + line);             
           os.newLine();        
           os.flush();             
                       
           a=line.charAt(0)-48;      
           b=line.charAt(2)-48; 
           k=line.charAt(4)-48; 
           System.out.println("a="+a+" b="+b+" k="+k); 
           
            int array[] = new int[k];
            
            String s=String.valueOf(a)+" "+String.valueOf(b)+" ";
            array[0]=a;array[1]=b;
            for (int i = 2; i < k; i++) {
                array[i] = array[i-1]+array[i-2];
                s=s+String.valueOf(array[i])+" ";
            }
            os.write(">> day Fibonaci gom " + s);
            os.newLine();
            os.flush();  
            
            
            String line1;           
               line1 = is.readLine();
               p=line1.charAt(0);  
               os.write(">> gia tri cua p la " + String.valueOf(p) );
               os.newLine();
               os.flush();  
               boolean check = false;
                for (int i = 0; i < k; i++) {
                   if (array[i]==p)
                   {
                    check = true;
                    line1=String.valueOf(i+1);
                    os.write(">> vi tri cua "+p+" trong day la " + line1);
                    os.newLine();
                    os.flush();  
                   }       
                }
                if (!check){                    
                    os.write(">> Khong co p trong day"
                            + " ");
                    os.newLine();
                    os.flush(); 
                }
         
           os.close();
           is.close();
           socketOfServer.close();      
 
       } catch (IOException e) {
           System.out.println(e);      
       }
      System.out.println("Sever stopped!");
   }

}
