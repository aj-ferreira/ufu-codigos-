/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula0102.aula0102;
import static java.lang.Thread.sleep;
import java.util.Random;
/**
 *
 * @author Amand
 */
public class Lebre extends Thread{
    protected int pulo;
    protected int distancia;
    protected String nome;
    protected int distanciaPercorrida;
    protected static int posicao = 1;
    protected int chegou;
    
    

    public Lebre(String nome) {
        this.nome = nome;
    }
    
    public int getPulo() {
        return pulo;
    }

    public int getDistancia() {
        return distancia;
    }
    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public String getNome() {
        return nome;
    }

    public static int getPosicao() {
        return posicao;
    }

    public int getChegou() {
        return chegou;
    }
    
    
    
    @Override
    public void run() {
        distanciaPercorrida=20;
        Random r = new Random();
        while(distancia<distanciaPercorrida)
        {
            int salto = r.nextInt(3)+1;
            distancia+=salto;
            if(distancia>=20){
                chegou = posicao;
                posicao++;
            }
            System.out.println(this.getNome() +" pulou "+ this.getDistancia()+" metros");
            try
            {
                sleep(100);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
            
        }
    }
    
    
    
    
    
}
