import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GestaoFuncionarios {
    private int indice = 0;
    private Funcionario[] funcionarios = new Funcionario[50];
    private Scanner scan = new Scanner(System.in);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void criar() {
        if (indice >= 50) {
            System.out.println("Limite de funcionários atingido.");
            return;
        }
        System.out.println("Digite o ID do funcionário:");
        long id = scan.nextLong();
        scan.nextLine();

        System.out.println("Digite o nome do funcionário:");
        String nome = scan.nextLine();

        System.out.println("Digite a matrícula do funcionário:");
        String matricula = scan.nextLine();

        System.out.println("Digite a data de admissão do funcionário (yyyy-MM-dd):");
        String dataAdmissao = scan.nextLine();
        Date admissao = null;

        System.out.println("Digite a data de demissão do funcionário (yyyy-MM-dd):");
        String dataDemissao = scan.nextLine();
        Date demissao = null;

        try {
            admissao = dateFormat.parse(dataAdmissao);
            demissao = dateFormat.parse(dataDemissao);
        } catch (ParseException e) {
            System.out.println("Data inválida. Funcionário não criado.");
            return;
        }

        System.out.println("Digite o salário do funcionário:");
        float salario = scan.nextFloat();
        scan.nextLine();

        System.out.println("Digite o horário do funcionário:");
        String horario = scan.nextLine();

        funcionarios[indice] = new Funcionario(id, nome, matricula, admissao, demissao, salario, horario);
        indice++;
        System.out.println("Funcionário criado com sucesso!");
    }

    public void exibir() {
        System.out.println("Digite a matrícula do funcionário:");
        String matricula = scan.nextLine();
        boolean encontrado = false;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null && funcionario.getMatricula().equals(matricula)) {
                funcionario.exibir();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void excluir() {
        System.out.println("Digite a matrícula do funcionário para excluir:");
        String matricula = scan.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < indice; i++) {
            if (funcionarios[i] != null && funcionarios[i].getMatricula().equals(matricula)) {
                funcionarios[i] = null;
                encontrado = true;
                System.out.println("Funcionário excluído com sucesso!");
                for (int j = i; j < indice - 1; j++) {
                    funcionarios[j] = funcionarios[j + 1];
                }
                funcionarios[indice - 1] = null; // Limpar a última posição
                indice--;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void atualizar() {
        System.out.println("Digite a matrícula do funcionário para atualizar:");
        String matricula = scan.nextLine();
        boolean encontrado = false;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null && funcionario.getMatricula().equals(matricula)) {
                System.out.println("Digite o novo nome:");
                String nome = scan.nextLine();

                System.out.println("Digite a nova data de admissão (yyyy-MM-dd):");
                String dataAdmissao = scan.nextLine();
                Date admissao = null;

                System.out.println("Digite a nova data de demissão (yyyy-MM-dd):");
                String dataDemissao = scan.nextLine();
                Date demissao = null;

                try {
                    admissao = dateFormat.parse(dataAdmissao);
                    demissao = dateFormat.parse(dataDemissao);
                } catch (ParseException e) {
                    System.out.println("Data inválida. Atualização não realizada.");
                    return;
                }

                System.out.println("Digite o novo salário:");
                float salario = scan.nextFloat();
                scan.nextLine();

                System.out.println("Digite o novo horário:");
                String horario = scan.nextLine();

                funcionario.setNome(nome);
                funcionario.setAdmissao(admissao);
                funcionario.setDemissao(demissao);
                funcionario.setSalario(salario);
                funcionario.setHorario(horario);
                encontrado = true;
                System.out.println("Funcionário atualizado com sucesso!");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
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
        GestaoFuncionarios gestao = new GestaoFuncionarios();
        gestao.menu();
    }
}