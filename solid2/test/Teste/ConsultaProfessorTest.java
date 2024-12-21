package Teste;

import Projeto.Pessoa;
import Projeto.Professor;
import Projeto.ProfessorService;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConsultaProfessorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void consultaProfessorTest() {
        List<Professor> professores = new ArrayList<>();
        List<String> materiasLecionadas = Arrays.asList("Álgebra", "Cálculo");
        professores.add(new Professor(new Pessoa("João", "12345678900", null, 'M'), "Matemática", materiasLecionadas));

        ProfessorService professorService = new ProfessorService(professores);

        professorService.consultarProfessor();

        String expected = "Nome: " + professores.get(0).getPessoa().getNome() +
                ", Área de Ensino: " + professores.get(0).getAreaEnsino() +
                ", Matérias Lecionadas: " + professores.get(0).getMateriasLecionadas();

        Assert.assertEquals(expected.trim().toLowerCase(), outContent.toString().trim().toLowerCase());
    }
}
