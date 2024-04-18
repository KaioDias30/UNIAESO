package edu.lista1;

import edu.lista1.entidades.ContaBancaria;

import java.io.*;

public class questao14 {
    
    public static void main(String[] args) {
 
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("conta.dat"))) {
            ContaBancaria conta = (ContaBancaria) inputStream.readObject();
            System.out.println("Saldo antes da atualização: " + conta.getSaldo());
            
            conta.depositar(1000); 
            System.out.println("Saldo após a atualização: " + conta.getSaldo());

            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("conta.dat"))) {
                outputStream.writeObject(conta);
                System.out.println("Objeto ContaBancaria atualizado e serializado com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    }
