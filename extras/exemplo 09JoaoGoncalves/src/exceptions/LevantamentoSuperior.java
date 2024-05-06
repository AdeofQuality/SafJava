/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author efapro01.23
 */
public class LevantamentoSuperior extends Exception {

    /**
     * Creates a new instance of <code>LevantamentoSuperior</code> without
     * detail message.
     */
    public LevantamentoSuperior() {
    }

    /**
     * Constructs an instance of <code>LevantamentoSuperior</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LevantamentoSuperior(String msg) {
        super(msg);
    }
}
