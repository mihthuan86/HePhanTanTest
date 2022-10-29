/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi_test;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface HoanThien_Interface extends Remote{
    public int sum(int n) throws RemoteException;
}
