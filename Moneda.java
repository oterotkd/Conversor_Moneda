/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api_conversor_2;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class Moneda {
    private String codigo;

    public Moneda(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getTasaConversion(String codigoDestino) {
        // Llamada a la API para obtener la tasa de conversión entre esta moneda y la de destino
        try {
            String apiKey = "264d3f2af944efd7e6e49197";
            String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + this.codigo + "/" + codigoDestino;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(content.toString());
            return json.getDouble("conversion_rate");

        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de conversión: " + e.getMessage());
            return 0;
        }
    }
}
