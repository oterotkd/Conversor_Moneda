/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api_conversor_2;

import java.util.Scanner;

public class MenuConversor {
    private Scanner scanner;
    private ConversorDeMoneda conversor;

    // Códigos de las monedas disponibles
    private static final String[] CODIGOS_MONEDAS = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

    public MenuConversor() {
        scanner = new Scanner(System.in);
        conversor = new ConversorDeMoneda();
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            mostrarOpciones();
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarConversion();
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarOpciones() {
        System.out.println("Bienvenido al Conversor de Monedas");
        System.out.println("1. Realizar Conversión");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void realizarConversion() {
        System.out.println("Seleccione la moneda de origen:");
        mostrarMonedas();
        int opcionOrigen = scanner.nextInt() - 1;
        if (opcionOrigen < 0 || opcionOrigen >= CODIGOS_MONEDAS.length) {
            System.out.println("Moneda no válida.");
            return;
        }
        Moneda origen = new Moneda(CODIGOS_MONEDAS[opcionOrigen]);

        System.out.println("Seleccione la moneda de destino:");
        mostrarMonedas();
        int opcionDestino = scanner.nextInt() - 1;
        if (opcionDestino < 0 || opcionDestino >= CODIGOS_MONEDAS.length) {
            System.out.println("Moneda no válida.");
            return;
        }
        Moneda destino = new Moneda(CODIGOS_MONEDAS[opcionDestino]);

        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        double resultado = conversor.convertir(origen, destino, cantidad);
        System.out.println(cantidad + " " + CODIGOS_MONEDAS[opcionOrigen] + " = " + resultado + " " + CODIGOS_MONEDAS[opcionDestino]);
    }

    private void mostrarMonedas() {
        for (int i = 0; i < CODIGOS_MONEDAS.length; i++) {
            System.out.println((i + 1) + ". " + CODIGOS_MONEDAS[i]);
        }
        System.out.print("Seleccione una opción: ");
    }
}
