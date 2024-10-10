import java.util.Scanner;

public class Dinossauro {
    private int energia;
    private int velocidade;
    private int temperatura;
    private String humor;

    public Dinossauro() {
        this.energia = 100;
        this.velocidade = 50;
        this.temperatura = 30;
        this.humor = "Feliz";
    }

    public void mostrarStatus() {
        System.out.println("Energia: " + energia);
        System.out.println("Velocidade: " + velocidade);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Humor: " + humor);
        System.out.println("----------------------------");
    }

    public void pular() {
        if (energia >= 10 && velocidade >= 5) {
            energia -= 10;
            velocidade -= 5;
            humor = "Feliz";
            System.out.println("O dinossauro pulou!");
        } else {
            System.out.println("O dinossauro está cansado ou muito lento para pular.");
        }
    }

    public void correr() {
        if (energia >= 15 && velocidade >= 10) {
            energia -= 15;
            velocidade -= 10;
            humor = "Feliz";
            System.out.println("O dinossauro correu!");
        } else {
            System.out.println("O dinossauro está cansado ou muito lento para correr.");
        }
    }

    public void comer() {
        energia += 20;
        if (energia > 100) energia = 100;
        velocidade -= 5;
        humor = "Feliz";
        System.out.println("O dinossauro comeu e está mais energizado!");
    }

    public void cantar() {
        if (energia >= 5) {
            energia -= 5;
            humor = "Feliz";
            System.out.println("O dinossauro cantou!");
        } else {
            System.out.println("O dinossauro está cansado para cantar.");
        }
    }

    public void tomarSol() {
        velocidade += 10;
        if (velocidade > 100) velocidade = 100;
        temperatura += 5;
        humor = "Feliz";
        System.out.println("O dinossauro tomou sol e está mais rápido e aquecido!");
    }

    public void ficarNaSombra() {
        energia += 10;
        if (energia > 100) energia = 100;
        temperatura -= 5;
        humor = "Triste";
        System.out.println("O dinossauro ficou na sombra e está mais descansado, mas está triste.");
    }
}
