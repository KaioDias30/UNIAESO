package edu.lista1;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import edu.lista1.entidades.Venda;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class questao25 {
    private static final String ARQUIVO_CSV = "vendas.csv";

    public static void main(String[] args) {
        List<Venda> vendas = new ArrayList<>();


        vendas.addAll(lerVendasDoCSV());

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMENU:");
            System.out.println("1. Listar todas as vendas");
            System.out.println("2. Inserir nova venda e atualizar arquivo CSV");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarVendas(vendas);
                    break;
                case 2:
                    inserirNovaVenda(vendas);
                    exportarParaCSV(vendas);
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }

    private static List<Venda> lerVendasDoCSV() {
        List<Venda> vendas = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(ARQUIVO_CSV))) {
            String[] linha;
            reader.skip(1);
            while ((linha = reader.readNext()) != null) {
                vendas.add(new Venda(linha[0], Double.parseDouble(linha[1]), linha[2]));
            }
        } catch (IOException | NumberFormatException | CsvValidationException e) {
        }

        return vendas;
    }

    private static void listarVendas(List<Venda> vendas) {
        if (vendas.isEmpty()) {
            System.out.println("Não há vendas para listar.");
            return;
        }

        System.out.println("\nVENDAS:");
        for (Venda venda : vendas) {
            System.out.println("Data: " + venda.getData() + ", Valor: " + venda.getValor() + ", Produto: " + venda.getProduto());
        }
    }

    private static void inserirNovaVenda(List<Venda> vendas) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Data (AAAA-MM-DD): ");
        String data = scanner.nextLine();

        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Produto: ");
        String produto = scanner.nextLine();

        vendas.add(new Venda(data, valor, produto));
        System.out.println("Nova venda inserida com sucesso!");
    }

    private static void exportarParaCSV(List<Venda> vendas) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(ARQUIVO_CSV))) {

            writer.writeNext(new String[]{"Data", "Valor", "Produto"});


            for (Venda venda : vendas) {
                writer.writeNext(new String[]{venda.getData(), String.valueOf(venda.getValor()), venda.getProduto()});
            }

            System.out.println("Vendas exportadas com sucesso para " + ARQUIVO_CSV + "!");
        } catch (IOException e) {
            System.out.println("Erro ao exportar as vendas para o arquivo CSV: " + e.getMessage());
        }
    }
}
