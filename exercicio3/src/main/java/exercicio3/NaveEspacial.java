/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio3;

import java.util.Random;

/**
 *
 * @author Amand
 */
public class NaveEspacial {
    private String nome;
    private int velocidade;
    
    public NaveEspacial(String s) //construtor
    {
        nome = s;
        Random random = new Random();
        velocidade = random.nextInt(6) + 5; //gera numero entre 0 e 5 e adiciona 5 [5,10]
    }
    public String getNome()
    { 
        return nome;
    } 
    public int getVelocidade()
    { 
        return velocidade;
    } 
    public void setNome(String s)
    {
        nome = s;
    }
    public void setVelocidade(int i)
    {
        velocidade = i;
    }
    public String mostrarNave()
    {
        if(this.getVelocidade()!=0){
        return "Nome: "+this.getNome()+
                " Velocidade:"+this.getVelocidade();
        }else
        {
            return "Nave inoperante";
        }
        
    }
    public void paraNave()
    {
        this.setVelocidade(0);
    }
//    public int checaSuperpopulacao()
//    {
//        int contador = 0;
//        if(this.getVelocidade()!=0)
//        {
//            contador += 1;
//        }
//        return contador;
//    }
    public void ligaNave(int i)
    {
        this.setVelocidade(i); 
    
    }
    public int naveMaisRapida(NaveEspacial n)
    {
        if(n.getVelocidade() > this.getVelocidade())
            return 1;
        else
            return 0;
              
    }
}
