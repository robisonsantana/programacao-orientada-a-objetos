package persistence;

import tools.SystemException;
import java.util.List;
import model.Vacina;

public interface VacinaDao {

    void inserir(Vacina v) throws SystemException;

    void atualizar(Vacina v) throws SystemException;

    void remover(Vacina v) throws SystemException;

    List<Vacina> pesquisarPorNome(String nome) throws SystemException;
}

