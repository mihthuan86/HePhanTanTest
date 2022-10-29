package SoHoanHao_RMI;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerSHH {
    public static void main(String[] args) throws RemoteException, MalformedURLException{
        System.out.println("***************************************");
        System.out.println("* CHUONG TRINH TIM SO HOAN HAO SERVER *");
        System.out.println("*       SỬ DỤNG JAVA -RMI             *");
        System.out.println("***************************************");
        // Tao bo dang ky đoi tuong Remote, port = 9999, dia chi localhost
        try {
            Registry reg = LocateRegistry.createRegistry(3333);
            TimSHH c = new TimSHH();
            reg.rebind("rmi://localhost/MySHH_Server", c); 
            System.out.println("Server đã đăng ký đối tượng Remote...");
        } catch (RemoteException e) {
            System.out.println("Không tạo được đối tượng Remote");
        }//end catch
    }
}
