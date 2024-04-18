import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Produto implements Serializable {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

public class questao13 {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook", 2500.0));
        produtos.add(new Produto("Smartphone", 1200.0));
        produtos.add(new Produto("Headphone", 150.0));

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("produtos.dat"))) {
            outputStream.writeObject(produtos);
            System.out.println("Lista de Produtos serializada com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class questao13 {
    public static void main(String[] args) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("produtos.dat"))) {
            List<Produto> produtos = (List<Produto>) inputStream.readObject();
            System.out.println("Lista de Produtos:");
            for (Produto produto : produtos) {
                System.out.println("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}