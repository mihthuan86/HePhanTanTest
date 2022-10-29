package Chat_RMI;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server_RMI {
    public static void main(String[] args) throws RemoteException, MalformedURLException{
        System.out.println("***************************************");
        System.out.println("* CHƯƠNG TRÌNH TÍNH TỔNG TRÊN SERVER  *");
        System.out.println("*       SỬ DỤNG JAVA -RMI             *");
        System.out.println("*       Ver01- Date 31/07/2022        *");
        System.out.println("***************************************");
        // Tao bo dang ky đoi tuong Remote, port = 9999, dia chi localhost
        try {
            Registry reg = LocateRegistry.createRegistry(9999);
            // Tao doi tuong Remote c
             TinhToan c = new TinhToan();
            //Rang buoc doi tuong va Server, gia su Server co duong dan la rmi://localhost/MyCalculator_Server 
            reg.rebind("rmi://localhost/MyCalculator_Server", c); 
            System.out.println("Server đã đăng ký đối tượng Remote...");
        } catch (RemoteException e) {
            System.out.println("Không tạo được đối tượng Remote");
        }//end catch
    }
}
