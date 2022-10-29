
package Fibo2;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class dayFiboserverUDP {
    
    public static void main(String args[]) throws Exception { 
        DatagramSocket serverSocket = new DatagramSocket(9998);  
        System.out.println("Luon san sang nhan tin:" );    
        
            byte[] receiveData = new byte[1024];
            byte[] sendData  = new byte[2048];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
            serverSocket.receive(receivePacket);
          
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort(); 
            
            //Xử lý dữ liệu vừa nhận                            
            String str; int a,b,k,p;  
            str = new String(receivePacket.getData()); 
            String input[]=str.split(" ");
            a=Integer.parseInt(input[0]);
            b=Integer.parseInt(input[1]);
            k=Integer.parseInt(input[2]);
            p=Integer.parseInt(input[3]);
                      
            int array[] = new int[k];
            
            String s=String.valueOf(a)+" "+String.valueOf(b)+" ";
            array[0]=a;array[1]=b;
            for (int i = 2; i < k; i++) {
                array[i] = array[i-1]+array[i-2];
                s=s+String.valueOf(array[i])+" ";
            }
             
            String sentence_to_client = ">> day Fibonaci gom " + s; 
          
             for (int i = 0; i < k; i++) {
                   if (array[i]==p)
                   {
                    sentence_to_client =sentence_to_client +" >> vi tri cua "+String.valueOf(p)+ " trong day la " +String.valueOf(i+1);
                    }  
              }        
           
            sendData = sentence_to_client.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);           
         
        }   
    } 

