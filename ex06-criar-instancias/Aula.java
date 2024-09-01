public class Aula {
    String diciplina;
    int duracao;
    String professor;
    int qtdAlunos;
    int sala;

    public Aula(String diciplinaAula, int duracaoAula, String professorAula, int qtdAlunosAula, int salaAula) {
        this.diciplina = diciplinaAula;
        this.duracao = duracaoAula;
        this.professor = professorAula;
        this.qtdAlunos = qtdAlunosAula;
        this.sala = salaAula;
    }

    public String comecar() {
        return "está começando";
    }

    public String processo() {
        return "está sendo";
    }

    public String terminar() {
        return "terminou";
    }
}
