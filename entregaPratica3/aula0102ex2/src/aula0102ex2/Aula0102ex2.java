/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula0102ex2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Amand
 */
public class Aula0102ex2 {

    /**
     * @param args the command line arguments
     */
    private static final int tam = 20;
    public static void main(String[] args) {
        // TODO code application logic here
        int[] vetor = new int[tam];
        //preenche c 1 a tam
        for (int i = 0; i < tam; i++) {
            vetor[i] = i+1;
        }
        Lista primeiroNo = new Lista(1);
        primeiroNo.setProximo(null);
        AtomicInteger index = new AtomicInteger(0);
        
        ExecutorService executorService = Executors.newFixedThreadPool(tam); //cria n threads
        for(int i =0; i < tam; i++)
        {
            //fazer o run
            executorService.submit(new Runnable() 
            {
                @Override
                public void run()
                {
                    int pos = index.getAndIncrement();
                    Lista newNode = new Lista(vetor[pos+1]); //cria no com elemento do vetor na posição pos+1 pra começar da 2nd pos
                    synchronized(primeiroNo) //recebe obj e so uma thread o acessa por vez
                    {
//                        if(primeiroNo==null)
//                        {
//                            primeiroNo=newNode;
//                        }else
//                        {
                            Lista atualNode = primeiroNo; //ponteiro que percorre a lista e add no final
                            while(atualNode.getProximo()!=null)
                            {
                                atualNode=atualNode.getProximo();
                            }
                            atualNode.setProximo(newNode);
//                        }
                    }
                }
            });
        }
        executorService.shutdown();

        // Imprimir a lista encadeada
        Lista noAtual = primeiroNo;
        while (noAtual != null) {
            System.out.println(noAtual.getVal());
            noAtual = noAtual.getProximo();
        }
        System.out.println("aqui");
          
    }
    
}
