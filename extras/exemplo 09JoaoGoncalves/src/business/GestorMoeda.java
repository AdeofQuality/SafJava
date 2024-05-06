package business;

import java.sql.SQLException;
import java.util.List;

import persistance.DbWorker;

/**
 *
 * @author efapro01.23
 */
public class GestorMoeda {

    DbWorker worker;

    public GestorMoeda() throws SQLException {
        worker = new DbWorker();
    }

    public void depositar(String tipoMoeda, int quantidade, String token) {
        worker.depositar(tipoMoeda, quantidade, token);
    }

    public void levantar(String tipoMoeda, int quantidade, String token) {
        worker.levantar(tipoMoeda, quantidade, token);
    }

    public void modificarCambio(String tipoMoeda, double novoCambio) {
        worker.modificarCambio(tipoMoeda, novoCambio);
    }

    public double calcularTotal() {
        return worker.calcularTotal();
    }

    public double calcularPorMoeda(String tipoMoeda) {
        return worker.calcularPorMoeda(tipoMoeda);
    }

    public List<String> visaoGlobal() throws SQLException {
        return worker.visaoGlobal();
    }

    public void guardarToken(String tipoMoeda, String novoToken) {
        worker.guardarToken(tipoMoeda, novoToken);
    }

}
