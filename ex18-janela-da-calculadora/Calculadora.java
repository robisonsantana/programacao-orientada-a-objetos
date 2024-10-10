import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField display = new TextField();
        display.setEditable(false);
        display.setPrefSize(200, 40);
        
        Button btnClear = new Button("CE");
        btnClear.setPrefSize(50, 40);

        Button[] buttons = new Button[16];
        String[] buttonLabels = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                ".", "0", "=", "/"
        };

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(buttonLabels[i]);
            buttons[i].setPrefSize(50, 50);
        }

        HBox displayBox = new HBox(10, display, btnClear);
        displayBox.setAlignment(Pos.CENTER);
        displayBox.setPadding(new Insets(10));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        int row = 0;
        int col = 0;
        for (int i = 0; i < buttons.length; i++) {
            gridPane.add(buttons[i], col, row);
            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        VBox root = new VBox(10, displayBox, gridPane);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 250, 350);
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
