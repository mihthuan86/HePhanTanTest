/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi_test;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KimThoa
 */
public class Server {
    public static void main(String args[]) throws RemoteException {
        System.out.println("****************************************");
        System.out.println("* CHUONG TRINH LIET KE SO HOAN THIEN  ");
        System.out.println("       SU DUNG JAVA - RMI             ");
        System.out.println("****************************************");

        // Tao bo dang ky đoi tuong Remote, port = 9999, dia chi localhost
        try {
            Registry reg = LocateRegistry.createRegistry(9999);
            // Tao doi tuong Remote c
             HoanThien_Impl c = new HoanThien_Impl() {};
            //Rang buoc doi tuong va Server, gia su Server co duong dan la rmi://localhost/MyCalculator_Server 
            reg.rebind("rmi://localhost/MyCalculator_Server", c); 
            System.out.println("Server da dang ky doi tuong Remote...");
        } catch (RemoteException e) {
            System.out.println("Khong tao đuoc doi tuong Remote");
        }//end catch
    }//end main
}
