/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import exceptions.LevantamentoSuperior;
import exceptions.TokenInvalido;
import java.util.Objects;

/**
 *
 * @author efapro01.23
 */
public class Moeda {

    private String identificador;
    private String nome;
    private double valorEmEuros;
    private String tokenSeguranca;
    private int numeroUnidades;

    public Moeda(String identificador, String nome, double valorEmEuros, String tokenSeguranca, int numeroUnidades) {
        this.identificador = identificador;
        this.nome = nome;
        this.valorEmEuros = valorEmEuros;
        this.tokenSeguranca = tokenSeguranca;
        this.numeroUnidades = numeroUnidades;
    }

    public Moeda() {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorEmEuros() {
        return valorEmEuros;
    }

    public void setValorEmEuros(double valorEmEuros) {
        this.valorEmEuros = valorEmEuros;
    }

    public String getTokenSeguranca() {
        return tokenSeguranca;
    }

    public void setTokenSeguranca(String tokenSeguranca) throws TokenInvalido {
        if (tokenSeguranca == null ? tokenSeguranca != null : !tokenSeguranca.equals(tokenSeguranca)) {
            throw new TokenInvalido("Token Invalido");
        }
        this.tokenSeguranca = tokenSeguranca;
    }

    public int getNumeroUnidades() {

        return numeroUnidades;
    }

    public void setNumeroUnidades(int numeroUnidades) throws LevantamentoSuperior {
        if (numeroUnidades == 0) {
            throw new LevantamentoSuperior("Nao tem unidades para levantar");
        }
        if (numeroUnidades < 0) {
            throw new LevantamentoSuperior("Nao tem unidades para levantar");
        }
        this.numeroUnidades = numeroUnidades;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.identificador);
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.valorEmEuros) ^ (Double.doubleToLongBits(this.valorEmEuros) >>> 32));
        hash = 13 * hash + Objects.hashCode(this.tokenSeguranca);
        hash = 13 * hash + this.numeroUnidades;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Moeda other = (Moeda) obj;
        if (Double.doubleToLongBits(this.valorEmEuros) != Double.doubleToLongBits(other.valorEmEuros)) {
            return false;
        }
        if (this.numeroUnidades != other.numeroUnidades) {
            return false;
        }
        if (!Objects.equals(this.identificador, other.identificador)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.tokenSeguranca, other.tokenSeguranca);
    }

    @Override
    public String toString() {
        return "Moeda{" + "identificador=" + identificador + ", nome=" + nome + ", valorEmEuros=" + valorEmEuros + ", tokenSeguranca=" + tokenSeguranca + ", numeroUnidades=" + numeroUnidades + '}';
    }

}
