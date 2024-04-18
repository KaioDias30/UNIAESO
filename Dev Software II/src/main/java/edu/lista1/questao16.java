package edu.lista1;

import java.io.*;

public class questao16 {
    public static void main(String[] args) {

        String nomeArquivo = "arquivo.bin";

        try (InputStream inputStream = new FileInputStream(nomeArquivo)) {
     
            byte[] buffer = new byte[100];

            int bytesLidos = inputStream.read(buffer);

            System.out.println("Primeiros 100 bytes do arquivo:");
            System.out.println(new String(buffer, 0, bytesLidos));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}