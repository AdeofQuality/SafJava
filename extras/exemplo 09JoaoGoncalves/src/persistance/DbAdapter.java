package persistance;

import business.Moeda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author efapro01.23
 */
public class DbAdapter {

    String server = "62.28.39.135";
    String username = "Raquel";
    String password = "Silva1234";
    String dbname = "prod09goncalves";
    String url = "jdbc:mysql://" + server + ":3306/" + dbname;
    Connection connection = null;
    private Hashtable<String, Moeda> moedas = new Hashtable<>();

    public DbAdapter() throws SQLException
    {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void close() {

        try {
            if (connection != null)
            {
                connection.close();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void depositar(String tipoMoeda, int quantidade, String token) {
        String query = "UPDATE moeda SET numero_unidades = numero_unidades + ? WHERE identificador = ? AND token_seguranca = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, quantidade);
            preparedStatement.setString(2, tipoMoeda);
            preparedStatement.setString(3, token);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void levantar(String tipoMoeda, int quantidade, String token) {
        String query = "UPDATE moeda SET numero_unidades = numero_unidades - ? WHERE identificador = ? AND token_seguranca = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, quantidade);
            preparedStatement.setString(2, tipoMoeda);
            preparedStatement.setString(3, token);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarCambio(String tipoMoeda, double novoCambio) {
        String query = "UPDATE moeda SET valor_em_euros = ? WHERE identificador = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, novoCambio);
            preparedStatement.setString(2, tipoMoeda);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double calcularValorEmCarteira() {
        String query = "SELECT SUM(numero_unidades * valor_em_euros) AS total FROM moeda";
        double total = 0;

        try ( Statement statement = connection.createStatement();  ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                total = resultSet.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }

    public double calcularValorPorTipoMoeda(String tipoMoeda) {
        String query = "SELECT numero_unidades * valor_em_euros AS valor FROM moeda WHERE identificador = ?";
        double valor = 0;

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tipoMoeda);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    valor = resultSet.getDouble("valor");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return valor;
    }

    public List<String> visaoGlobalCarteira() throws SQLException {

        List<String> moedasLista = new ArrayList<>();

        String query = "SELECT identificador, nome, numero_unidades, valor_em_euros, numero_unidades * valor_em_euros AS valor_total FROM moeda";

        try ( Statement statement = connection.createStatement();  ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String identificador = resultSet.getString("identificador");
                String nome = resultSet.getString("nome");
                int numeroUnidades = resultSet.getInt("numero_unidades");
                double valorEmEuros = resultSet.getDouble("valor_em_euros");
                double valorTotal = resultSet.getDouble("valor_total");

                moedasLista.add("Moeda: " + nome + " (" + identificador + ") Quantidade: " + numeroUnidades + " Valor total: " + valorTotal + ",\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return moedasLista;
    }

    public void guardarTokenSeguranca(String tipoMoeda, String novoToken) {
        String query = "UPDATE moeda SET token_seguranca = ? WHERE identificador = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, novoToken);
            preparedStatement.setString(2, tipoMoeda);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
