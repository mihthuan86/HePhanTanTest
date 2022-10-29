/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi_test;

/**
 *
 * @author Admin
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public abstract class HoanThien_Impl extends UnicastRemoteObject implements HoanThien_Interface{
    public HoanThien_Impl() throws RemoteException{};
    
    @Override
    public int sum(int n){
        int a=0;
        for(int i=1;i<n;i++)
        {
            if(n%i==0)
                a=a+i;
        }
        return a;
    }
}
