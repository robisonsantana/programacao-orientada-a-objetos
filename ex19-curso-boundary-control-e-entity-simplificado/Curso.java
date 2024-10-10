public class Curso {
    String id;
    String nome;
    String codCurso;
    String nomeCoord;
    String qtdAlunos;

    public String getNome() {
        return this.nome;
    }
    public void setNome(String valor) {
        this.nome = valor;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String valor) {
        this.id = valor;
    }

    public String getCodCurso() {
        return this.codCurso;
    }
    public void setCodCurso(String valor) {
        this.codCurso = valor;
    }

    public String getNomeCoord() {
        return this.nomeCoord;
    }
    public void setNomeCoord(String valor) {
        this.nomeCoord = valor;
    }

    public String getQtdAlunos() {
        return this.qtdAlunos;
    }
    public void setQtdAlunos(String valor) {
        this.qtdAlunos = valor;
    } 
}
