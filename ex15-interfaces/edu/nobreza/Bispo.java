package edu.nobreza;

public class Bispo extends Padre implements Fiel {
    @Override
    public void rezar() {
        System.out.println("O Bispo está rezando.");
    }
}
