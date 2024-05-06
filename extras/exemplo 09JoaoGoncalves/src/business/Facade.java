/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author efapro01.23
 */
public class Facade {

    GestorMoeda gm;

    public Facade() throws SQLException {
        gm = new GestorMoeda();
    }

    public void depositar(String tipoMoeda, int quantidade, String token) {
        gm.depositar(tipoMoeda, quantidade, token);
    }

    public void levantar(String tipoMoeda, int quantidade, String token) {
        gm.levantar(tipoMoeda, quantidade, token);
    }

    public void modificarCambio(String tipoMoeda, double novoCambio) {
        gm.modificarCambio(tipoMoeda, novoCambio);
    }

    public double calcularTotal() {
        return gm.calcularTotal();
    }

    public double calcularPorMoeda(String tipoMoeda) {
        return gm.calcularPorMoeda(tipoMoeda);
    }

    public List<String> visaoGlobal() throws SQLException {
        return gm.visaoGlobal();
    }

    public void guardarToken(String tipoMoeda, String novoToken) {
        gm.guardarToken(tipoMoeda, novoToken);
    }
}
