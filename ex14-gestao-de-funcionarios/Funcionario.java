import java.util.Date;

public class Funcionario {
    private long id;
    private String nome;
    private String matricula;
    private Date admissao;
    private Date demissao;
    private float salario;
    private String horario;

    public Funcionario() {

    }

    public Funcionario(long id, String nome, String matricula, Date admissao, Date demissao, float salario, String horario) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.admissao = admissao;
        this.demissao = demissao;
        this.salario = salario;
        this.horario = horario;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public Date getAdmissao() {
        return admissao;
    }

    public Date getDemissao() {
        return demissao;
    }

    public float getSalario() {
        return salario;
    }

    public String getHorario() {
        return horario;
    }

    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Data de Admissão: " + admissao);
        System.out.println("Data de Demissão: " + demissao);
        System.out.println("Salário: " + salario);
        System.out.println("Horário: " + horario);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    public void setDemissao(Date demissao) {
        this.demissao = demissao;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
