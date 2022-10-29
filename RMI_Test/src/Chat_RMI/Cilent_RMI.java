package Chat_RMI;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cilent_RMI {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
    System.out.println("*********************************");
    System.out.println("*    CHƯƠNG TRÌNH TRÊN CLIENT   *");
    System.out.println("*     Áp dụng RMI, 31/07/2022   *");
    System.out.println("*********************************");
    try{ 
          // Tạo bo dang ky de ket noi den Server voi dia chi la "localhost" va port 9999
          Registry reg = LocateRegistry.getRegistry("localhost",9999);
          // Tim kiem doi tuong Remote tren Server
          System.out.println("Client đang tìm kiếm đối tượng từ xa trên Server ...");
          Interf_RMI c = (Interf_RMI)reg.lookup("rmi://localhost/MyCalculator_Server");
          // Nhap lieu cho Client
            System.out.print("Hãy nhập vào số nguyên từ bàn phím:");
            Scanner input=new Scanner(System.in);
            int n=Integer.parseInt(input.nextLine());// chuyển từ String sang số nguyên
            System.out.println("Sum("+n+"):= "+c.sum(n));
        }catch(RemoteException e){
            System.out.println("Không tìm thấy đối tượng Remote");
        }
    }
}
