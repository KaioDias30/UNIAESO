package edu.lista1;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class questao19 {
    public static void main(String[] args) {
        String arquivoCSV = "funcionarios.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Quantos funcionários deseja adicionar? ");
            int numFuncionarios = scanner.nextInt();
            scanner.nextLine();

            String[] titulo = {"Nome", "Idade", "Nota"};
            writer.writeNext(titulo);
            for (int i = 0; i < numFuncionarios; i++) {
                System.out.println("\nDetalhes do Funcionário " + (i + 1));
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Cargo: ");
                String cargo = scanner.nextLine();
                System.out.print("Salário: ");
                String salario = scanner.nextLine();

                String[] linha = {nome, cargo, salario};
                writer.writeNext(linha);
            }
            System.out.println("Dados dos funcionários foram salvos no arquivo " + arquivoCSV);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}