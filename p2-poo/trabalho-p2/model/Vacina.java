package model;

public class Vacina {

    private long id = 0;
    private String nome = "";
    private String fabricante = "";
    private String lote = "";
    private String validade = ""; // Armazenando como String para substituir LocalDate

    public Vacina() {
    }

    public Vacina(long id, String nome, String fabricante, String lote, String validade) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.lote = lote;
        this.validade = validade;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getLote() {
        return lote;
    }
    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getValidade() {
        return validade;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }
}

