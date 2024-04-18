package edu.lista1;

import java.io.*;

public class questao15{
    public static void main(String[] args) {
 
        String arquivoEntrada = "arquivo_grande.bin";
        String arquivoSaida = "copia_arquivo_grande.bin";

        int tamanhoBuffer = 8192; 

        try (InputStream inputStream = new FileInputStream(arquivoEntrada);
             OutputStream outputStream = new FileOutputStream(arquivoSaida)) {

            byte[] buffer = new byte[tamanhoBuffer];
            int bytesLidos;
            while ((bytesLidos = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesLidos);
            }

            System.out.println("Arquivo copiado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
