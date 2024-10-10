package edu.nobreza;

public class Rainha extends Nobre implements Diplomata {
    @Override
    public void governar() {
        System.out.println("A Rainha está governando.");
    }

    @Override
    public void fazerDiplomacia() {
        System.out.println("A Rainha está fazendo diplomacia.");
    }
}
