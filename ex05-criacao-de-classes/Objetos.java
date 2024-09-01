public class Objetos {

    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.ligar();
        carro.acelerar();
        carro.freiar();

        System.out.println("");

        Cachorro doguinho = new Cachorro();
        doguinho.latir();
        doguinho.comer();
        doguinho.farejar();

        System.out.println("");

        Aula aula = new Aula();
        aula.comecar();
        aula.processo();
        aula.terminar();
    }

    public static class Carro {
        String placa;
        String modelo;
        String cor;
        String chassi;
        int ano;
        
        public void ligar() {
            System.out.println("O carro está ligando...");
        }

        public void acelerar() {
            System.out.println("O carro está acelerando...");
        }

        public void freiar() {
            System.out.println("O carro está freiando...");
        }
    }

    public static class Cachorro {
        String nome;
        String raca;
        int idade;
        String cor;
        String dono;

        public void latir() {
            System.out.println("O cachorro está latindo...");
        }

        public void comer() {
            System.out.println("O cachorro está comendo...");
        }

        public void farejar() {
            System.out.println("O cachorro está farejando...");
        }
    }

    public static class Aula {
        String diciplina;
        int duracao;
        String professor;
        int qtdAlunos;
        int sala;

        public void comecar() {
            System.out.println("A aula está começando...");
        }

        public void processo() {
            System.out.println("A aula está sendo dada...");
        }

        public void terminar() {
            System.out.println("A aula terminou.");
        }
    }
}