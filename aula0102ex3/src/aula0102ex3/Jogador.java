/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula0102ex3;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Amand
 */
public class Jogador implements Runnable{
    protected int id;
    protected int[] golsTime1;
    protected int[] golsTime2;
    protected int time;
    protected AtomicInteger toqueAtual;
    protected AtomicInteger timeComBola;

    public int getId() {
        return id;
    }

    public int[] getGolsTime1() {
        return golsTime1;
    }

    public int[] getGolsTime2() {
        return golsTime2;
    }

    public int getTime() {
        return time;
    }

    public AtomicInteger getToqueAtual() {
        return toqueAtual;
    }

    public AtomicInteger getTimeComBola() {
        return timeComBola;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGolsTime1(int[] golsTime1) {
        this.golsTime1 = golsTime1;
    }

    public void setGolsTime2(int[] golsTime2) {
        this.golsTime2 = golsTime2;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setToqueAtual(AtomicInteger toqueAtual) {
        this.toqueAtual = toqueAtual;
    }

    public void setTimeComBola(AtomicInteger timeComBola) {
        this.timeComBola = timeComBola;
    }
    
    @Override
    public void run() {
        Random rand = new Random();
        while(toqueAtual.get() <= Aula0102ex3.tempoMax)
        {
            int timeAtual = timeComBola.get();
            if(id == toqueAtual.get())//jogador tem a bola
            {
                toqueAtual.incrementAndGet();
                
                try
                {
                    Thread.sleep(rand.nextInt(1000)); //tempo que jogador mantem bola
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    
    
}
