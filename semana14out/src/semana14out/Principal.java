/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana14out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Amand
 */
public class Principal {
    public static void main (String[] args)
    {
        List<Empregado> listaEmpregados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 8) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar empregados");
            System.out.println("2. Buscar empregados por cpf");
            System.out.println("3. Buscar empregados por salario");
            System.out.println("4. Ordenar lista de empregados por idade");
            System.out.println("5. Opção 5");
            System.out.println("6. Opção 6");
            System.out.println("7. Opção 7");
            System.out.println("8. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                {
                    int empregadosCadastrados = 0;
                    System.out.println("Instanciar os empregados");
                    for(int i = 0; i < 5; i++)
                    {
                        System.out.println("CPF do empregado "+(i+1));
                        String cpf = scanner.next();
                        System.out.println("idade do empregado "+(i+1));
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("salario base do empregado "+(i+1));
                        float salario = scanner.nextFloat();
                        scanner.nextLine();
                        Empregado empregado = new Empregado(cpf,idade,salario);
                        if(empregado.encontraCpf(listaEmpregados,cpf)==0)
                        {
                            listaEmpregados.add(empregado);  
                        }else
                        {
                            while(empregado.encontraCpf(listaEmpregados,cpf)==1)
                            {
                                System.out.println("CPF do empregado "+(i+1)+" foi invalido, tente novamente.");
                                cpf = scanner.next();
                                listaEmpregados.add(empregado);
                            }
                            empregadosCadastrados++;
                        }
                    
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("CPF do empregado a ser buscado:");
                    String cpf = scanner.next();
                    if(Empregado.encontraCpf(listaEmpregados,cpf)==1)
                    {
                        System.out.println("Empregado encontrado");
                    }else
                    {
                        System.out.println("Empregado nao existe");
                    }
                    break;
                }
                case 3:
                {
                    System.out.println("Salario do empregado a ser buscado:");
                    Float sal = scanner.nextFloat();
                    scanner.nextLine(); 
                    for(Empregado emp : listaEmpregados)
                    {
                        if(emp.getSalario() == sal)
                        {
                            System.out.println(emp.toString());
                        }
                    }
                    break;
                }
                case 4:
                {
                    Collections.sort(listaEmpregados);

                    System.out.println("Empregados ordenados por idade (crescente):");
                    for (Empregado empregado : listaEmpregados) {
                        System.out.println(empregado);
                    }

                    // Implemente a lógica da opção 4
                    break;
                }
                case 5:
                    // Implemente a lógica da opção 5
                    break;
                case 6:
                    // Implemente a lógica da opção 6
                    break;
                case 7:
                    // Implemente a lógica da opção 7
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
    }
    
    
}
}
