package edu.lista1;

import edu.lista1.entidades.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class questao21 {
    public static void main(String[] args) {
        String csvFile = "produtos.csv";
        String line;
        String cvsSplitBy = ",";

        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int contadorLinha = 0;
            while ((line = br.readLine()) != null) {
                if (contadorLinha == 0) {
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

            mostrarProdutos(produtos);

            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir novo produto");
            System.out.println("2. Sair");

            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();

            if (escolha == 1) {
                inserirNovoProduto(produtos);
                salvarParaCSV(produtos, csvFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarProdutos(List<Produto> produtos) {
        System.out.println("Produtos existentes:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private static void inserirNovoProduto(List<Produto> produtos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do novo produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do novo produto:");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade do novo produto:");
        int quantidade = scanner.nextInt();
        Produto novoProduto = new Produto(nome, preco, quantidade);
        produtos.add(novoProduto);
        System.out.println("Novo produto adicionado com sucesso:");
        System.out.println(novoProduto);
    }

    private static void salvarParaCSV(List<Produto> produtos, String arquivoCSV) {
        try (FileWriter writer = new FileWriter(arquivoCSV)) {
            writer.append("Nome,Preco,Quantidade\n");
            for (Produto produto : produtos) {
                writer.append(produto.getNome()).append(",");
                writer.append(String.valueOf(produto.getPreco())).append(",");
                writer.append(String.valueOf(produto.getQuantidade())).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
