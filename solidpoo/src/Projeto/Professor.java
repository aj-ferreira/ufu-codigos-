package Projeto;

import java.util.List;

public class Professor {
    private Pessoa pessoa;
    private String areaEnsino;
    private List<String> materiasLecionadas;

    public Professor(Pessoa pessoa, String areaEnsino, List<String> materiasLecionadas) {
        this.pessoa = pessoa;
        this.areaEnsino = areaEnsino;
        this.materiasLecionadas = materiasLecionadas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getAreaEnsino() {
        return areaEnsino;
    }
    
    public List<String> getMateriasLecionadas() {
        return materiasLecionadas;
    }
}
