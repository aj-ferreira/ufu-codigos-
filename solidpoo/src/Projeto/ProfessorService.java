package Projeto;

import java.util.List;

public class ProfessorService implements ConsultaProfessor {
    private List<Professor> professores;

    public ProfessorService(List<Professor> professores) {
        this.professores = professores;
    }

    @Override
    public void consultarProfessor() {
    	 System.out.println("Lista de Professores:");
         for (Professor professor : professores) {
             System.out.println("Nome: " + professor.getPessoa().getNome() +
                     ", Área de Ensino: " + professor.getAreaEnsino() +
                     ", Matérias Lecionadas: " + professor.getMateriasLecionadas());
         }
    }
}