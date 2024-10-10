package edu.nobreza;

public class Principe extends Nobre implements Cavaleiro {
    @Override
    public void governar() {
        System.out.println("O Príncipe está governando.");
    }

    @Override
    public void duelar() {
        System.out.println("O Príncipe está dueling.");
    }
}
