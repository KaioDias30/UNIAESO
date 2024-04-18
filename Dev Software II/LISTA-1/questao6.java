import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class questao6 {
    public static void main(String[] args) {
        String nomeArquivo = "dados.csv";

        try {
            FileReader arquivoReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(arquivoReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] campos = linha.split(",");
                for (String campo : campos) {
                    System.out.print(campo + " | ");
                }
                System.out.println();
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }
}