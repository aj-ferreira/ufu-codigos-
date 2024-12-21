package Projeto;

import java.util.List;

public class NotaAlunoMateriaService implements ConsultaNotaAlunoMateria {
	private List<Materia> materias;

	public NotaAlunoMateriaService(List<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public void consultarNotaAlunoMateria(Estudante estudante, Materia materia) {
		for (Materia m : materias) {
			if (m.equals(materia)) {
				int index = m.getListaAlunos().indexOf(estudante);
				if (index != -1) {
					double nota = m.getNotasAlunos().get(index);
					System.out.println("Nota do aluno " + estudante.getPessoa().getNome() + " na matéria " + materia.getNome() + ": " + nota);
					return;
				}
			}
		}
		System.out.println("Aluno não encontrado na matéria especificada.");
	}
}