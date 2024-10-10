import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class AlunoBoundary() extends Application {

    private TextField txtId = new TextField();
    private TextField txtRa = new TextField();
    private TextField txtNome = new TextField();
    private TextFiel txtDtNasc = new TextField();
    private AlunoControl control = new AlunoControl();

    @Override
    public void start(Stage stage) {

        GrindPane pene = new GridPane();
        ColumnConstraints col30 = new ColumnConstraints();
        col30.setPercentWidth(30.0);
        ColumnConstraints col70 = new ColumnConstraints();
        col70.setPercentWidth(70.0);
        pane.getColumnConstraints().addAll(col30, col70);

        RowConstraints row20 = new RowConstraints();
        row20.setPercentHeight(20.0);
        pane.getRowConstranints(row20, row20, row20, row20, row20);

        Scene scn = new Scene(600, 400);

        pane.add(new Label("ID: "), 0, 0);
        pane.add(txtId, 1, 0);
        pane.add(new Label("RA: "), 0, 1);
        pane.add(txtRa, 1, 1);
        pane.add(new Label("Nome: "), 0, 2);
        pane.add(txtNome, 1, 2);
        pane.add(new Label("Data de Nascimento: "), 0, 3);
        pane.add(txtDtNasc, 1, 3);

        Button bntAdicionar = new Button("Adicionar");
        Button bntPesquisar = new Button("Pesquisar");
        bntAdicionar.setOnAction(e -> {
            Aluno a = boundaryToEntity();
            control.gravar(a);
            Alert alert = new AlertType(INFORMATION, "Aluno adicionado com sucesso!");
            alert.showAndWait();
            txtId.setText("");
            txtRa.setText("");
            txtNome.setText("");
            txtDtNasc.setText("");

        });
        bntPesquisar.setOnAction(e -> {
            Aluno a = control.pesquisarPorNome(txtNome.getText());
            if(a == null) {
                Alert alert = new AlertType(WARNING, "Aluno não encontrado!");
                alert.showAndWait();
            } else {
                entityToBoundary(a);
            }
        });

        pane.add(bntPesquisar, 0, 4);
        pane.add(bntAdicionar, 1, 4);

        stage.setScene(snc);
        stage.setTitle("Manutenção de Alunos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AlunoBoundary.class, args);
    }

    public Aluno boundaryToEntity() {
        Aluno a = new Aluno();
        a.setId(txtId.getText());
        a.setRa(txtRa.getText());
        a.setNome(txtNome.getText());
        a.setDtNasc(txtDtNasc.getText());
        return a;
    }

    public void entityToBoundary(Aluno a) {
        if(a != null) {
            txtId.setText(a.getId());
            txtRa.setText(a.getRa());
            txtNome.setText(a.getNome());
            txtDtNasc.setText(a.getDtNasc());
        }
    }

}