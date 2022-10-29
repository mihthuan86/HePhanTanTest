package Chat_RMI;
// Xay dung Interface chua phuong thuc tinh tong S= 1+2+3...+ n
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Interf_RMI extends Remote{
    public int sum(int n) throws RemoteException;
}
