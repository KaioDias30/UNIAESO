package edu.lista1;

import edu.lista1.entidades.Pessoa;

import java.io.*;

public class questao12 {
    public static void main(String[] args) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("pessoa.dat"))) {
            Pessoa pessoa = (Pessoa) inputStream.readObject();
            System.out.println("Detalhes da Pessoa:");
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}