package Projeto;

public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private String complemento;

    public Endereco(String rua, String numero, String bairro, String cep, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }
}
