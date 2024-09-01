import java.util.ArrayList;
import java.util.List;

public class DeclaracaoVariaveis {

    public static void main(String[] args) {
        Empresa empresa = new Empresa("Itaú", 100000);
        System.out.println(empresa);

        Diciplina diciplina = new Diciplina(5.5, 7.8, 8.4);
        System.out.println(diciplina);

        MultaCarro multa = new MultaCarro("Jorge", "BRA5K21", "9BWZZZ377VT004251", "Volkswagen Golf", 2003, "rosa");
        System.out.println(multa);

        System.out.println("número de ouro: " + numeroDeOuro());

        List<Aluno> lista = new ArrayList<>();
        for(int i = 0; i < 11; i++) {
            lista.add(new Aluno("aluno" + i));
        }
        System.out.println(lista);

        Armario armario = new Armario(6);
        System.out.println(armario);
    }

    public static class Empresa {
        String nome;
        int totalQtdSalarios;
        private int qtdDiasFatureamento = 90;

        public Empresa(String nomeEmpresa, int totalQtdSalariosFuncionarios) {
            this.nome = nomeEmpresa;
            this.totalQtdSalarios = totalQtdSalariosFuncionarios;
        }

        public int getQtdFaturamento() {
            return qtdDiasFatureamento;
        }

        @Override
        public String toString() {
            return "nome: " + nome + "; total salários: " + totalQtdSalarios + "; dias faturamento: " + qtdDiasFatureamento;
        }
    }

    public static class Diciplina {
        double n1;
        double n2;
        double n3;

        public Diciplina(double nota1, double nota2, double nota3) {
            this.n1 = nota1;
            this.n2 = nota2;
            this.n3 = nota3;
        }
        
        @Override
        public String toString() {
            return "nota 1: " + n1 + "; nota 2: " + n2 + "; nota 3: " + n3;
        }
    }

    public static class MultaCarro {
        String nome;
        String placa;
        String chassi;
        String modelo;
        int ano;
        String cor;

        public MultaCarro( String nomeDono, String placaCarro, String chassiCarro, String modeloCarro, int anoCarro, String corCarro) {
            this.nome = nomeDono;
            this.placa = placaCarro;
            this.chassi = chassiCarro;
            this.modelo = modeloCarro;
            this.ano = anoCarro;
            this.cor = corCarro;
        }

        @Override
        public String toString() {
            return "nome: " + nome + "; placa: " + placa + "; chassi: " + chassi + "; modelo: " + modelo + "; ano: " + ano + "; cor: " + cor;
        }
    }

    public static double numeroDeOuro() {
        return (1 + Math.sqrt(5)) / 2;
    }

    public static class Aluno {
        String nome;

        public Aluno(String nomeAluno) {
            this.nome = nomeAluno;
        }

        public String toString() {
            return "nome: " + nome;
        }
    }

    public static class Armario {
        int pares;

        public Armario(int qtdPares) {
            this.pares = qtdPares;
        }

        public String toString() {
            return "quantidade de pares: " + pares;
        }
    }
}