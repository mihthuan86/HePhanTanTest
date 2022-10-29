package RMI;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

public class CalculatorServer { 
      private static final int PORT = 1099;
      private static Registry registry;
   public static void main(String[] args) {
        try {
           
            registry =  LocateRegistry.createRegistry(PORT);
                     
            Calculator ca = new CalculatorImpl();
            System.out.println("\n Dang ky remote thanh cong...");
            
            Naming.bind("rmi://localhost/Calculator1", ca);
            System.out.println("\n Tao doi tuong rmi thanh cong...");   
        }catch (Exception e) {
            System.out.println(" Loi: " + e);
        }  
    }
}
