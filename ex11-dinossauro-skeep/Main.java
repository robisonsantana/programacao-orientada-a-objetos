import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dinossauro skeep = new Dinossauro(); // Instância do Dinossauro
        Scanner scan = new Scanner(System.in); // Instância do Scanner

        while (true) {
            // Mostra o status do dinossauro
            skeep.mostrarStatus();

            // Mostra o menu de opções
            System.out.println("(P)ular     (C)orrer     Co(M)er");
            System.out.println("C(A)ntar    Tomar (S)ol  Ficar na S(O)mbra");
            System.out.print("Escolha uma opção: ");

            // Pega a opção do usuário
            String textoMaiusculo = scan.nextLine().toUpperCase();
            char letra = textoMaiusculo.charAt(0);

            // Executa o comportamento correspondente
            switch (letra) {
                case 'P':
                    skeep.pular();
                    break;
                case 'C':
                    skeep.correr();
                    break;
                case 'M':
                    skeep.comer();
                    break;
                case 'A':
                    skeep.cantar();
                    break;
                case 'S':
                    skeep.tomarSol();
                    break;
                case 'O':
                    skeep.ficarNaSombra();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            System.out.println();
        }
    }
}
