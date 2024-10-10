public class Aeroporto {
    private String nome;
    private String codigo;
    private String localizacao;

    public Aeroporto(String nome, String codigo, String localizacao) {
        this.nome = nome;
        this.codigo = codigo;
        this.localizacao = localizacao;
    }

    public void gerenciarVoo() {
        System.out.println("O aeroporto " + nome + " está gerenciando um voo.");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
