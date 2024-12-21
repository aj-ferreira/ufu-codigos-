package trabalho.poo2;

public class Estudante implements Consultavel {
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

    @Override
    public void consultar() {
        System.out.println("Nome: " + getPessoa().getNome());
        System.out.println(" Matricula: " + getMatricula());
        System.out.println(" Periodo: " + getPeriodo());
    }
    
}
