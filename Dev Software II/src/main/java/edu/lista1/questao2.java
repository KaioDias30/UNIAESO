package edu.lista1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class questao2 {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";

        try {
            FileReader arquivoReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(arquivoReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}