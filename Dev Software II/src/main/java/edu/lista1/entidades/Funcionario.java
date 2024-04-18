package edu.lista1.entidades;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private String nome;
    private int idade;
    private double salario;

    public Funcionario(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }


    public String toString() {
        return "Funcionário: " + nome + ", Idade: " + idade + ", Salário: " + salario;
    }


    public void setSalario(double nextDouble) {

        throw new UnsupportedOperationException("Unimplemented method 'setSalario'");
    }


    public void setIdade(int nextInt) {

        throw new UnsupportedOperationException("Unimplemented method 'setIdade'");
    }


    public void setNome(String nextLine) {

        throw new UnsupportedOperationException("Unimplemented method 'setNome'");
    }
}
