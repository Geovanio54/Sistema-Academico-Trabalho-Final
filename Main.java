import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SistemaAcademico sistema = new SistemaAcademico();
        sistema.carregarDados();

        Scanner sc = new Scanner(System.in);

        int op;

        do {

            System.out.println("\n===== SISTEMA ACADÊMICO =====");

            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar disciplina");
            System.out.println("3 - Matricular aluno");
            System.out.println("4 - Lançar nota");
            System.out.println("5 - Calcular média");
            System.out.println("6 - Boletim");
            System.out.println("7 - Salvar Dados");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    sistema.cadastrarAluno();
                    break;

                case 2:
                    sistema.cadastrarDisciplina();
                    break;

                case 3:
                    sistema.matricularAluno();
                    break;

                case 4:
                    sistema.lancarNotas();
                    break;

                case 5:
                    sistema.calcularMedia();
                    break;

                case 6:
                    sistema.listarBoletim();
                    break;

                case 7:
                    sistema.salvarDados();
                    break;

            }

        } while (op != 0);

        sc.close();

    }

}