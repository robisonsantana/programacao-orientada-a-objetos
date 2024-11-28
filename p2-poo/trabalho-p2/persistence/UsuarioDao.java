package persistence;

import tools.SystemException;
import java.util.List;
import model.Usuario;

public interface UsuarioDao {

    void inserir(Usuario u) throws SystemException;

    void atualizar(Usuario u) throws SystemException;

    void remover(Usuario u) throws SystemException;

    List<Usuario> pesquisarPorNome(String nome) throws SystemException;
}

