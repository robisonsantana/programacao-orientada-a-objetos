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

public class CursoBoundary extends Aplication {
    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtCodCurso = new TextField();
    private TextField txtNomeCood = new TextField();
    private TextField txtQtdAlunos = new TextField();
    private CursoControl control = new CursoControl();

    @Override
    public void start(Stage stage) {
        GridPane pane = new GridPane();
        ColumnConstraints col30 = new ColumnConstraints();
        col30.setPercentWidth(30.0);
        ColumnConstraints col70 = new ColumnConstraints();
        col70.setPercentWidth(70.0);
        pane.getColumnConstraints().addAll(col30, col70);

        RowConstraints row17 = new RowConstraints();
        row17.setPercentHeight(17.0);
        RowConstraints row15 = new RowConstraints();
        row15.setPercentHeight(15.0);
        pane.getRowConstranints().addAll(row17, row17, row17, row17, row17, row15);

        Scene scn = new Scene(pane, 600, 400);

        pane.add(new Label("ID: "), 0, 0);
        pane.add(txtId, 1, 0);
        pane.add(new Label("Nome: "), 0, 1);
        pane.add(txtNome, 1, 1);
        pane.add(new Label("Código Curso: "), 0, 2);
        pane.add(txtCodCurso, 1, 2);
        pane.add(new Label("Nome Coordenador: "), 0, 3);
        pane.add(txtNomeCood, 1, 3);
        pane.add(new Label("Quantidade de Alunos: "), 0, 4);
        pane.add(txtQtdAlunos, 1, 4);

        Button bntAdicionar = new Button("Adicionar");
        Button bntPesquisar = new Button("Pesquisar");
        bntAdicionar.setOnAction(e -> {
            Curso c = telaParaCurso();
            control.gravar(c);
            Alert alert = new Alert(AlertType.INFORMATION, "Curso adicionado com sucesso!");
            alert.showAndWait();
            txtId.setText("");
            txtNome.setText("");
            txtCodCurso.setText("");
            txtNomeCood.setText("");
            txtQtdAlunos.setText("");
        });
        bntPesquisar.setOnAction(e -> {
            Curso c = control.pesquisarPorNome(txt.getText());
            if(c == null) {
                Alert alert = new Alert(AlertType.WARNING, "Não há cursos com esse nome!");
                alert.showAndWait();
            } else {
                cursoParaTela(c);
            }
        });

        pane.add(bntPesquisar, 0, 5);
        pane.add(bntAdicionar, 1, 5);

        stage.setScene(scn);
        stage.setTitle("Manutenção de Cursos");
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(ContatoBoundary.class, args);
    }

    public Curso telaParaCurso() {
        Curso c = new Contato();
        c.setId(txtId.getText());
        c.setNome(txtNome.getText());
        c.setCodCurso(txtCodCurso.getText());
        c.setNomeCoord(txtNomeCood.getText());
        c.setQtdAlunos(txtQtdAlunos.getText());
        return c;
    }

    public void cursoParaTela(Curso c) {
        if(c != null) {
            txtId.setText(c.getId());
            txtNome.setText(c.getNome());
            txtCodCurso.setText(c.getCodCurso());
            txtNomeCood.setText(c.getNomeCoord());
            txtQtdAlunos.setText(c.getQtdAlunos());
        }
    }
}