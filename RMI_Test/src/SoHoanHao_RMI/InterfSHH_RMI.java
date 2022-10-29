package SoHoanHao_RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface InterfSHH_RMI extends Remote{
    public String SoHH(String n) throws RemoteException;
}
