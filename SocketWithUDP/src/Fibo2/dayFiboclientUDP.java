
package Fibo2;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class dayFiboclientUDP {
    public static void main(String args[]) throws Exception { 
      
        DatagramSocket clientSocket = new DatagramSocket(8159);       
        InetAddress IPAddress = InetAddress.getByName("localhost");   
      
            byte[] sendData = new byte[1024]; 
            byte[] receiveData = new byte[2048]; 
      
        int a,b,p,k;  
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số a=");
        a = scanner.nextInt();
        System.out.print("Nhập vào số b=");
        b = scanner.nextInt();   
        System.out.print("Nhập vào số k=");
        k = scanner.nextInt();
        System.out.print("Nhập vào số p=");
        p = scanner.nextInt(); 
    
        String s=String.valueOf(a)+" "+String.valueOf(b)+" "+String.valueOf(k)+" "+String.valueOf(p)+" ";
            
            sendData = s.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9998); 
            clientSocket.send(sendPacket); 

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
            clientSocket.receive(receivePacket); 
            String modified_Sentence = new String(receivePacket.getData());
            System.out.println("FROM SERVER:" + modified_Sentence); 
       
            clientSocket.close(); 
    } 
}