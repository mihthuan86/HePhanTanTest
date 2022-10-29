/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tong1denN;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 *
 * @author Admin
 */
public class T1denNServer {
    public static void main(String args[]) throws Exception { 
        //Tạo socket phía server với số hiệu cổng 9876
        DatagramSocket serverSocket = new DatagramSocket(9876); 
        double n ;
        while(true) { 
            //tạo biến receiveData để nhận dữ liệu từ gói tin đến 
            byte[] receiveData = new byte[1024];
            //tạo sendData để nhận dữ liệu gửi lên gói tin đi
            byte[] sendData  = new byte[2048];
//            
            //tạo biến receivePacket để nhận gói tin từ socket
            DatagramPacket receivePacket = 
                    new DatagramPacket(receiveData, receiveData.length); 
            //nhận gói tin qua phương thức receive()
            serverSocket.receive(receivePacket);
            //Chuyển dữ liệu vừa nhận về dạng String
            String sentence = new String(receivePacket.getData()); 
            System.out.println("Da nhan: "+sentence);
            n =Double.parseDouble(sentence);
            int sum = 0;
            for(int i=1;i<=n;i++){
                sum +=i;
            }
            //Lấy địa chỉ IP của bên gửi
            InetAddress IPAddress = receivePacket.getAddress();
            //Lấy số hiệu cổng bên gửi
            int port = receivePacket.getPort(); 
            //Xử lý dữ liệu vừa nhận
            String sentence_to_client = " Tong la: "+(sum);            
            //tạo gói tin để gửi đi client
            sendData = sentence_to_client.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            //Gửi gói tin đi
            serverSocket.send(sendPacket); 
        } 
    } 
}
