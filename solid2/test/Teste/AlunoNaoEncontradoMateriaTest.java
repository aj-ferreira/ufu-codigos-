package Teste;

import Projeto.Endereco;
import Projeto.Estudante;
import Projeto.Materia;
import Projeto.NotaAlunoMateriaService;
import Projeto.Pessoa;
import Projeto.Professor;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class AlunoNaoEncontradoMateriaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testConsultarNotaAlunoMateria() {
        // Preparação dos dados de teste
        Endereco endereco = new Endereco("Rua Pessoa 1", "456", "Bairro A", "54321-876", "");
        Pessoa pessoa = new Pessoa("João", "12345678900", endereco, 'M');
        Estudante estudante = new Estudante(pessoa, "20220001", "3º Período");
        Professor professor = new Professor(null, null, null);
        Materia materia = new Materia("Matemática", "Cálculo I", null, professor);
        materia.getListaAlunos().add(estudante);
        materia.getNotasAlunos().add(8.5);
        List<Materia> materias = new ArrayList<>();
        materias.add(materia);

        // Redirecionar a saída padrão para capturar a impressão na tela
        System.setOut(new PrintStream(outContent));

        // Executar o método a ser testado com um estudante que não está na matéria
        Estudante estudanteInexistente = new Estudante(new Pessoa("Maria", "98765432100", null, 'F'), "20220002", "2º Período");
        NotaAlunoMateriaService notaAlunoMateriaService = new NotaAlunoMateriaService(materias);
        notaAlunoMateriaService.consultarNotaAlunoMateria(estudanteInexistente, materia);

        // Verificar se a saída é conforme o esperado
        String expectedOutput = "Aluno não encontrado na matéria especificada.";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
