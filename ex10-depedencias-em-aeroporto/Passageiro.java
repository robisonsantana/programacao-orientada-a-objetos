public class Passageiro extends Pessoa {
    private String bilhete;
    private String assento;
    private String classeVoo;

    public Passageiro(String nome, int idade, String documento, String bilhete, String assento, String classeVoo) {
        super(nome, idade, documento);
        this.bilhete = bilhete;
        this.assento = assento;
        this.classeVoo = classeVoo;
    }

    public void embarcar() {
        System.out.println(super.getNome() + " está embarcando no assento " + assento);
    }

    public String getBilhete() {
        return bilhete;
    }

    public void setBilhete(String bilhete) {
        this.bilhete = bilhete;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public String getClasseVoo() {
        return classeVoo;
    }

    public void setClasseVoo(String classeVoo) {
        this.classeVoo = classeVoo;
    }
}
