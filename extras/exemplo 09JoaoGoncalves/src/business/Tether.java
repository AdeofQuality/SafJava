/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author efapro01.23
 */
public class Tether extends Moeda {

    private double fatorEstabilizacao = 0.85;

    public Tether(String identificador, String nome, double valorEmEuros, String tokenSeguranca, int numeroUnidades, double fatorEstabilizacao) {
        super(identificador, nome, valorEmEuros, tokenSeguranca, numeroUnidades);
        this.fatorEstabilizacao = fatorEstabilizacao;
    }

    public double getFatorEstabilizacao() {
        return fatorEstabilizacao;
    }

    public void setFatorEstabilizacao(double fatorEstabilizacao) {
        this.fatorEstabilizacao = fatorEstabilizacao;
    }

}
