package Projeto;

import java.util.List;

public class MateriaService implements ConsultaMateria {
    private List<Materia> materias;

    public MateriaService(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public void consultarMateria() {
        for (Materia materia : materias) {
            System.out.println("Nome: " + materia.getNome() +
                    ", Área de Ensino: " + materia.getAreaEnsino() +
                    ", Professor: " + materia.getProfessor().getPessoa().getNome());
        }
    }
}
