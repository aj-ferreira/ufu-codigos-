package Projeto;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String areaEnsino;
    private String nome;
    private Universidade campus;
    private Professor professor;
    private List<Estudante> listaAlunos;
    private List<Double> notasAlunos;

    public Materia(String areaEnsino, String nome, Universidade campus, Professor professor) {
        this.areaEnsino = areaEnsino;
        this.nome = nome;
        this.campus = campus;
        this.professor = professor;
        this.listaAlunos = new ArrayList<>();
        this.notasAlunos = new ArrayList<>();
    }

    public String getAreaEnsino() {
        return areaEnsino;
    }

    public String getNome() {
        return nome;
    }

    public Universidade getCampus() {
        return campus;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Estudante> getListaAlunos() {
        return listaAlunos;
    }

    public List<Double> getNotasAlunos() {
        return notasAlunos;
    }
}