package SoHoanHao_RMI;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CilentSHH {
   public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
    System.out.println("*********************************");
    System.out.println("*    CHƯƠNG TRÌNH TRÊN CLIENT   *");
    System.out.println("*            Áp dụng RMI        *");
    System.out.println("*********************************");
    try{ 
        Registry reg = LocateRegistry.getRegistry("localhost",3333);
        System.out.println("Client đang tìm kiếm đối tượng từ xa trên Server ...");
        InterfSHH_RMI c = (InterfSHH_RMI)reg.lookup("rmi://localhost/MySHH_Server");
        
        String input;
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("Nháp day so nguyen, cach nhau boi dau ';' (Nhap 'stop' de thoat):");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                break;
            }else{
                System.out.println("Dãy SHH có trong chuoi : "+c.SoHH(input));
            } 
        }
        }catch(RemoteException e){
            System.out.println("Không tìm thấy đối tượng Remote");
        }
    } 
}
