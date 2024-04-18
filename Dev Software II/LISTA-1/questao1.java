import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class questao1 {
    public static void main(String[] args) {
        
        String nomeArquivo = "meuarquivo.txt";
        String mensagem = "Olá, mundo!";
        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(mensagem);
            printWriter.close();
            System.out.println("Mensagem escrita com sucesso em '" + nomeArquivo + "'.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}