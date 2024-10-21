/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api_conversor_2;


public class ConversorDeMoneda {
    public double convertir(Moneda origen, Moneda destino, double cantidad) {
        double tasaConversion = origen.getTasaConversion(destino.getCodigo());
        return cantidad * tasaConversion;
    }
}
