import java.util.ArrayList;
import java.util.List;

public class CursoControl {
    
    private List<Curso> lista = new ArrayList<>();

    public void gravar(Curso c) {
        lista.add(c);
    }

    public Curso pesquisarPorNome(String parteNome) {
        for(Curso c : lista) {
            if(c.getNome().contains(parteNome)) {
                return c;
            }
        }
        return null;
    }
}
