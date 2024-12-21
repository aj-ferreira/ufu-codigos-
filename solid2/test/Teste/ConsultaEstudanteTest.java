package Teste;

import Projeto.Estudante;
import Projeto.EstudanteService;
import Projeto.Pessoa;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConsultaEstudanteTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void consultaEstudanteTest() {
        List<Estudante> estudantes = new ArrayList<>();
        estudantes.add(new Estudante(new Pessoa("Maria", "98765432100", null, 'F'), "20220001", "3º Período"));

        EstudanteService estudante = new EstudanteService(estudantes);

        estudante.consultarEstudante();

        String expected = "Nome: " + estudantes.get(0).getPessoa().getNome() +
                ", Matrícula: " + estudantes.get(0).getMatricula() +
                ", Período: " + estudantes.get(0).getPeriodo();

        Assert.assertEquals(expected.trim().toLowerCase(), outContent.toString().trim().toLowerCase());
    }
}
