package Projeto;

public 
class Estudante {
    private Pessoa pessoa;
    private String matricula;
    private String periodo;

    public Estudante(Pessoa pessoa, String matricula, String periodo) {
        this.pessoa = pessoa;
        this.matricula = matricula;
        this.periodo = periodo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getPeriodo() {
        return periodo;
    }
}
