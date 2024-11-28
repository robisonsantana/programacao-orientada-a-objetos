package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Usuario;
import persistence.UsuarioDao;
import persistence.UsuarioDaoImpl;
import tools.SystemException;

public class UsuarioControl {

    // Lista observável para armazenar os usuários e facilitar a ligação com a interface gráfica
    private ObservableList<Usuario> lista = FXCollections.observableArrayList();
    private long contador = 2; // Contador usado para gerar IDs fictícios de usuários

    // Propriedades observáveis usadas para ligação (binding) com os componentes da interface gráfica
    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty dataCadastro = new SimpleStringProperty("");

    // DAO para manipulação de dados de persistência
    private UsuarioDao usuarioDao = null;

    // Construtor que inicializa o DAO
    public UsuarioControl() throws SystemException {
        usuarioDao = new UsuarioDaoImpl(); // Implementação concreta do DAO
    }

    // Método que converte os dados das propriedades para um objeto Usuario
    public Usuario paraEntidade() {
        Usuario u = new Usuario();
        u.setId(id.get());
        u.setNome(nome.get());
        u.setTelefone(telefone.get());
        u.setEmail(email.get());
        u.setDataCadastro(dataCadastro.get());
        return u;
    }

    // Remove um usuário do banco de dados e atualiza a lista na interface
    public void excluir(Usuario u) throws SystemException {
        usuarioDao.remover(u); // Chama o DAO para remover o usuário
        pesquisarTodos(); // Atualiza a lista de usuários exibida
    }

    // Limpa todos os dados das propriedades observáveis
    public void limparTudo() {
        id.set(0);
        nome.set("");
        telefone.set("");
        email.set("");
        dataCadastro.set("");
    }

    // Preenche as propriedades observáveis com os dados de um objeto Usuario
    public void paraTela(Usuario u) {
        if (u != null) {
            id.set(u.getId());
            nome.set(u.getNome());
            telefone.set(u.getTelefone());
            email.set(u.getEmail());
            dataCadastro.set(u.getDataCadastro());
        }
    }

    // Grava ou atualiza um usuário no banco de dados
    public void gravar() throws SystemException {
        Usuario u = paraEntidade(); // Converte as propriedades observáveis para um objeto Usuario
        if (u.getId() == 0) { // Novo registro (ID == 0)
            this.contador += 1;
            u.setId(this.contador); // Gera um novo ID fictício
            usuarioDao.inserir(u); // Insere o usuário no banco
        } else { // Atualização de registro existente
            usuarioDao.atualizar(u); // Atualiza o registro no banco
        }
        pesquisarTodos(); // Atualiza a lista exibida
    }

    // Pesquisa usuários com base no nome preenchido na propriedade 'nome'
    public void pesquisar() throws SystemException {
        lista.clear(); // Limpa a lista atual
        lista.addAll(usuarioDao.pesquisarPorNome(nome.get())); // Adiciona os resultados à lista observável
    }

    // Lista todos os usuários disponíveis no banco de dados
    public void pesquisarTodos() throws SystemException {
        lista.clear(); // Limpa a lista atual
        lista.addAll(usuarioDao.pesquisarPorNome("")); // Adiciona todos os usuários ao preencher com nome vazio
    }

    // Métodos para acessar as propriedades observáveis

    public LongProperty idProperty() {
        return this.id;
    }

    public StringProperty nomeProperty() {
        return this.nome;
    }

    public StringProperty telefoneProperty() {
        return this.telefone;
    }

    public StringProperty emailProperty() {
        return this.email;
    }

    public StringProperty dataCadastroProperty() {
        return this.dataCadastro;
    }

    // Retorna a lista observável de usuários
    public ObservableList<Usuario> getLista() {
        return this.lista;
    }
}

