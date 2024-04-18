import java.io.*;
import java.util.*;

public class questao7 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("meuarquivo.txt"));
            List<String> linhas = new ArrayList<>();
            String linha;
            while ((linha = reader.readLine()) != null)
                linhas.add(linha);
            reader.close();
            Collections.sort(linhas);
            BufferedWriter writer = new BufferedWriter(new FileWriter("meuarquivo_ordenado.txt"));
            for (String l : linhas) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}