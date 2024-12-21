
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Amand
 */
public interface Int_Complemento_de_2 extends Remote
{
    String converte(int valor)throws RemoteException;
    
}
