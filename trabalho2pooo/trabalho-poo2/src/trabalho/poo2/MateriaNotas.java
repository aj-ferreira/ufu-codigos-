package trabalho.poo2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MateriaNotas {

    private Materia materia;
    private Map<Estudante, Double> notasAluno;

    public MateriaNotas(Materia materia, Map<Estudante, Double> notasAlunos) {
        this.materia = materia;
        this.notasAluno = notasAlunos;
    }

    public void consultarNotaEstudante(Estudante estudante) {
        for (Map.Entry<Estudante, Double> entry : notasAluno.entrySet()) {
            Estudante estudanteKey = entry.getKey();
            if(estudanteKey == estudante){
                Double nota = entry.getValue();
                System.out.println("A nota do aluno " + estudante.getPessoa().getNome() + " na materia " + materia.getNome() + " eh " + nota);
            }
        }
        
    }

}
