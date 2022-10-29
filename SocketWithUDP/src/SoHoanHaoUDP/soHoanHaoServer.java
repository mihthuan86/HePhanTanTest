/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SoHoanHaoUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Admin
 */
public class soHoanHaoServer {  
    public static boolean checkHoanHao(int n) {
    if(n<2) return false;
    int tonguocso=0;
    for (int i=1;i<n;i++)
    {
        if (n % i==0)   tonguocso=tonguocso+i;            
    }
        return tonguocso==n;
 }   
    public static void main(String args[]) throws Exception { 
        DatagramSocket serverSocket = new DatagramSocket(9998);  
        System.out.println("Luon san sang nhan tin:" );    
        
            byte[] receiveData = new byte[1024];
            byte[] sendData  = new byte[2048];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
            serverSocket.receive(receivePacket);
          
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort(); 
            
            String str,output="";           
            str = new String(receivePacket.getData());
            str = str.trim();
            String input[]=str.split(" ");
            for(int i=0;i<input.length;i++){
                //System.out.println(input[i]);
                if(checkHoanHao(Integer.parseInt(input[i]))){
                    output=output+input[i]+";";
                }
            }
        String sentence_to_client = "Cac so hoan thien co trong day: "+output; 
        sendData = sentence_to_client.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket); 
    }
}