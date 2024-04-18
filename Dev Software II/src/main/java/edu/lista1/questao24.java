package edu.lista1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class questao24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String filePath = "funcionarios.csv";

        List<String[]> funcionarios = lerArquivoCSV(filePath);

        if (funcionarios != null) {
            System.out.println("Filtrar por:");
            System.out.println("1. Cargo");
            System.out.println("2. Salário mínimo");
            System.out.print("Escolha a opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o cargo: ");
                    String cargo = scanner.nextLine();
                    filtrarPorCargo(funcionarios, cargo);
                    break;
                case 2:
                    System.out.print("Digite o salário mínimo: ");
                    double salarioMinimo = scanner.nextDouble();
                    filtrarPorSalarioMinimo(funcionarios, salarioMinimo);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static List<String[]> lerArquivoCSV(String filePath) {
        List<String[]> funcionarios = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.skip(1);

            String[] linha;
            while ((linha = reader.readNext()) != null) {
                funcionarios.add(linha);
            }
            return funcionarios;
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void filtrarPorCargo(List<String[]> funcionarios, String cargo) {
        for (String[] funcionario : funcionarios) {
            if (funcionario[1].equalsIgnoreCase(cargo)) {
                System.out.println("Nome: " + funcionario[0] + ", Cargo: " + funcionario[1] + ", Salário: " + funcionario[2]);
            }
        }
    }

    private static void filtrarPorSalarioMinimo(List<String[]> funcionarios, double salarioMinimo) {
        for (String[] funcionario : funcionarios) {
            double salario = Double.parseDouble(funcionario[2]);
            if (salario >= salarioMinimo) {
                System.out.println("Nome: " + funcionario[0] + ", Cargo: " + funcionario[1] + ", Salário: " + funcionario[2]);
            }
        }
    }
}
