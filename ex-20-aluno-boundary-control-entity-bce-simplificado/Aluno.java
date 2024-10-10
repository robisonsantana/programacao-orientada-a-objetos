import java.util.Date;

public class Aluno {
    private String id;
    private String ra;
    private String nome;
    private Date dtNasc;  
    
    public String getId() {
        return this.id;
    }
    public void setId(String valor) {
        this.id = valor;
    }

    public String getRa() {
        return this.ra;
    }
    public void setRa(String valor) {
        this.ra = valor;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String valor) {
        this.nome = valor;
    }

    public Date getDtNasc() {
        return this.dtNasc;
    }
    public void setDtNasc(Date valor) {
        this.dtNasc = valor;
    }
}
