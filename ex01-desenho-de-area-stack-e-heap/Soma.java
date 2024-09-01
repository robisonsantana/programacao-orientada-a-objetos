import java.util.Scanner;

public class Soma {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número\n-> ");
        double numero1 = Double.parseDouble(scanner.nextLine());
        System.out.print("Digite outro número\n-> ");
        double numero2 = Double.parseDouble(scanner.nextLine());
        System.out.println("A soma dos números é igual a: " + somar(numero1, numero2));
    }

    public static double somar(double numero1, double numero2) {
        return numero1 + numero2;
    }
}