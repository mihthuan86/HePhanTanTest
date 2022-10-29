package SoHoanHao_RMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TimSHH extends UnicastRemoteObject implements InterfSHH_RMI{
    public TimSHH() throws RemoteException {
    }
    
    @Override
    public String SoHH(String n)
    {
        String perfects = "";
        String perfectsPos = "";
        String[] numbersStr;
        int[] numbers;
        int sum;
        String st = n;
        numbersStr = st.split(";");
        numbers = new int[numbersStr.length];
        sum = 0;
        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            sum = 0;
            if(numbers[i] != 0){
                for (int j = 1; j <= numbers[i] / 2; j++) {
                    if (numbers[i] % j == 0) {
                        sum += j;
                    }
                }
                if (sum == numbers[i]) {
                    perfects += numbers[i] + " ";
                    perfectsPos += i + ",";
                }
            } 
        }
        if(perfects == ""){
            return "Khong co so HH trong chuoi vua nhap";
        }else{
            return perfects;
        }
    }     
}
