package Teste;

import Projeto.Materia;
import Projeto.MateriaService;
import Projeto.Pessoa;
import Projeto.Professor;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConsultaMateriaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void consultaMateriaTest() {
        List<Materia> materias = new ArrayList<>();
        Professor professor = new Professor(new Pessoa("Maria", "98765432100", null, 'F'), "Matemática",
                Arrays.asList("Álgebra", "Cálculo"));
        materias.add(new Materia("Matemática", "Cálculo I", null, professor));

        MateriaService materiaService = new MateriaService(materias);

        materiaService.consultarMateria();

        String expected = "Nome: Cálculo I, Área de Ensino: Matemática, Professor: Maria";

        Assert.assertEquals(expected.trim().toLowerCase(), outContent.toString().trim().toLowerCase());
    }
}
