import javafx.beans.binding.Bindings;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Vacina;
import tools.SystemException;
import controller.VacinaControl;

// Classe responsável pela interface gráfica do módulo de gerenciamento de vacinas
public class VacinaBoundary implements Tela {

    // Componentes visuais do formulário
    private Label lblId = new Label(""); // Exibe o ID da vacina
    private TextField txtNome = new TextField(); // Campo para o nome da vacina
    private TextField txtFabricante = new TextField(); // Campo para o fabricante
    private TextField txtLote = new TextField(); // Campo para o lote
    private TextField txtValidade = new TextField(); // Campo para a data de validade

    // Controlador que gerencia as operações do módulo
    private VacinaControl control = null;

    // Tabela para exibir as vacinas cadastradas
    private TableView<Vacina> tableView = new TableView<>();

    @Override
    public Pane render() {
        // Inicializa o controlador e trata possíveis erros
        try {
            control = new VacinaControl();
        } catch (SystemException e) {
            new Alert(AlertType.ERROR, "Erro ao iniciar o sistema", ButtonType.OK).showAndWait();
        }

        // Layout principal
        BorderPane panePrincipal = new BorderPane();

        // Layout do formulário
        GridPane paneForm = new GridPane();

        // Botão para gravar os dados da vacina
        Button btnGravar = new Button("Gravar");
        btnGravar.setOnAction(e -> {
            try {
                control.gravar(); // Chama o método gravar no controlador
            } catch (SystemException err) {
                new Alert(AlertType.ERROR, "Erro ao gravar a vacina", ButtonType.OK).showAndWait();
            }
            tableView.refresh(); // Atualiza a tabela após gravar
        });

        // Botão para pesquisar vacinas
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction(e -> {
            try {
                control.pesquisar(); // Chama o método pesquisar no controlador
            } catch (SystemException err) {
                new Alert(AlertType.ERROR, "Erro ao pesquisar vacinas", ButtonType.OK).showAndWait();
            }
        });

        // Botão para limpar os campos do formulário
        Button btnNovo = new Button("Limpar Tudo");
        btnNovo.setOnAction(e -> control.limparTudo());

        // Adiciona os componentes ao formulário
        paneForm.add(new Label("Nome: "), 0, 1);
        paneForm.add(txtNome, 1, 1);
        paneForm.add(new Label("Fabricante: "), 0, 2);
        paneForm.add(txtFabricante, 1, 2);
        paneForm.add(new Label("Lote: "), 0, 3);
        paneForm.add(txtLote, 1, 3);
        paneForm.add(new Label("Validade: "), 0, 4);
        paneForm.add(txtValidade, 1, 4);

        paneForm.add(btnGravar, 0, 5);
        paneForm.add(btnPesquisar, 1, 5);
        paneForm.add(btnNovo, 3, 5);

        // Ligações entre os campos e as propriedades do controlador
        ligacoes();

        // Configura as colunas da tabela
        gerarColunas();

        // Adiciona o formulário no topo e a tabela no centro do layout principal
        panePrincipal.setTop(paneForm);
        panePrincipal.setCenter(tableView);

        return panePrincipal; // Retorna o layout configurado
    }

    // Método para configurar as colunas da tabela
    public void gerarColunas() {
        TableColumn<Vacina, Long> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Vacina, String> col2 = new TableColumn<>("Nome");
        col2.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Vacina, String> col3 = new TableColumn<>("Fabricante");
        col3.setCellValueFactory(new PropertyValueFactory<>("fabricante"));

        TableColumn<Vacina, String> col4 = new TableColumn<>("Lote");
        col4.setCellValueFactory(new PropertyValueFactory<>("lote"));

        TableColumn<Vacina, String> col5 = new TableColumn<>("Validade");
        col5.setCellValueFactory(new PropertyValueFactory<>("validade"));

        // Coluna com botão para apagar a vacina
        TableColumn<Vacina, Void> col6 = new TableColumn<>("Ação");
        col6.setCellFactory(param -> new TableCell<>() {
            final Button btnApagar = new Button("Apagar");

            {
                // Define ação do botão de apagar
                btnApagar.setOnAction(e -> {
                    Vacina vacina = getTableView().getItems().get(getIndex());
                    try {
                        control.excluir(vacina); // Chama o método excluir no controlador
                    } catch (SystemException err) {
                        new Alert(AlertType.ERROR, "Erro ao excluir a vacina", ButtonType.OK).showAndWait();
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
        Bindings.bindBidirectional(control.fabricanteProperty(), txtFabricante.textProperty());
        Bindings.bindBidirectional(control.loteProperty(), txtLote.textProperty());
        Bindings.bindBidirectional(control.validadeProperty(), txtValidade.textProperty());
    }
}
