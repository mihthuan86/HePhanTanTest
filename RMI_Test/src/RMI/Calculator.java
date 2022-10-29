
package RMI;
import java.rmi.*;
public interface Calculator extends Remote{
    public int addNum(int a, int b, int c) throws RemoteException;
}