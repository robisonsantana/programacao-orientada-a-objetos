package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Vacina;
import persistence.VacinaDao;
import persistence.VacinaDaoImpl;
import tools.SystemException;

public class VacinaControl {

    // Lista observável para armazenar vacinas, usada para sincronizar com a interface gráfica
    private ObservableList<Vacina> lista = FXCollections.observableArrayList();
    private long contador = 2; // Contador usado para gerar IDs fictícios de vacinas

    // Propriedades observáveis usadas para ligação (binding) com componentes da interface gráfica
    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty fabricante = new SimpleStringProperty("");
    private StringProperty lote = new SimpleStringProperty("");
    private StringProperty validade = new SimpleStringProperty("");

    // DAO para manipulação de dados de persistência
    private VacinaDao vacinaDao = null;

    // Construtor que inicializa o DAO
    public VacinaControl() throws SystemException {
        vacinaDao = new VacinaDaoImpl(); // Implementação concreta do DAO
    }

    // Método que converte as propriedades observáveis em um objeto Vacina
    public Vacina paraEntidade() {
        Vacina v = new Vacina();
        v.setId(id.get());
        v.setNome(nome.get());
        v.setFabricante(fabricante.get());
        v.setLote(lote.get());
        v.setValidade(validade.get());
        return v;
    }

    // Remove uma vacina do banco de dados e atualiza a lista exibida
    public void excluir(Vacina v) throws SystemException {
        vacinaDao.remover(v); // Chama o DAO para remover a vacina
        pesquisarTodos(); // Atualiza a lista na interface
    }

    // Limpa os dados das propriedades observáveis, resetando os campos da interface
    public void limparTudo() {
        id.set(0);
        nome.set("");
        fabricante.set("");
        lote.set("");
        validade.set("");
    }

    // Preenche as propriedades observáveis com os dados de um objeto Vacina
    public void paraTela(Vacina v) {
        if (v != null) {
            id.set(v.getId());
            nome.set(v.getNome());
            fabricante.set(v.getFabricante());
            lote.set(v.getLote());
            validade.set(v.getValidade());
        }
    }

    // Grava ou atualiza uma vacina no banco de dados
    public void gravar() throws SystemException {
        Vacina v = paraEntidade(); // Converte as propriedades observáveis para um objeto Vacina
        if (v.getId() == 0) { // Novo registro (ID == 0)
            this.contador += 1;
            v.setId(this.contador); // Gera um novo ID fictício
            vacinaDao.inserir(v); // Insere a vacina no banco de dados
        } else { // Atualização de registro existente
            vacinaDao.atualizar(v); // Atualiza o registro no banco
        }
        pesquisarTodos(); // Atualiza a lista exibida na interface
    }

    // Pesquisa vacinas com base no nome preenchido na propriedade 'nome'
    public void pesquisar() throws SystemException {
        lista.clear(); // Limpa a lista atual
        lista.addAll(vacinaDao.pesquisarPorNome(nome.get())); // Adiciona os resultados à lista observável
    }

    // Lista todas as vacinas disponíveis no banco de dados
    public void pesquisarTodos() throws SystemException {
        lista.clear(); // Limpa a lista atual
        lista.addAll(vacinaDao.pesquisarPorNome("")); // Adiciona todas as vacinas ao preencher com nome vazio
    }

    // Métodos para acessar as propriedades observáveis

    public LongProperty idProperty() {
        return this.id;
    }

    public StringProperty nomeProperty() {
        return this.nome;
    }

    public StringProperty fabricanteProperty() {
        return this.fabricante;
    }

    public StringProperty loteProperty() {
        return this.lote;
    }

    public StringProperty validadeProperty() {
        return this.validade;
    }

    // Retorna a lista observável de vacinas
    public ObservableList<Vacina> getLista() {
        return this.lista;
    }
}


