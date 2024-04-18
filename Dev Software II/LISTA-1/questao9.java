import java.io.*;

public class questao9 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("meuarquivo.txt"));
            String linha;
            int contagem = 0;
            while ((linha = reader.readLine()) != null) {
                contagem += linha.split("Java").length - 1;
            }
            reader.close();
            System.out.println("A palavra 'Java' aparece " + contagem + " vezes.");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}