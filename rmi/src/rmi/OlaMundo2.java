/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Amand
 */
public class OlaMundo2 extends UnicastRemoteObject implements OlaMundo{
    public OlaMundo2() throws RemoteException {
        super();
    }
    @Override
    public String Ola() throws RemoteException {
        return "Ola Mundo!";
    }
     public static void main(String[] args) throws AlreadyBoundException, MalformedURLException
    {
        try
        {
            OlaMundo2 olamundo = new OlaMundo2();
            Naming.bind("HelloWorldServer",olamundo);
        }catch(RemoteException e)
        {
            e.printStackTrace();
        }
    }
    
}
