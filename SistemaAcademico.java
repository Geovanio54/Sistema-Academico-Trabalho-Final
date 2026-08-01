import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAcademico {

    Scanner sc = new Scanner(System.in);

    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private ArrayList<Matricula> matriculas = new ArrayList<>();
    private int proximoIdAluno = 1;
    private int proximoIdDisciplina = 1;

    // =========================

    public void cadastrarAluno() {

        System.out.print("Nome do aluno: ");
        String nome = sc.nextLine();

        alunos.add(new Aluno(proximoIdAluno++, nome));

        System.out.println("Aluno cadastrado!");
    }

    // =========================

    public void cadastrarDisciplina() {

        System.out.print("Nome da disciplina: ");
        String nome = sc.nextLine();

        disciplinas.add(new Disciplina(proximoIdDisciplina++, nome));

        System.out.println("Disciplina cadastrada!");
    }

    // =========================

    public void listarAlunos() {

        for (Aluno a : alunos) {
            System.out.println(a);
        }

    }

    // =========================

    public void listarDisciplinas() {

        for (Disciplina d : disciplinas) {
            System.out.println(d);
        }

    }

    // =========================

    public void matricularAluno() {

        listarAlunos();
        System.out.print("ID do aluno: ");
        int idAluno = sc.nextInt();

        listarDisciplinas();
        System.out.print("ID da disciplina: ");
        int idDisciplina = sc.nextInt();

        sc.nextLine();

        // Validação do ID do aluno
        if (idAluno < 1 || idAluno > alunos.size()) {
            System.out.println("Aluno inexistente.");
            return;
        }

        // Validação do ID da disciplina
        if (idDisciplina < 1 || idDisciplina > disciplinas.size()) {
            System.out.println("Disciplina inexistente.");
            return;
        }

        Aluno aluno = alunos.get(idAluno - 1);
        Disciplina disciplina = disciplinas.get(idDisciplina - 1);

        // Verifica se a matrícula já existe
        for (Matricula m : matriculas) {

            if (m.getAluno().getId() == aluno.getId() &&
                m.getDisciplina().getId() == disciplina.getId()) {

                System.out.println("Erro: este aluno já está matriculado nesta disciplina.");
                return;
            }

        }

        // Se não existir, realiza a matrícula
        matriculas.add(new Matricula(aluno, disciplina));

        System.out.println("Aluno matriculado com sucesso!");
    }

    // =========================

    public void lancarNotas() {

        listarMatriculas();

        System.out.print("Escolha a matrícula: ");
        int i = sc.nextInt();

        if (i < 1 || i > matriculas.size()) {
            System.out.println("Matrícula inexistente.");
            return;
        }

        double nota;

        do {

            System.out.print("Digite a nota (0 a 10): ");
            nota = sc.nextDouble();

            if (nota < 0 || nota > 10) {
                System.out.println("Erro! A nota deve estar entre 0 e 10.");
            }

        } while (nota < 0 || nota > 10);

        matriculas.get(i - 1).setNota(nota);

        System.out.println("Nota cadastrada com sucesso!");

        //System.out.println("Nota lançada.");
    }

    // =========================

    public void listarMatriculas() {

        int i = 1;

        for (Matricula m : matriculas) {

            System.out.println(i + " - "
                    + m.getAluno().getNome()
                    + " | "
                    + m.getDisciplina().getNome());

            i++;
        }

    }

    // =========================

    public void calcularMedia() {

        listarAlunos();

        System.out.print("Aluno: ");
        int id = sc.nextInt();

        sc.nextLine();

        double soma = 0;
        int qtd = 0;

        for (Matricula m : matriculas) {

            if (m.getAluno().getId() == id) {
                soma += m.getNota();
                qtd++;
            }

        }

        if (qtd == 0) {
            System.out.println("Aluno sem disciplinas.");
            return;
        }

        System.out.printf("Média: %.2f\n", soma / qtd);

    }

    // =========================

    public void listarBoletim() {

        listarAlunos();

        System.out.print("Aluno: ");
        int id = sc.nextInt();

        sc.nextLine();

        double soma = 0;
        int qtd = 0;

        System.out.println();

        for (Matricula m : matriculas) {

            if (m.getAluno().getId() == id) {

                System.out.println(
                        m.getDisciplina().getNome()
                        + " -> "
                        + m.getNota());

                soma += m.getNota();
                qtd++;

            }

        }

        if (qtd > 0) {

            System.out.printf("\nMédia Geral: %.2f\n", soma / qtd);

        }

    }


    public void salvarDados(){

        Arquivo.salvarAlunos(alunos);
        Arquivo.salvarDisciplinas(disciplinas);
        Arquivo.salvarMatriculas(matriculas);

    }


    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }


    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }


    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }


    public void carregarDados(){

        Arquivo.carregarAlunos(alunos);

        Arquivo.carregarDisciplinas(disciplinas);

        Arquivo.carregarMatriculas(
            matriculas, 
            alunos, 
            disciplinas);

        if (!alunos.isEmpty()) {
            proximoIdAluno = alunos.get(alunos.size() - 1).getId() + 1;
        }

        if (!disciplinas.isEmpty()) {
            proximoIdDisciplina = disciplinas.get(disciplinas.size() - 1).getId() + 1;
        }

    }
}