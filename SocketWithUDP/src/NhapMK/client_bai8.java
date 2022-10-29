/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhapMK;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Administrator
 */
public class client_bai8 {
    static String Nhap() throws IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Mau nhap vao > User;Password: ");
        String str = inFromUser.readLine();
        return str.trim();
    }

    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket(8159);
        InetAddress IPAddress = InetAddress.getByName("localhost");

        int count = 1;
        while (true) {
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[2048];
            String strs = Nhap();
            
            if (strs.trim().equalsIgnoreCase("stop") || count == 3)
                break;
            
            String str = strs +";"+ count;

            sendData = str.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9998);
            clientSocket.send(sendPacket);
            
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modified_Sentence = new String(receivePacket.getData());
            String s[] = modified_Sentence.split(";");
            System.out.println("FROM SERVER: " + s[1]);
            if (s[0].equalsIgnoreCase("false")) {
                count += 1;
            }else{
                count = 1;
            }
        }
        clientSocket.close();

    }

}
