import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class questao3 {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";
        String novaLinha = "Isso é uma adição!";

        try {
            FileWriter arquivoWriter = new FileWriter(nomeArquivo, true); // O segundo parâmetro true indica que queremos acrescentar ao final do arquivo
            BufferedWriter bufferedWriter = new BufferedWriter(arquivoWriter);

            bufferedWriter.write(novaLinha);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}