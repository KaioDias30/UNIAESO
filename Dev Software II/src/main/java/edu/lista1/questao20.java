package edu.lista1;

import edu.lista1.entidades.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class questao20 {
    public static void main(String[] args) {
        String csvFile = "produtos.csv";
        String line;
        String cvsSplitBy = ",";

        List<Produto> produtos = new ArrayList<>();

        int contadorLinha = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if(contadorLinha == 0) {
                    contadorLinha++;
                    continue;
                }

                String[] data = line.split(cvsSplitBy);
                String nome = data[0].trim();
                double preco = Double.parseDouble(data[1].trim());
                int quantidade = Integer.parseInt(data[2].trim());

                Produto produto = new Produto(nome, preco, quantidade);
                produtos.add(produto);
                contadorLinha++;
            }

            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
