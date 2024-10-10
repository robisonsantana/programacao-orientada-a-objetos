import java.util.ArrayList;
import java.util.List;

public class AlunoControl {
    private List<Aluno> lista = new ArrayList<>();

    public void adicionar(Aluno a) {
        lista.add(a);
    }

    public Aluno pesquisarPorNome(String parteNome) {
        for(Aluno a : lista) {
            if(a.getNome().contains(parteNome)) {
                return a;
            }
        }
        return null;
    }
}
