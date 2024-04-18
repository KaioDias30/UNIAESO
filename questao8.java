import java.io.*;

public class questao8 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("meuarquivo.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("meuarquivo_sem_excluir.txt"));
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!linha.contains("excluir")) {
                    writer.write(linha);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}