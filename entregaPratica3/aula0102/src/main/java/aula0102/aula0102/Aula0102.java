/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package aula0102.aula0102;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Amand
 */
public class Aula0102 {

    public static void main(String[] args) throws InterruptedException{
       Lebre[] lebres = new Lebre[5];

        for (int i = 0; i < 5; i++) {
            lebres[i] = new Lebre("Lebre-" + (i + 1));
        }

        for (Lebre lebre : lebres) {
            lebre.start();
        }

        for (Lebre lebre : lebres) {
            lebre.join();
        }
        for (int i = 0; i < lebres.length - 1; i++) {
            for (int j = 0; j < lebres.length - i - 1; j++) {
                if (lebres[j].getChegou() < lebres[j + 1].getChegou()) {
                    Lebre temp = lebres[j];
                    lebres[j] = lebres[j + 1];
                    lebres[j + 1] = temp;
                }
            }
        }
        
        System.out.println("\nResultado final:");
        for (int i = 0; i < lebres.length; i++) {
            System.out.println((i + 1) + "º lugar: " + lebres[i].getNome());
        }
        
    }
    
}
