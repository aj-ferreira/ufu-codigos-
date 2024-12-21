package Projeto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criação de instâncias de Endereco
        Endereco campusEndereco = new Endereco("Rua Campus", "123", "Centro", "12345-678", "");
        Endereco enderecoPessoa1 = new Endereco("Rua Pessoa 1", "456", "Bairro A", "54321-876", "");
        Endereco enderecoPessoa2 = new Endereco("Rua Pessoa 2", "789", "Bairro B", "98765-432", "");

        // Criação de instâncias de Pessoa
        Pessoa pessoa1 = new Pessoa("João", "12345678900", enderecoPessoa1, 'M');
        Pessoa pessoa2 = new Pessoa("Maria", "98765432100", enderecoPessoa2, 'F');

        // Criação de instâncias de Estudante e Professor
        Estudante estudante = new Estudante(pessoa1, "20220001", "3º Período");
        Professor professor = new Professor(pessoa2, "Matemática", Arrays.asList("Álgebra", "Cálculo"));

        // Criação de instância de CampusUniversidade
        Universidade campus = new Universidade("Universidade ABC", campusEndereco);

        // Criação de instâncias de Materia
        Materia materia = new Materia("Matemática", "Cálculo I", campus, professor);
        materia.getListaAlunos().add(estudante);
        materia.getNotasAlunos().add(8.5); // Nota do estudante João na matéria Cálculo I

        // Lista de estudantes, professores e matérias
        List<Estudante> estudantes = Arrays.asList(estudante);
        List<Professor> professores = Arrays.asList(professor);
        List<Materia> materias = Arrays.asList(materia);

        // Inicialização dos serviços de consulta
        EstudanteService estudanteService = new EstudanteService(estudantes);
        ProfessorService professorService = new ProfessorService(professores);
        MateriaService materiaService = new MateriaService(materias);
        NotaAlunoMateriaService notaAlunoMateria = new NotaAlunoMateriaService(materias);

        // Menu interativo para consultas
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n=== MENU DE CONSULTAS ===");
            System.out.println("1. Consultar Matéria");
            System.out.println("2. Consultar Professor");
            System.out.println("3. Consultar Estudante");
            System.out.println("4. Consultar Nota de Aluno em Matéria");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n---- Consulta de Matéria ----");
                    materiaService.consultarMateria();
                    break;
                case 2:
                    System.out.println("\n---- Consulta de Professor ----");
                    professorService.consultarProfessor();
                    break;
                case 3:
                    System.out.println("\n---- Consulta de Estudante ----");
                    estudanteService.consultarEstudante();
                    break;
                case 4:
                    System.out.println("\n---- Consulta de Nota de Aluno em Matéria ----");
                    System.out.print("Digite o CPF do aluno: ");
                    String cpf = scanner.next();
                    System.out.print("Digite o nome da matéria: ");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    String nomeMateria = scanner.nextLine();
                    Estudante aluno = null;
                    for (Estudante e : estudantes) {
                        if (e.getPessoa().getCpf().equals(cpf)) {
                            aluno = e;
                            break;
                        }
                    }
                    if (aluno != null) {
                        Materia materiaAluno = null;
                        for (Materia m : materias) {
                            if (m.getNome().equals(nomeMateria)) {
                                materiaAluno = m;
                                break;
                            }
                        }
                        if (materiaAluno != null) {
                        	notaAlunoMateria.consultarNotaAlunoMateria(aluno, materiaAluno);
                        } else {
                            System.out.println("Matéria não encontrada.");
                        }
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
