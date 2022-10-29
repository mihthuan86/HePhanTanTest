
package Bai4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class bai4client {
  public static void main(String[] args) {
 
     
       final String serverHost = "localhost";
 
       Socket socketOfClient = null;
       BufferedWriter os = null;
       BufferedReader is = null;
 
       try {          
           socketOfClient = new Socket(serverHost, 7890);
           os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
           is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
 
       } catch (UnknownHostException e) {
           System.err.println("Don't know about host " + serverHost);
           return;
       } catch (IOException e) {
           System.err.println("Couldn't get I/O for the connection to " + serverHost);
           return;
       }
       try {
       int a,b,p,k;  
       Scanner scanner = new Scanner(System.in);
      
        do {
            System.out.println("Nhập vào số k=");
            k = scanner.nextInt();
        } while (k < 2);
        System.out.println("Nhập vào số a=");
        a = scanner.nextInt();
        System.out.println("Nhập vào số b=");
        b = scanner.nextInt();      
    
        String s=String.valueOf(a)+";"+String.valueOf(b)+";"+String.valueOf(k);
        os.write(s);
        os.newLine();
        os.flush();     
        
        System.out.println("Nhập vào số p=");
        p = scanner.nextInt();        
           os.write(p);
           os.newLine();
           os.flush();
           
           String responseLine;
           while ((responseLine = is.readLine()) != null) {
               System.out.println("Server: " + responseLine);            
           }
           
           os.close();
           is.close();
           socketOfClient.close();
      
       } catch (UnknownHostException e) {
           System.err.println("Trying to connect to unknown host: " + e);
       } catch (IOException e) {
           System.err.println("IOException:  " + e);
       }
   }
  
}
