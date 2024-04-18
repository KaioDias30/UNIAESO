import java.io.*;

class Pessoa implements Serializable {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

public class questao11 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 30);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("pessoa.dat"))) {
            outputStream.writeObject(pessoa);
            System.out.println("Objeto Pessoa serializado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}