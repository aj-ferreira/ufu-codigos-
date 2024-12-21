package trabalho.poo2;

public class Endereco {
    private String ruaAv;
    private int numero;
    private String bairro;
    private String cep;
    private String complemento;

    public Endereco(String ruaAv, int numero, String bairro, String cep, String complemento) {
        this.ruaAv = ruaAv;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
    }

    public String getRua() {
        return ruaAv;
    }

    public int getNumero() {
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
