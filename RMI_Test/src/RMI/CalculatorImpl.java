
package RMI;

import java.rmi.*;
import java.rmi.server.*;
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    public CalculatorImpl() throws RemoteException {
    }
    public int addNum(int a, int b, int c) throws RemoteException {
        System.out.println("\n May khach yeu cau tinh!");
        return (a+b+c);
    }
}