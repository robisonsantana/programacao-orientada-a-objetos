public class Cachorro {
    String nome;
    String raca;
    int idade;
    String cor;
    String dono;

    public Cachorro(String nomeCachorro, String racaCachorro, int idadeCachorro, String corCachorro, String donoCachorro) {
        this.nome = nomeCachorro;
        this.raca = racaCachorro;
        this.idade = idadeCachorro;
        this.cor = corCachorro;
        this.dono = donoCachorro;
    }

    public String latir() {
        return "está latindo";
    }

    public String comer() {
        return "está comendo";
    }

    public String farejar() {
        return "está farejando";
    }
}
