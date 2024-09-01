public class MundoReal {

    public static void main(String[] args) {
        Carro golf = new Carro("BRA5K21", "Volkswagen Golf", "rosa", "9BWZZZ377VT004251", 2003);
        Carro corsa = new Carro("KGO3O20", "Corsa Sedan Joy", "violeta", "6ROOKG377VR004964", 2004);
        System.out.println("O corsa modelo " + corsa.modelo +  corsa.acelerar() + " e bateu no golf cor " + golf.cor + " que " + golf.freiar());

        System.out.println("");

        Aula poo = new Aula("POO", 2, "Antônio", 40, 104);
        Cachorro pincher = new Cachorro("Brutos", "pincher", 5, "preto", "Claudio");
        System.out.println("O cachorro do " + pincher.dono + " entrou na sala de aula de " + poo.diciplina + " e " + pincher.latir() + ", mas a sorte é que a aula " + poo.terminar());

        System.out.println("");

        System.out.println("O carro de placa " + corsa.placa + " quase atropelou o " + pincher.nome + " cachorro do " + pincher.dono + ", por quê ele " + pincher.farejar() + " e não viu, mas o moço do " + corsa.modelo + " viu a tempo e " + corsa.freiar());
    }
    
}
