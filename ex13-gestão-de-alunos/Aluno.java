import java.util.Date;

public class Aluno {
    private long id;
    private Date nascimento;
    private String ra;
    private String nome;

    public Aluno() {
        
    }

    public Aluno(long id, Date nascimento, String ra, String nome) {
        this.id = id;
        this.nascimento = nascimento;
        this.ra = ra;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public String getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", RA: " + ra + ", Nascimento: " + nascimento;
    }
}
