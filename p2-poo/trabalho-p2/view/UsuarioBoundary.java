import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import controller.UsuarioControl;
import model.Usuario;
import tools.SystemException;

// Classe responsável pela interface gráfica do módulo de usuários
public class UsuarioBoundary implements Tela {

    // Componentes visuais do formulário
    private Label lblId = new Label(""); // Exibe o ID do usuário
    private TextField txtNome = new TextField(); // Campo para o nome do usuário
    private TextField txtEmail = new TextField(); // Campo para o email
    private TextField txtTelefone = new TextField(); // Campo para o telefone
    private TextField txtDataCadastro = new TextField(); // Campo para a data de cadastro

    // Controlador que gerencia as operações do módulo
    private UsuarioControl control = null;

    // Tabela para exibir os usuários cadastrados
    private TableView<Usuario> tableView = new TableView<>();

    @Override
    public Pane render() {
        // Inicialização do controlador e tratamento de exceções
        try {
            control = new UsuarioControl();
        } catch (SystemException e) {
            new Alert(AlertType.ERROR, "Erro ao iniciar o sistema", ButtonType.OK).showAndWait();
        }

        // Layout principal
        BorderPane panePrincipal = new BorderPane();

        // Layout do formulário
        GridPane paneForm = new GridPane();

        // Botão para gravar os dados do usuário
        Button btnGravar = new Button("Gravar");
        btnGravar.setOnAction(e -> {
            try {
                control.gravar(); // Chama o método gravar no controlador
            } catch (SystemException err) {
                new Alert(AlertType.ERROR, "Erro ao gravar o usuário", ButtonType.OK).showAndWait();
            }
            tableView.refresh(); // Atualiza a tabela após gravar
        });

        // Botão para pesquisar usuários
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction(e -> {
            try {
                control.pesquisar(); // Chama o método pesquisar no controlador
            } catch (SystemException err) {
                new Alert(AlertType.ERROR, "Erro ao pesquisar por nome", ButtonType.OK).showAndWait();
            }
        });

        // Botão para limpar os campos do formulário
        Button btnNovo = new Button("Limpar Tudo");
        btnNovo.setOnAction(e -> control.limparTudo());

        // Adicionando os componentes ao formulário
        // paneForm.add(new Label("Id: "), 0, 0);
        // paneForm.add(lblId, 1, 0);
        paneForm.add(new Label("Nome: "), 0, 1);
        paneForm.add(txtNome, 1, 1);
        paneForm.add(new Label("Email: "), 0, 2);
        paneForm.add(txtEmail, 1, 2);
        paneForm.add(new Label("Telefone: "), 0, 3);
        paneForm.add(txtTelefone, 1, 3);
        paneForm.add(new Label("Data Cadastro: "), 0, 4);
        paneForm.add(txtDataCadastro, 1, 4);
        paneForm.add(btnGravar, 0, 5);
        paneForm.add(btnPesquisar, 1, 5);
        paneForm.add(btnNovo, 3, 5);

        // Configurações adicionais
        ligacoes(); // Liga os campos aos atributos do controlador
        gerarColunas(); // Configura as colunas da tabela

        // Adiciona o formulário no topo e a tabela no centro do layout principal
        panePrincipal.setTop(paneForm);
        panePrincipal.setCenter(tableView);

        return panePrincipal; // Retorna o layout configurado
    }

    // Método para configurar as colunas da tabela
    public void gerarColunas() {
        TableColumn<Usuario, Long> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Usuario, String> col2 = new TableColumn<>("Nome");
        col2.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Usuario, String> col3 = new TableColumn<>("Email");
        col3.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Usuario, String> col4 = new TableColumn<>("Telefone");
        col4.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        TableColumn<Usuario, String> col5 = new TableColumn<>("Data Cadastro");
        col5.setCellValueFactory(new PropertyValueFactory<>("dataCadastro"));

        // Coluna com botão para apagar o usuário
        TableColumn<Usuario, Void> col6 = new TableColumn<>("Ação");
        col6.setCellFactory(param -> new TableCell<>() {
            final Button btnApagar = new Button("Apagar");

            {
                // Define ação do botão de apagar
                btnApagar.setOnAction(e -> {
                    Usuario usuario = getTableView().getItems().get(getIndex());
                    try {
                        control.excluir(usuario); // Chama o método excluir no controlador
                    } catch (SystemException err) {
                        new Alert(AlertType.ERROR, "Erro ao excluir o usuário", ButtonType.OK).showAndWait();
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                if (empty) {
                    setGraphic(null); // Não exibe botão em linhas vazias
                } else {
                    setGraphic(btnApagar); // Exibe botão nas linhas preenchidas
                }
            }
        });

        // Adiciona todas as colunas à tabela
        tableView.getColumns().addAll(col1, col2, col3, col4, col5, col6);

        // Configura os dados da tabela com a lista do controlador
        tableView.setItems(control.getLista());
    }

    // Método para ligar os campos da interface às propriedades do controlador
    public void ligacoes() {
        control.idProperty().addListener((obs, antigo, novo) -> 
            lblId.setText(String.valueOf(novo)) // Atualiza o ID exibido no rótulo
        );
        Bindings.bindBidirectional(control.nomeProperty(), txtNome.textProperty());
        Bindings.bindBidirectional(control.emailProperty(), txtEmail.textProperty());
        Bindings.bindBidirectional(control.telefoneProperty(), txtTelefone.textProperty());
        Bindings.bindBidirectional(control.dataCadastroProperty(), txtDataCadastro.textProperty());
    }
}

