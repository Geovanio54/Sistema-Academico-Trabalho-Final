import java.io.*;
import java.util.ArrayList;

public class Arquivo {

    // ================= SALVAR ALUNOS =================

    public static void salvarAlunos(ArrayList<Aluno> alunos) {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("alunos.txt"));

            for (Aluno a : alunos) {

                bw.write(a.getId() + ";" + a.getNome());
                bw.newLine();

            }

            bw.close();

            System.out.println("Alunos salvos.");

        } catch (IOException e) {

            System.out.println("Erro ao salvar alunos: "+ e);

        }

    }

    // ================= SALVAR DISCIPLINAS =================

    public static void salvarDisciplinas(ArrayList<Disciplina> disciplinas) {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("disciplinas.txt"));

            for (Disciplina d : disciplinas) {

                bw.write(d.getId() + ";" + d.getNome());
                bw.newLine();

            }

            bw.close();

            System.out.println("Disciplinas salvas.");

        } catch (IOException e) {

            System.out.println("Erro ao salvar disciplinas: "+ e);

        }

    }

    // ================= SALVAR MATRÍCULAS =================

    public static void salvarMatriculas(ArrayList<Matricula> matriculas) {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("matriculas.txt"));

            for (Matricula m : matriculas) {

                bw.write(
                        m.getAluno().getId()
                                + ";"
                                + m.getDisciplina().getId()
                                + ";"
                                + m.getNota());

                bw.newLine();

            }

            bw.close();

            System.out.println("Matrículas salvas.");

        } catch (IOException e) {

            System.out.println("Erro ao salvar matrículas: "+ e);

        }

    }


    // ================= CARREGAR ALUNOS =================

    public static void carregarAlunos(ArrayList<Aluno> alunos) {

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("alunos.txt"));

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(";");

                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];

                alunos.add(new Aluno(id, nome));

            }

            br.close();

        } catch (IOException e) {

            System.out.println("Arquivo de alunos não encontrado: "+ e);

        }

    }

    // ================= CARREGAR DISCIPLINAS =================

    public static void carregarDisciplinas(ArrayList<Disciplina> disciplinas) {

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("disciplinas.txt"));

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(";");

                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];

                disciplinas.add(new Disciplina(id, nome));

            }

            br.close();

        } catch (IOException e) {

            System.out.println("Arquivo de disciplinas não encontrado: "+ e);

        }

    }


    // ================= CARREGAR MATRÍCULAS =================

    public static void carregarMatriculas(
            ArrayList<Matricula> matriculas,
            ArrayList<Aluno> alunos,
            ArrayList<Disciplina> disciplinas) {

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("matriculas.txt"));

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(";");

                int idAluno = Integer.parseInt(dados[0]);
                int idDisciplina = Integer.parseInt(dados[1]);
                double nota = Double.parseDouble(dados[2]);

                Aluno aluno = null;
                Disciplina disciplina = null;

                for (Aluno a : alunos) {

                    if (a.getId() == idAluno) {

                        aluno = a;
                        break;

                    }

                }

                for (Disciplina d : disciplinas) {

                    if (d.getId() == idDisciplina) {

                        disciplina = d;
                        break;

                    }

                }

                if (aluno != null && disciplina != null) {

                    Matricula m = new Matricula(aluno, disciplina);
                    m.setNota(nota);

                    matriculas.add(m);

                }

            }

            br.close();

        } catch (IOException e) {

            System.out.println("Arquivo de matrículas não encontrado: "+ e);

        }

    }

}