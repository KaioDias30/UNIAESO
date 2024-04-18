package edu.lista1;


import edu.lista1.entidades.questao13.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class questao13 {
    public static void main(String[] args) {
    
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook", 2500.0));
        produtos.add(new Produto("Smartphone", 1200.0));
        produtos.add(new Produto("Headphone", 150.0));

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("produtos.dat"))) {
            outputStream.writeObject(produtos);
            System.out.println("Lista de produtos serializada com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("produtos.dat"))) {
            @SuppressWarnings("unchecked")
            List<Produto> produtosDeserializados = (List<Produto>) inputStream.readObject();
            System.out.println("Lista de produtos deserializada:");
            for (Produto produto : produtosDeserializados) {
                System.out.println("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}