package edu.nobreza;

public class Conselheiro {
    private Soldado[] soldados;

    public Conselheiro(int numeroDeSoldados) {
        this.soldados = new Soldado[numeroDeSoldados];
    }

    public void adicionarSoldado(Soldado soldado, int index) {
        if (index < soldados.length) {
            soldados[index] = soldado;
        }
    }
}
