/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import business.Facade;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author efapro01.23
 */
public class Start {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Facade facade = new Facade();

        int var = 0;
        do {

            // MENU
            System.out.println("======================================");
            System.out.println("\t\tMENU");
            System.out.println("""
                           1. Depositar
                           2. Levantar
                           3. Modificar Cambio
                           4. Calcular Total
                           5. Calcular valor por tipo de moeda
                           6. Listar Carteira
                           7. Alterar o token de uma moeda
                           8. OBS(FALTA FAZER)
                           0. Para sair do programa
                           """);
            System.out.println("======================================");

            // Pedir Operação
            try {
                System.out.println("\nIndique a Operação a Efetuar: ");
                var = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
            }

            switch (var) {
                case 1:
                    System.out.println("Indique a quantidade de moedas que quer depositar:");
                    int quantidadeDeposito = Integer.parseInt(scanner.nextLine());
                    System.out.println("Insira o identificador:");
                    String idDeposito = scanner.nextLine();
                    System.out.println("Insira o token:");
                    String tokenDeposito = scanner.nextLine();

                    facade.depositar(idDeposito, quantidadeDeposito, tokenDeposito);
                    break;
                case 2:
                    System.out.println("Indique a quantidade de moedas que quer levantar:");
                    int quantidadeLevantamento = Integer.parseInt(scanner.nextLine());
                    System.out.println("Insira o identificador:");
                    String idLevantamento = scanner.nextLine();
                    System.out.println("Insira o token:");
                    String tokenLevantamento = scanner.nextLine();

                    facade.levantar(idLevantamento, quantidadeLevantamento, tokenLevantamento);
                    System.out.println("Levantamento efetuado com sucesso!");

                    break;
                case 3:
                    System.out.println("Insira o identificador da moeda que pretende mudar o cambio:");
                    String idCambio = scanner.nextLine();
                    System.out.println("Introduza o valor pretendido");
                    double cambio = scanner.nextDouble();

                    facade.modificarCambio(idCambio, cambio);
                    break;
                case 4:
                    System.out.println("Total na Carteira:");
                    System.out.println(facade.calcularTotal());
                    break;
                case 5:
                    System.out.println("Introduza o identificador da moeda que quer ver:");
                    String idMoedaAverificar = scanner.nextLine();
                    System.out.println(facade.calcularPorMoeda(idMoedaAverificar));
                    break;
                case 6:
                    System.out.println(facade.visaoGlobal());
                    break;
                case 7:
                    System.out.println("Insira o identificador do token que gostaria de alterar:");
                    String idenficadorAmudar = scanner.nextLine();
                    System.out.println("Introduza um novo token para esta moeda:");
                    String tokenAmudar = scanner.nextLine();

                    facade.guardarToken(idenficadorAmudar, tokenAmudar);
                    break;
                case 8:
                    System.out.println("FALTA IMPLEMENTAR EXCEPTIONS:");
                    System.out.println("TOKEN E LEVANTAMENTO INVALIDO");
                    break;
                default:

            }

        } while (var != 0);

    }
}
