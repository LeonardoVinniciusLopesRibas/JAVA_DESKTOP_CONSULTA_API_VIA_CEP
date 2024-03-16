package com.mycompany.consultaapiviacep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsultaApiViaCep {

    public static void main(String[] args) {
        String cep = "85915222"; // CEP de exemplo

        try {
            // Construir a URL da consulta
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");

            // Fazer a solicitação HTTP
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Ler a resposta
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Processar a resposta
            System.out.println("Resposta da API do ViaCEP:");
            System.out.println(response.toString());

            // Tratar os dados JSON aqui...

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
