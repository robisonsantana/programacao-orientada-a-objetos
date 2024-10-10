public class Aeronave {
    private String modelo;
    private int capacidade;
    private String prefixo;

    public Aeronave(String modelo, int capacidade, String prefixo) {
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.prefixo = prefixo;
    }

    public void voar() {
        System.out.println("A aeronave " + modelo + " está voando.");
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
}
