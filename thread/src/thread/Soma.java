/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.util.Random;

/**
 *
 * @author Amand
 */
public class Soma implements Runnable
{
    private static int[][] matriz;
    private int[] linha;
    
    public Soma(int[] linha)
    {
        this.linha = linha;
    }
    @Override
    public void run() {
        int somaDaLinha=0;
        for(int v : linha)
        {
            somaDaLinha+=v;
        }
        System.out.println("soma da linha = " + somaDaLinha);
    }
    
//    public static void main(String[] args)
//    {
//        int qtdDeLinhas = matriz.length;
//        Thread[] threads = new Thread[qtdDeLinhas];
//        for(int i = 0;i<qtdDeLinhas;i++)
//        {
//            threads[i]=new Thread(new Soma(matriz[i]));
//            
//        }
//    }
    
}
