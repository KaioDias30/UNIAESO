//import java.io.FileReader;
//import java.io.IOException;
//
//public class questao18 {
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//
//        String arquivoCSV = "alunos.csv";
//
//        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
//
//            String[] linha;
//            while ((linha = reader.readNext()) != null) {
//
//                System.out.println("Nome: " + linha[0] + ", Idade: " + linha[1] + ", Nota: " + linha[2]);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}