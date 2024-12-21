package Projeto;

public class Pessoa {
    private String nome;
    private String cpf;
    private Endereco endereco;
    private char sexo;

    public Pessoa(String nome, String cpf, Endereco endereco, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.sexo = sexo;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public char getSexo() {
        return sexo;
    }
}