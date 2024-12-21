
package trabalho.poo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Materia implements Consultavel {
    private String areaDeEnsino;
    private String nome;
    private List<Universidade> camposDeUniversidade;
    private Professor professor;
    private List<Estudante> estudantes;
    private Map<Estudante, Double> notasDoAluno;

    public Materia(String areaDeEnsino, String nome, Professor professor) {
        this.areaDeEnsino = areaDeEnsino;
        this.nome = nome;
        this.camposDeUniversidade = new ArrayList<>();
        this.professor = professor;
        this.estudantes = new ArrayList<>();
        this.notasDoAluno = new HashMap<>();
    }

    public String getAreaDeEnsino() {
        return areaDeEnsino;
    }

    public String getNome() {
        return nome;
    }

    public List<Universidade> getCamposDeUniversidade() {
        return camposDeUniversidade;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public Map<Estudante, Double> getNotasDoAluno() {
        return notasDoAluno;
    }

    @Override
    public void consultar() {
        System.out.println("Nome Materia: " + getNome());
        System.out.println(" Area Ensino: " + getAreaDeEnsino());
        System.out.println(" Professor: " + getProfessor());
        System.out.println(" Estudantes: ");
        
        
        for (Estudante estudante : getEstudantes()) {
            System.out.println("- " + estudante.getMatricula() + ", " + estudante.getPessoa().getNome());
        }
        
        System.out.println("Notas dos alunos: ");
        for (Map.Entry<Estudante, Double> entry : notasDoAluno.entrySet()) {
            Estudante estudante = entry.getKey();
            Double nota = entry.getValue();
            System.out.println("- " + estudante.getPessoa().getNome() + " " + nota);
        }
        
        System.out.println("Campos de Universidade:");
        for (Universidade universidade : camposDeUniversidade) {
            System.out.println("- " + universidade.getNome());
        }
        
    }
    
    
    
    
}
