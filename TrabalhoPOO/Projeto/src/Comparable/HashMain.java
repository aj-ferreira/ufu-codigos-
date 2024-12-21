package Comparable;
import java.util.HashMap;
import java.util.Scanner;
public class HashMain 
{
	public static void main(String[] args)
	{
		HashMap<String,Empregado> hashEmpregados = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 2; i++) 
        {
            System.out.print("Digite o CPF do empregado: ");
            String cpf = scanner.next();
            System.out.print("Digite a idade do empregado: ");
            int idade = scanner.nextInt();
            System.out.print("Digite o salário do empregado: ");
            double salario = scanner.nextDouble();
            hashEmpregados.put(cpf,new Empregado(cpf, idade, salario));
        }
		int n;
		do
		{
			System.out.println("0.Sair\n1.Buscar empregado por CPF\n2.Buscar empregados com salario maior e menor\n");
        	n = scanner.nextInt();
        	switch(n)
        	{
	        	case 1:
	        	{
	        		String cpf = scanner.next();
	        		Empregado empregado = hashEmpregados.get(cpf);
	        		System.out.println("Empregado encontrado - CPF: " + empregado.getCpf() + ", Idade: " + empregado.getIdade() + ", Salário: " + empregado.getSalario());
	        		break;
	        	}
	        	case 2:
	        	{
	        		Empregado maiorSalario = null;
	        		Empregado menorSalario = null;
	        		for (Empregado value : hashEmpregados.values()) 
	        		{
	                    if(maiorSalario == null || maiorSalario.getSalario() < value.getSalario())
	                    {
	                    	maiorSalario = value;
	                    }
	                    if(menorSalario == null || menorSalario.getSalario() > value.getSalario())
	                    {
	                    	menorSalario = value;
	                    }
	                    
	                }
	        		System.out.println("Empregado encontrado com maior salario - CPF: " + maiorSalario.getCpf() + ", Idade: " + maiorSalario.getIdade() + ", Salário: " + maiorSalario.getSalario());
	        		System.out.println("Empregado encontrado com menor salario - CPF: " + menorSalario.getCpf() + ", Idade: " + menorSalario.getIdade() + ", Salário: " + menorSalario.getSalario());
	        	}
        	}
		}
		while(n !=0);
		scanner.close();
	}
}
