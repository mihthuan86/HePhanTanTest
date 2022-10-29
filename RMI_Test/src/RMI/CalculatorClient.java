package RMI;

import java.util.*;
import java.rmi.*;
public class CalculatorClient {
    public static void main(String[] args) {
        try {
            System.out.println("\n Ket noi den may chu...");
            
            Calculator ca = (Calculator)Naming.lookup("rmi://localhost/Calculator1");
           
            Scanner in = new Scanner(System.in);
            
            while (true){
                System.out.print(" a = ");
                int a = in.nextInt();
                System.out.print(" b = ");
                int b = in.nextInt();
                System.out.print(" c = ");
                int c = in.nextInt();
                System.out.println(" Ket qua: " + ca.addNum(a, b, c));
                if(a == 0 || b == 0 || c == 0){
                    break;
                }
            }
        }catch (Exception e) {
            System.out.println(" Loi: "+ e);
        }
    }
}