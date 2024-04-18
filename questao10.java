import java.io.*;

public class questao10 {
    public static void main(String[] args) {
        try {
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("arquivo1.txt"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("arquivo2.txt"));
            writer1.write("Conteúdo do arquivo 1.");
            writer2.write("Conteúdo do arquivo 2.");
            writer1.close();
            writer2.close();
            BufferedReader reader1 = new BufferedReader(new FileReader("arquivo1.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("arquivo2.txt"));
            BufferedWriter writerConcat = new BufferedWriter(new FileWriter("arquivo_concatenado.txt"));
            String linha;
            while ((linha = reader1.readLine()) != null) {
                writerConcat.write(linha);
                writerConcat.newLine();
            }
            while ((linha = reader2.readLine()) != null) {
                writerConcat.write(linha);
                writerConcat.newLine();
            }
            reader1.close();
            reader2.close();
            writerConcat.close();
            System.out.println("Arquivos concatenados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}