package trabalho.poo2;

public class Universidade {
    private String nome;
    private Endereco endereco;

    public Universidade(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    
    
}
