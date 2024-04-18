package edu.lista1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class questao4 {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";
        int contadorLinhas = 0;

        try {
            FileReader arquivoReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(arquivoReader);

            while (bufferedReader.readLine() != null) {
                contadorLinhas++;
            }

            bufferedReader.close();
            System.out.println("Número de linhas no arquivo: " + contadorLinhas);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}