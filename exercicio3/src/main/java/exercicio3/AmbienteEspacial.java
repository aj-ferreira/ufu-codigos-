/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio3;

import java.util.Scanner;

/**
 *
 * @author Amand
 */
public class AmbienteEspacial {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int qtd = 0;
        NaveEspacial[] nave = new NaveEspacial[5];
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar nave");
            System.out.println("2. Exibir naves");
            System.out.println("3. Parar nave");
            System.out.println("4. Ligar nave");
            System.out.println("5. Checar se nave eh mais rapida");
            System.out.println("6. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    if(qtd == 5)
                    {
                        System.out.println("Quantidade maxima de naves atingida!");
                        break;
                    }
                    System.out.println("Entre o nome da nave");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    nave[qtd] = new NaveEspacial(nome);
                    qtd++;
                    break;
                case 2:
                    for(int i=0;i<qtd;i++)
                    {
                     System.out.println("Nave "+(i+1)+":"+nave[i].mostrarNave());
                    }
                    break;
                case 3:
                    System.out.println("Naves em movimento: ");
                    
                    for(int i=0;i<qtd;i++)
                    {
                        if(nave[i].getVelocidade()!=0)
                        {
                          System.out.println(""+(i+1)+"."+nave[i].mostrarNave());
                          
                        }
                          
                    }
                    System.out.println("Entre qual nave deseja parar");
                    int i = scanner.nextInt();
                    while(i>qtd || i<0)
                    {
                        System.out.println("Numero invalido, tente novamente");
                        i = scanner.nextInt();
                    }
                    nave[i-1].paraNave();
                    break;
                case 4:
                    int cont=0;
                    System.out.println("Naves paradas: ");
                    for(int k=0;k<qtd;k++)
                    {
                        if(nave[k].getVelocidade()==0)
                        {
                            System.out.println(""+(k+1)+"."+nave[k].mostrarNave());
                            cont+=1;
                        }
                          
                    }
                    int navesEmMovimento = qtd - cont;
                    System.out.println("Entre qual nave deseja ligar");
                    int k = scanner.nextInt();
                    if(navesEmMovimento>3)
                    {
                        System.out.println("Superpopulacao de naves");
                        break;
                    }
                    
                    while(k>cont || k<0)
                    {
                        System.out.println("Numero invalido, tente novamente");
                        k = scanner.nextInt();
                    }
                    System.out.println("Entre a velocidade da nave");
                    int j = scanner.nextInt();
                    nave[k-1].ligaNave(j);
                    System.out.println(nave[k-1].mostrarNave());
                    break;
                case 5:
                    System.out.println("Entre qual nave deseja saber se eh mais rapida");
                    k = scanner.nextInt();
                    while(k<0 || k>qtd)
                    {
                        System.out.println("Numero invalido, tente novamente");
                        k = scanner.nextInt();
                    }
                    System.out.println("Entre com qual deseja comparar");
                    j = scanner.nextInt();
                    while(j<0 || j>qtd)
                    {
                        System.out.println("Numero invalido, tente novamente");
                        j = scanner.nextInt();
                    }
                    if(nave[j-1].naveMaisRapida(nave[k-1]) == 1)
                    {
                        System.out.println("Nave mais rapida "+(k+1)+":"+nave[k-1].mostrarNave());
                    }else
                    {
                        System.out.println("Nave mais rapida "+(j+1)+":"+nave[j-1].mostrarNave());
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
    } scanner.close();
    
}
}