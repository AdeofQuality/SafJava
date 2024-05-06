/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistance;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author efapro01.23
 */
public class DbWorker {

    DbAdapter dba = new DbAdapter();

    public DbWorker() throws SQLException {
        DbAdapter dba = new DbAdapter();
    }

    public void depositar(String tipoMoeda, int quantidade, String token) {
        dba.depositar(tipoMoeda, quantidade, token);
    }

    public void levantar(String tipoMoeda, int quantidade, String token) {
        dba.levantar(tipoMoeda, quantidade, token);
    }

    public void modificarCambio(String tipoMoeda, double novoCambio) {
        dba.modificarCambio(tipoMoeda, novoCambio);
    }

    public double calcularTotal() {
        return dba.calcularValorEmCarteira();
    }

    public double calcularPorMoeda(String tipoMoeda) {
        return dba.calcularValorPorTipoMoeda(tipoMoeda);
    }

    public List<String> visaoGlobal() throws SQLException {
        return dba.visaoGlobalCarteira();
    }

    public void guardarToken(String tipoMoeda, String novoToken) {
        dba.guardarTokenSeguranca(tipoMoeda, novoToken);
    }
}
