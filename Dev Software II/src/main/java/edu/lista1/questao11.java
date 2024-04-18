package edu.lista1;

import edu.lista1.entidades.Pessoa;

import java.io.*;

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