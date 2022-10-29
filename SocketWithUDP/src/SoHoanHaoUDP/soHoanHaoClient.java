/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SoHoanHaoUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class soHoanHaoClient {
    public static void main(String args[]) throws Exception { 
      
        DatagramSocket clientSocket = new DatagramSocket(8159);       
        InetAddress IPAddress = InetAddress.getByName("localhost");   
      
            byte[] sendData = new byte[1024]; 
            byte[] receiveData = new byte[2048];
            
            int n;
            int[] arr = new int[100];
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap vao so phan tu: ");
            n=scanner.nextInt();
            for (int i=0;i<n;i++){
                System.out.println("Nhap phan tu thu "+i+" :");
                arr[i]=scanner.nextInt();
            }
            String s = "";
            for(int i = 0;i<n-1;i++){
                s=s+String.valueOf(arr[i])+" ";
            }
            s= s+arr[n-1];
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
