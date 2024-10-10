import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AgendaContatos extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Label lblId = new Label("Id:");
        Label lblNome = new Label("Nome:");
        Label lblTelefone = new Label("Telefone:");

        lblId.relocate(20, 20);
        lblNome.relocate(20, 60);
        lblTelefone.relocate(20, 100);

        TextField txtId = new TextField();
        TextField txtNome = new TextField();
        TextField txtTelefone = new TextField();

        txtId.relocate(80, 20);
        txtNome.relocate(80, 60);
        txtTelefone.relocate(80, 100);

        txtId.setPrefWidth(300);
        txtNome.setPrefWidth(300);
        txtTelefone.setPrefWidth(300);

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        btnSalvar.relocate(80, 150);
        btnPesquisar.relocate(150, 150);

        root.getChildren().addAll(lblId, lblNome, lblTelefone, txtId, txtNome, txtTelefone, btnSalvar, btnPesquisar);
        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("Agenda de Contatos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}