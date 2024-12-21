/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisao.prova2;

import java.util.List;

/**
 *
 * @author Amand
 */
public class Media_Aritmetica_Service implements I_Media
{

    private List<Double> valores;

    public Media_Aritmetica_Service(List<Double> valores) 
    {
        this.valores = valores;
    }
    
    
    
    @Override
    public double media(List<Double> valores) 
    {
        double media =0;
        for(Double d : valores) media += d;
        media = media/valores.size();
        return media;
    }
    
}
