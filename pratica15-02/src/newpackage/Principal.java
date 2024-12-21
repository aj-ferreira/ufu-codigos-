/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Amand
 */
public class Principal {
    public static void main(String[] args)
    {
        List<calculadora> calculadoras = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) 
        {
            calculadora calc = new calculadora(i);
            calculadoras.add(calc);
        }

        while (true) {
            System.out.println("Escolha uma calculadora de (0-9) ou -1 para sair:");
            int escolha = scanner.nextInt();

            if (escolha == -1) 
            {
                break;
            }

            if (escolha >= 0 && escolha < calculadoras.size()) 
            {
                calculadora escolhida = calculadoras.get(escolha);
                escolhida.run();
            } else 
            {
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
    
}
