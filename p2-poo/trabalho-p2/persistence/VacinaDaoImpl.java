package persistence;

import tools.SystemException;
import model.Vacina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacinaDaoImpl implements VacinaDao {

    // Configurações de conexão com o banco de dados
    private final static String DB_CLASS = "org.mariadb.jdbc.Driver"; // Driver JDBC para o banco MariaDB
    private final static String DB_URL = "jdbc:mariadb://localhost:3306/usuariodb"; // URL de conexão ao banco
    private final static String DB_USER = "rob"; // Nome de usuário do banco de dados
    private final static String DB_PASS = "123456"; // Senha do banco de dados

    private Connection con = null; // Objeto de conexão com o banco

    // Construtor que inicializa a conexão com o banco de dados
    public VacinaDaoImpl() throws SystemException {
        try {
            // Carrega a classe do driver JDBC
            Class.forName(DB_CLASS);
            // Estabelece a conexão com o banco de dados
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException | SQLException e) {
            // Lança uma exceção personalizada se ocorrer um erro
            throw new SystemException(e);
        }
    }

    // Método para inserir uma nova vacina no banco de dados
    @Override
    public void inserir(Vacina v) throws SystemException {
        try {
            String SQL = """
                    INSERT INTO vacinas (id, nome, fabricante, lote, validade)
                    VALUES (?, ?, ?, ?, ?)
                    """;
            PreparedStatement stm = con.prepareStatement(SQL); // Prepara o comando SQL
            stm.setLong(1, v.getId()); // Define o ID da vacina
            stm.setString(2, v.getNome()); // Define o nome da vacina
            stm.setString(3, v.getFabricante()); // Define o fabricante
            stm.setString(4, v.getLote()); // Define o lote
            stm.setString(5, v.getValidade()); // Define a validade
            stm.executeUpdate(); // Executa o comando SQL
        } catch (SQLException e) {
            // Lança uma exceção personalizada se ocorrer um erro
            throw new SystemException(e);
        }
    }

    // Método para atualizar os dados de uma vacina existente
    @Override
    public void atualizar(Vacina v) throws SystemException {
        try {
            String SQL = """
                    UPDATE vacinas SET nome = ?, fabricante = ?, lote = ?, validade = ?
                    WHERE id = ?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL); // Prepara o comando SQL
            stm.setString(1, v.getNome()); // Atualiza o nome
            stm.setString(2, v.getFabricante()); // Atualiza o fabricante
            stm.setString(3, v.getLote()); // Atualiza o lote
            stm.setString(4, v.getValidade()); // Atualiza a validade
            stm.setLong(5, v.getId()); // Define o ID da vacina a ser atualizada
            stm.executeUpdate(); // Executa o comando SQL
        } catch (SQLException e) {
            // Lança uma exceção personalizada se ocorrer um erro
            throw new SystemException(e);
        }
    }

    // Método para remover uma vacina do banco de dados pelo ID
    @Override
    public void remover(Vacina v) throws SystemException {
        try {
            String SQL = """
                    DELETE FROM vacinas WHERE id = ?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL); // Prepara o comando SQL
            stm.setLong(1, v.getId()); // Define o ID da vacina a ser removida
            stm.executeUpdate(); // Executa o comando SQL
        } catch (SQLException e) {
            // Lança uma exceção personalizada se ocorrer um erro
            throw new SystemException(e);
        }
    }

    // Método para buscar vacinas pelo nome (com suporte a busca parcial)
    @Override
    public List<Vacina> pesquisarPorNome(String nome) throws SystemException {
        List<Vacina> lista = new ArrayList<>(); // Lista para armazenar os resultados da busca
        try {
            String SQL = """
                    SELECT * FROM vacinas WHERE nome LIKE ?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL); // Prepara o comando SQL
            stm.setString(1, "%" + nome + "%"); // Define o critério de busca
            ResultSet rs = stm.executeQuery(); // Executa a consulta SQL e obtém os resultados
            while (rs.next()) {
                // Cria um objeto Vacina para cada linha retornada
                Vacina v = new Vacina();
                v.setId(rs.getLong("id")); // Obtém o ID da vacina
                v.setNome(rs.getString("nome")); // Obtém o nome
                v.setFabricante(rs.getString("fabricante")); // Obtém o fabricante
                v.setLote(rs.getString("lote")); // Obtém o lote
                v.setValidade(rs.getString("validade")); // Obtém a validade

                lista.add(v); // Adiciona o objeto à lista de resultados
            }
        } catch (SQLException e) {
            // Lança uma exceção personalizada se ocorrer um erro
            throw new SystemException(e);
        }
        return lista; // Retorna a lista de vacinas encontradas
    }
}

