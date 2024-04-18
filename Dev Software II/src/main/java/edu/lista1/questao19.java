//import com.opencsv.CSVWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class EscreverCSV {
//    public static void main(String[] args) {
//        // Caminho do arquivo CSV
//        String arquivoCSV = "funcionarios.csv";
//
//        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
//            Scanner scanner = new Scanner(System.in);
//
//            // Pergunta ao usuário quantos funcionários deseja adicionar
//            System.out.print("Quantos funcionários deseja adicionar? ");
//            int numFuncionarios = scanner.nextInt();
//            scanner.nextLine(); // Limpa o buffer do scanner
//
//            // Loop para solicitar detalhes de cada funcionário e escrever no arquivo CSV
//            for (int i = 0; i < numFuncionarios; i++) {
//                System.out.println("\nDetalhes do Funcionário " + (i + 1));
//                System.out.print("Nome: ");
//                String nome = scanner.nextLine();
//                System.out.print("Cargo: ");
//                String cargo = scanner.nextLine();
//                System.out.print("Salário: ");
//                String salario = scanner.nextLine();
//
//                // Escreve os detalhes do funcionário no arquivo CSV
//                String[] linha = {nome, cargo, salario};
//                writer.writeNext(linha);
//            }
//
//            System.out.println("Dados dos funcionários foram salvos no arquivo " + arquivoCSV);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}