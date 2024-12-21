package trabalho.poo2;

import java.util.ArrayList;
import java.util.List;

public class Professor implements Consultavel {
    private Pessoa pessoa;
    private String areaDeEnsino;
    private List<Materia> listaDeMaterias;

    public Professor(Pessoa pessoa, String areaDeEnsino) {
        this.pessoa = pessoa;
        this.areaDeEnsino = areaDeEnsino;
        this.listaDeMaterias = new ArrayList<>();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getAreaDeEnsino() {
        return areaDeEnsino;
    }

    public List<Materia> getListaDeMaterias() {
        return listaDeMaterias;
    }

    @Override
    public void consultar() {
        System.out.println("Professor: " + getPessoa().getNome());
        System.out.println(" Area de Ensino: " + getAreaDeEnsino());
        System.out.println(" Materias: ");
        for (Materia materia : listaDeMaterias) {
            System.out.println("- " + materia.getNome());
        }
    }
    
}
