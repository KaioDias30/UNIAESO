package edu.lista1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class questao18 {

    public static void main(String[] args) {

        String arquivoCSV = "alunos.csv";

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {

            int contadorLinha = 0;
            String[] linha;
            while ((linha = reader.readNext()) != null) {

                if(contadorLinha == 0) {
                    contadorLinha++;
                    continue;
                }
                System.out.println("Nome: " + linha[0] + ", Idade: " + linha[1] + ", Nota: " + linha[2]);
                contadorLinha++;
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}