package Final_Examl;;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
public class client2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String url = "E:\\Input.txt";

        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner scanner = new Scanner(fileInputStream);
        try {
            String message = "";
            do {
                Socket socket = new Socket("localhost", 1200);
                OutputStream out = socket.getOutputStream();
                DataOutputStream dout = new DataOutputStream(out);

                System.out.println("Du lieu tu file la: ");

                message = scanner.nextLine();

                System.out.println("[CLIENT]: " + message);

                dout.writeUTF(message);
                dout.flush();
                DataInputStream din = new DataInputStream(socket.getInputStream());
                String result = din.readUTF();
                if (!result.equalsIgnoreCase("stop")) {
                    System.out.println("[SERVER]: " + result);
                }
            } while (!message.equalsIgnoreCase("stop"));
        } catch (IOException ex) {
            System.out.println("" + ex.getMessage());
        }
    }
}
