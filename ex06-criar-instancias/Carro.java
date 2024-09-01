public class Carro {
    String placa;
    String modelo;
    String cor;
    String chassi;
    int ano;

    public Carro(String placaCarro, String modeloCarro, String corCarro, String chassiCarro, int anoCarro) {
        this.placa = placaCarro;
        this.modelo = modeloCarro;
        this.cor = corCarro;
        this.chassi = chassiCarro;
        this.ano = anoCarro;
    }
    
    public String ligar() {
        return "está ligando";
    }

    public String acelerar() {
        return " está acelerando";
    }

    public String freiar() {
        return "está freiando";
    }
}
