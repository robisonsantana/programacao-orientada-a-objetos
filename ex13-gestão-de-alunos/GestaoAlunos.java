import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GestaoAlunos {
    private int indice = 0;
    private Aluno[] alunos = new Aluno[50];
    private Scanner scan = new Scanner(System.in);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void criar() {
        if (indice >= 50) {
            System.out.println("Limite de alunos atingido.");
            return;
        }
        System.out.println("Digite o ID do aluno:");
        long id = scan.nextLong();
        scan.nextLine();

        System.out.println("Digite o nome do aluno:");
        String nome = scan.nextLine();

        System.out.println("Digite o RA do aluno:");
        String ra = scan.nextLine();

        System.out.println("Digite a data de nascimento do aluno (yyyy-MM-dd):");
        String dataNascimento = scan.nextLine();
        Date nascimento = null;

        try {
            nascimento = dateFormat.parse(dataNascimento);
        } catch (ParseException e) {
            System.out.println("Data inválida. Aluno não criado.");
            return;
        }

        alunos[indice] = new Aluno(id, nascimento, ra, nome);
        indice++;
        System.out.println("Aluno criado com sucesso!");
    }

    public void exibir() {
        System.out.println("Digite o RA do aluno:");
        String ra = scan.nextLine();
        for (Aluno aluno : alunos) {
            if (aluno != null && aluno.getRa().equals(ra)) {
                System.out.println(aluno);
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    public void excluir() {
        System.out.println("Digite o RA do aluno para excluir:");
        String ra = scan.nextLine();
        for (int i = 0; i < indice; i++) {
            if (alunos[i] != null && alunos[i].getRa().equals(ra)) {
                alunos[i] = null;
                System.out.println("Aluno excluído com sucesso!");
                for (int j = i; j < indice - 1; j++) {
                    alunos[j] = alunos[j + 1];
                }
                alunos[indice - 1] = null;
                indice--;
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    public void atualizar() {
        System.out.println("Digite o RA do aluno para atualizar:");
        String ra = scan.nextLine();
        for (Aluno aluno : alunos) {
            if (aluno != null && aluno.getRa().equals(ra)) {
                System.out.println("Digite o novo nome:");
                String nome = scan.nextLine();

                System.out.println("Digite a nova data de nascimento (yyyy-MM-dd):");
                String dataNascimento = scan.nextLine();
                Date nascimento = null;

                try {
                    nascimento = dateFormat.parse(dataNascimento);
                } catch (ParseException e) {
                    System.out.println("Data inválida. Atualização não realizada.");
                    return;
                }

                aluno.setNome(nome);
                aluno.setNascimento(nascimento);
                System.out.println("Aluno atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    public void menu() {
        while (true) {
            System.out.println("(C)riar  (E)xibir  (R)emover  (A)tualizar  (S)air");
            String textoMaiusculo = scan.nextLine().toUpperCase();
            char letra = textoMaiusculo.charAt(0);

            switch (letra) {
                case 'C':
                    criar();
                    break;
                case 'E':
                    exibir();
                    break;
                case 'R':
                    excluir();
                    break;
                case 'A':
                    atualizar();
                    break;
                case 'S':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();
        gestao.menu();
    }
}