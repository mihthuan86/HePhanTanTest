/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhapMK;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Administrator
 */
public class server_bai8 {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9998);
        while (true) {
            System.out.println("Luon san sang nhan tin:");
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[2048];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            // Xử lý dữ liệu vừa nhận
            String str = new String(receivePacket.getData());
       
            String s[] = str.trim().split(";");

            boolean checkEnd = false;
            String sentence_to_client = "false";
            if (s[0].equalsIgnoreCase("CS420") && s[1].equalsIgnoreCase("123")) {
                sentence_to_client = "true;" + "Bạn đã truy cập thành công";
                checkEnd = true;
            } else if (s[2].equals("3")) {
                sentence_to_client += ";" + "Bạn đã nhập sai 3 lần, bạn đã hết quyền truy cập vào hệ thống!";
                checkEnd = true;
            } else
                sentence_to_client = "false;" + "User (hoặc Password) không đúng, yêu cầu nhập lại!";

            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            sendData = sentence_to_client.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
            if (checkEnd)
                break;
        }
    }
}
