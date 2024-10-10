public class Main {
    public static void main(String[] args) {
        Aeronave aeronave1 = new Aeronave("Boeing 737", 200, "PT-XYZ");
        Aeronave aeronave2 = new Aeronave("Airbus A320", 180, "PT-ABC");

        Piloto piloto1 = new Piloto("Carlos", 45, "123456789", "Licença A", 10000, "Jato");
        Piloto piloto2 = new Piloto("Ana", 38, "987654321", "Licença B", 8000, "Helicóptero");

        Passageiro passageiro1 = new Passageiro("Maria", 30, "111222333", "Bilhete001", "12A", "Econômica");
        Passageiro passageiro2 = new Passageiro("João", 35, "444555666", "Bilhete002", "14B", "Executiva");

        Aeroporto aeroporto1 = new Aeroporto("Aeroporto Internacional", "GRU", "São Paulo");
        Aeroporto aeroporto2 = new Aeroporto("Aeroporto Santos Dumont", "SDU", "Rio de Janeiro");

        aeroporto1.gerenciarVoo();
        piloto1.pilotar();
        passageiro1.embarcar();
        aeronave1.voar();

        aeroporto2.gerenciarVoo();
        piloto2.pilotar();
        passageiro2.embarcar();
        aeronave2.voar();
    }
}
