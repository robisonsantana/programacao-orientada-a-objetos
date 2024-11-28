import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// Classe principal que define a interface gráfica do sistema
public class PrincipalBoundary extends Application {

    // Mapeamento de telas (identificador da tela -> instância de Tela)
    private Map<String, Tela> telas = new HashMap<>();

    @Override
    public void start(Stage stage) throws Exception {
        // Inicializa o mapa com as telas disponíveis
        telas.put("usuario", new UsuarioBoundary()); // Tela de gerenciamento de usuários
        telas.put("vacina", new VacinaBoundary()); // Tela de gerenciamento de vacinas

        // Painel principal do layout
        BorderPane panePrincipal = new BorderPane();

        // Barra de menu principal
        MenuBar menuBar = new MenuBar();

        // Menus superiores
        Menu mnuCadastro = new Menu("Cadastro"); // Menu para opções de cadastro
        Menu mnuAjuda = new Menu("Ajuda"); // Menu para opções de ajuda

        // Itens do menu "Cadastro"
        MenuItem mnuItemUsuario = new MenuItem("Usuário"); // Opção para acessar a tela de usuários
        mnuItemUsuario.setOnAction(e -> 
            panePrincipal.setCenter(telas.get("usuario").render()) // Define a tela de usuários no centro
        );

        MenuItem mnuItemVacina = new MenuItem("Vacina"); // Opção para acessar a tela de vacinas
        mnuItemVacina.setOnAction(e -> 
            panePrincipal.setCenter(telas.get("vacina").render()) // Define a tela de vacinas no centro
        );

        // Item do menu "Ajuda"
        MenuItem mnuItemCreditos = new MenuItem("Créditos"); // Opção para exibir créditos (sem ação definida)

        // Adiciona os itens ao menu "Cadastro"
        mnuCadastro.getItems().addAll(mnuItemUsuario, mnuItemVacina);

        // Adiciona o item ao menu "Ajuda"
        mnuAjuda.getItems().add(mnuItemCreditos);

        // Adiciona os menus à barra de menu
        menuBar.getMenus().addAll(mnuCadastro, mnuAjuda);

        // Configura a barra de menu na parte superior do layout principal
        panePrincipal.setTop(menuBar);

        // Criação da cena principal
        Scene scn = new Scene(panePrincipal, 800, 600); // Define o tamanho da janela inicial (800x600)
        stage.setScene(scn); // Configura a cena no palco
        stage.setTitle("Gerenciamento de Usuários e Vacinas"); // Define o título da janela
        stage.show(); // Exibe a janela principal
    }

    // Método principal para iniciar a aplicação
    public static void main(String[] args) {
        Application.launch(PrincipalBoundary.class, args); // Inicia a aplicação JavaFX
    }
}


