package Comparable;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainProject{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        List<Empregado> empregados = new ArrayList<>();
        // Carrega empregados do arquivo
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("empregados.dat"))) 
        {
            @SuppressWarnings("unchecked")
			List<Empregado> empregadosCarregados = (List<Empregado>) inputStream.readObject();
            empregados = empregadosCarregados;
            System.out.println("Empregados carregados do arquivo:");
            for (Empregado empregado : empregadosCarregados) 
            {
                System.out.println("CPF: " + empregado.getCpf() + ", Idade: " + empregado.getIdade() + ", Salário: " + empregado.getSalario());
            }
        } catch (IOException | ClassNotFoundException e) 
        {
            System.out.println("Erro ao carregar empregados do arquivo: " + e.getMessage());
        }
        for (int i = 0; i < 2; i++) 
        {
            System.out.print("Digite o CPF do empregado: ");
            String cpf = scanner.next();
            System.out.print("Digite a idade do empregado: ");
            int idade = scanner.nextInt();
            System.out.print("Digite o salário do empregado: ");
            double salario = scanner.nextDouble();
            empregados.add(new Empregado(cpf, idade, salario));
        }
        int n;
        do
        {
        	System.out.println("0.Sair\n1.Buscar empregado por CPF\n2.Buscar empregados com salario maior\n3.Lista de empregados ordenados por idade\n");
        	n = scanner.nextInt();
        	switch(n)
        	{
        		case 1:
        		{
        	        System.out.print("Digite o CPF do empregado que deseja buscar: ");
        	        String cpfBusca = scanner.next();
        	        for (Empregado empregado : empregados) 
        	        {
        	            if (empregado.getCpf().equals(cpfBusca)) 
        	            {
        	                System.out.println("Empregado encontrado - CPF: " + empregado.getCpf() + ", Idade: " + empregado.getIdade() + ", Salário: " + empregado.getSalario());
        	                break;
        	            }
        	        }
            		break;
            	}
        		case 2:
        		{
        	        System.out.print("Digite o valor do salário para a busca: ");
        	        double salarioBusca = scanner.nextDouble();
        	        System.out.println("Empregados com salário maior que " + salarioBusca + ":");
        	        for (Empregado empregado : empregados) 
        	        {
        	            if (empregado.getSalario() > salarioBusca) 
        	            {
        	                System.out.println("CPF: " + empregado.getCpf() + ", Idade: " + empregado.getIdade() + ", Salário: " + empregado.getSalario());
        	            }
        	        }
        			break;
        		}
        		case 3:
        		{
        	        Collections.sort(empregados);
        	        System.out.println("Empregados ordenados por idade:");
        	        for (Empregado empregado : empregados) 
        	        {
        	            System.out.println("CPF: " + empregado.getCpf() + ", Idade: " + empregado.getIdade() + ", Salário: " + empregado.getSalario());
        	        }
        		}
        	}
        	
        }while(n!=0);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("empregados.dat"))) 
        {
            // Cria o arquivo se ele não existir
            File arquivo = new File("empregados.dat");
            if (!arquivo.exists()) 
            {
                arquivo.createNewFile();
            }

            outputStream.writeObject(empregados);
            System.out.println("Empregados foram salvos no arquivo 'empregados.dat'");
        } catch (IOException e) 
        {
            System.out.println("Erro ao salvar empregados no arquivo: " + e.getMessage());
        }
        scanner.close();


        
    }
}
