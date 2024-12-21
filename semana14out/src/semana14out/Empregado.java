/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana14out;

import java.util.List;

/**
 *
 * @author Amand
 */
public class Empregado implements Comparable<Empregado>{
    private String cpf;
    private int idade;
    private float salario;

    public Empregado(String cpf, int idade, float salario) {
        this.cpf = cpf;
        this.idade = idade;
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public float getSalario() {
        return salario;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    @Override
    public int compareTo(Empregado o) {
        return Integer.compare(this.getIdade(), o.getIdade());
        // retorno < 0 , entao o objeto que chama eh menor que o objeto do argumento
        // retorno == 0, entao objeto que chama e o parametro sao iguais
        // retorno > 0, entao o objeto que chama eh maior que o objeto do argumento
    } 
    
    public static int encontraCpf(List<Empregado> lista, String s)
    {
        for(Empregado empregado : lista )
        {
            if(empregado.getCpf().equals(s))
                return 1;
            
        }
        return 0;
    }
    
    public static Empregado salarioBusca(List<Empregado> listaEmpregados, Float f) {
    for (Empregado empregado : listaEmpregados) {
        if (empregado.getSalario() == f) {
            return empregado;
        }
    }
    return null; // Retorna null se o empregado não for encontrado
}

    @Override
    public String toString() {
        return "Empregado{" + "cpf=" + cpf + ", idade=" + idade + ", salario=" + salario + '}';
    }
    
    
    
    
}
