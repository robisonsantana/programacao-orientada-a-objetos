import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgendaDeContatos extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label labelId = new Label("Id:");
        TextField textId = new TextField();
        
        Label labelNome = new Label("Nome:");
        TextField textNome = new TextField();
        
        Label labelTelefone = new Label("Telefone:");
        TextField textTelefone = new TextField();
        
        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        GridPane gridPane = new GridPane();
        
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        gridPane.add(labelId, 0, 0);
        gridPane.add(textId, 1, 0);
        
        gridPane.add(labelNome, 0, 1);
        gridPane.add(textNome, 1, 1);
        
        gridPane.add(labelTelefone, 0, 2);
        gridPane.add(textTelefone, 1, 2);
        
        gridPane.add(btnSalvar, 0, 3);
        gridPane.add(btnPesquisar, 1, 3);
        
        Scene scene = new Scene(gridPane, 400, 200);
        
        primaryStage.setTitle("Agenda de Contatos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
