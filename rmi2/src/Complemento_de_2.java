
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amand
 */
public class Complemento_de_2 extends UnicastRemoteObject implements Int_Complemento_de_2{

    public Complemento_de_2() throws RemoteException 
    {
        super();
    }

    
    @Override
    public String converte(int valor) throws RemoteException 
    {
        String bin = Integer.toBinaryString(valor);
        int len = 32;
        if(valor >= 0)
        {
            return String.format("%"+len+"s"+bin);
        }else //eh negativo
        {
            int complemento = (int) Math.pow(2, len)+valor;
            return Integer.toBinaryString(complemento);
        }
    }
    
    public static void main(String[] args) throws AlreadyBoundException, MalformedURLException
    {
        try
        {
            Complemento_de_2 obj = new Complemento_de_2();
            Naming.bind("ComplementoServer",obj);
        }catch(RemoteException e)
        {
            e.printStackTrace();
        }
    }
    
}
