package Chat_RMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TinhToan extends UnicastRemoteObject implements Interf_RMI{

    public TinhToan() throws RemoteException {
    }
   
    @Override
    public int sum(int n)
    {
        int S= 0;
        for(int i=1;i<=n; i++)
          S= S+i;
          return S; 
    }     
}
