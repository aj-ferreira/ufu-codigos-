package Comparable;

import java.io.Serializable;

public class Empregado implements Comparable<Empregado>, Serializable
{
	private static final long serialVersionUID = 1L;
	private String cpf;
	private int idade;
	private double salario;
	public Empregado(String cpf,int idade,double salario)
	{
		this.idade = idade;
		this.cpf = cpf;
		this.salario = salario;
	}
	public double getSalario() 
	{
		return this.salario;
	}
	public String getCpf() 
	{
		return this.cpf;
	}
	public int getIdade()
	{
		return this.idade;
	}
	@Override
	public int compareTo(Empregado o) 
	{
		if(this.getIdade() > o.getIdade())
		{
			return 1;
		}
		else if (this.getIdade() < o.getIdade())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	 
}
