package edu.lista1;

import java.io.*;

public class questao5 {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_python.txt";

        try {
            FileReader arquivoReader = new FileReader(nomeArquivoEntrada);
            BufferedReader bufferedReader = new BufferedReader(arquivoReader);

            FileWriter arquivoWriter = new FileWriter(nomeArquivoSaida);
            BufferedWriter bufferedWriter = new BufferedWriter(arquivoWriter);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                linha = linha.replaceAll("Java", "Python");
                bufferedWriter.write(linha);
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();
            System.out.println("Substituição concluída. Resultado salvo em " + nomeArquivoSaida);
        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}