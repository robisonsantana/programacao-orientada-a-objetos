package persistence;

import tools.SystemException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

    // Configurações do banco de dados
    private final static String DB_CLASS = "org.mariadb.jdbc.Driver"; // Driver JDBC do MariaDB
    private final static String DB_URL = "jdbc:mariadb://localhost:3306/usuariodb"; // URL de conexão ao banco
    private final static String DB_USER = "rob"; // Usuário do banco de dados
    private final static String DB_PASS = "123456"; // Senha do banco de dados

    private Connection con = null; // Objeto de conexão com o banco de dados

    // Construtor que inicializa a conexão com o banco de dados
    public UsuarioDaoImpl() throws SystemException {
        try {
            // Carrega o driver JDBC
            Class.forName(DB_CLASS);
            // Estabelece a conexão com o banco de dados
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException | SQLException e) {
            // Lança uma exceção personalizada em caso de erro
            throw new SystemException(e);
        }
    }

    // Insere um novo usuário no banco de dados
    @Override
    public void inserir(Usuario u) throws SystemException {
        try {
            String SQL = """
                    INSERT INTO usuarios (id, nome, telefone, email, data_cadastro)
                    VALUES (?, ?, ?, ?, ?)
                    """;
            PreparedStatement stm = con.prepareStatement(SQL); // Prepara a instrução SQL
            stm.setLong(1, u.getId()); // Define o ID do usuário
            stm.setString(2, u.getNome()); // Define o nome do usuário
            stm.setString(3, u.getTelefone()); // Define o telefone
            stm.setString(4, u.getEmail()); // Define o email
            stm.setString(5, u.getDataCadastro()); // Define a data de cadastro
            stm.executeUpdate(); // Executa o comando SQL
        } catch (SQLException e) {
            // Lança uma exceção personalizada em caso de erro
            throw new SystemException(e);
        }
    }

    // Atualiza os dados de um usuário existente no banco de dados
    @Override
    public void atualizar(Usuario u) throws SystemException {
        try {
            String SQL = """
                    UPDATE usuarios SET nome = ?, telefone = ?, email = ?, data_cadastro = ?
                    WHERE id = ?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL); // Prepara a instrução SQL
            stm.setString(1, u.getNome()); // Atualiza o nome
            stm.setString(2, u.getTelefone()); // Atualiza o telefone
            stm.setString(3, u.getEmail()); // Atualiza o email
            stm.setString(4, u.getDataCadastro()); // Atualiza a data de cadastro
            stm.setLong(5, u.getId()); // Define o ID do usuário a ser atualizado
            stm.executeUpdate(); // Executa o comando SQL
        } catch (SQLException e) {
            // Lança uma exceção personalizada em caso de erro
            throw new SystemException(e);
        }
    }

    // Remove um usuário do banco de dados com base no ID
    @Override
    public void remover(Usuario u) throws SystemException {
        try {
            String SQL = """
                    DELETE FROM usuarios WHERE id = ?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL); // Prepara a instrução SQL
            stm.setLong(1, u.getId()); // Define o ID do usuário a ser removido
            stm.executeUpdate(); // Executa o comando SQL
        } catch (SQLException e) {
            // Lança uma exceção personalizada em caso de erro
            throw new SystemException(e);
        }
    }

    // Pesquisa usuários por nome (com suporte a busca parcial)
    @Override
    public List<Usuario> pesquisarPorNome(String nome) throws SystemException {
        List<Usuario> lista = new ArrayList<>(); // Lista para armazenar os resultados
        try {
            String SQL = """
                    SELECT * FROM usuarios WHERE nome LIKE ?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL); // Prepara a instrução SQL
            stm.setString(1, "%" + nome + "%"); // Define o critério de busca (nome parcial)
            ResultSet rs = stm.executeQuery(); // Executa a consulta e obtém os resultados
            while (rs.next()) {
                // Cria um objeto Usuario para cada linha retornada
                Usuario u = new Usuario();
                u.setId(rs.getLong("id")); // Obtém o ID
                u.setNome(rs.getString("nome")); // Obtém o nome
                u.setTelefone(rs.getString("telefone")); // Obtém o telefone
                u.setEmail(rs.getString("email")); // Obtém o email
                u.setDataCadastro(rs.getString("data_cadastro")); // Obtém a data de cadastro

                lista.add(u); // Adiciona o objeto à lista
            }
        } catch (SQLException e) {
            // Lança uma exceção personalizada em caso de erro
            throw new SystemException(e);
        }
        return lista; // Retorna a lista de usuários encontrados
    }
}



