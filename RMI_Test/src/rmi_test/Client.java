/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi_test;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KimThoa
 */
public class Client {
   public static void main(String args[])throws MalformedURLException, NotBoundException{
		
	 System.out.println("*********************************");
         System.out.println("*    CHUONG TRINH TREN CLIENT   *");
         System.out.println("*     Ap dung RMI, 31/07/2022   *");
         System.out.println("*********************************");
            try{ 
                  // Tạo bo dang ky de ket noi den Server voi dia chi la "localhost" va port 9999
                  Registry reg = LocateRegistry.getRegistry("localhost",9999);
                  // Tim kiem doi tuong Remote tren Server
                  System.out.println("Client dang tim kiem doi tuong tu xa tren Server ...");
                  HoanThien_Interface c=(HoanThien_Interface)reg.lookup("rmi://localhost/MyCalculator_Server");
                  // Nhap lieu cho Client
                    System.out.print("Hay nhap vao so nguyen tu ban phim:");
                    Scanner input=new Scanner(System.in);            
                    String arr[]=input.nextLine().split(";");
                    for(int i=0;i<arr.length;i++)
                    {
                        int n=Integer.parseInt(arr[i]);// chuyển từ String sang số nguyên
                        if(c.sum(n)==n)
                            System.out.println(n+" La so hoan thien");
                        else
                            System.out.println(n+" Ko phai la so hoan thien");
                    }
		}catch(RemoteException e){
			System.out.println("Khong tim thay doi tuong Remote");
		}
	}
}
