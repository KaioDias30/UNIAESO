package edu.lista1;

import edu.lista1.entidades.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class questao23 {
    public static void main(String[] args) {
        String csvFile = "produtos.csv";
        String line;
        String cvsSplitBy = ",";

        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int contadorLinha = 0;
            while ((line = br.readLine()) != null) {
                if (contadorLinha == 0) {
                    contadorLinha++;
                    continue;
                }

                String[] data = line.split(cvsSplitBy);
                String nome = data[0].trim();
                double preco = Double.parseDouble(data[1].trim());
                int quantidade = Integer.parseInt(data[2].trim());

                Produto produto = new Produto(nome, preco, quantidade);
                produtos.add(produto);
                contadorLinha++;
            }

            boolean continuar = true;
            while (continuar) {
                mostrarProdutos(produtos);

                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Inserir novo produto");
                System.out.println("2. Atualizar produto existente");
                System.out.println("3. Excluir produto existente");
                System.out.println("4. Sair");

                Scanner scanner = new Scanner(System.in);
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        inserirNovoProduto(produtos);
                        break;
                    case 2:
                        atualizarProduto(produtos);
                        break;
                    case 3:
                        excluirProduto(produtos);
                        break;
                    case 4:
                        System.out.println("Encerrando o programa.");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                        break;
                }
            }

            salvarParaCSV(produtos, csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarProdutos(List<Produto> produtos) {
        System.out.println("Produtos existentes:");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i));
        }
    }

    private static void inserirNovoProduto(List<Produto> produtos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do novo produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do novo produto:");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade do novo produto:");
        int quantidade = scanner.nextInt();
        Produto novoProduto = new Produto(nome, preco, quantidade);
        produtos.add(novoProduto);
        System.out.println("Novo produto adicionado com sucesso:");
        System.out.println(novoProduto);
    }

    private static void atualizarProduto(List<Produto> produtos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do produto que deseja atualizar:");
        int escolhaProduto = scanner.nextInt();
        if (escolhaProduto < 1 || escolhaProduto > produtos.size()) {
            System.out.println("Escolha inválida.");
            return;
        }
        Produto produtoSelecionado = produtos.get(escolhaProduto - 1);
        System.out.println("Digite o novo nome do produto:");
        scanner.nextLine();
        String novoNome = scanner.nextLine();
        System.out.println("Digite o novo preço do produto:");
        double novoPreco = scanner.nextDouble();
        System.out.println("Digite a nova quantidade do produto:");
        int novaQuantidade = scanner.nextInt();
        produtoSelecionado.setNome(novoNome);
        produtoSelecionado.setPreco(novoPreco);
        produtoSelecionado.setQuantidade(novaQuantidade);
        System.out.println("Produto atualizado com sucesso:");
        System.out.println(produtoSelecionado);
    }

    private static void excluirProduto(List<Produto> produtos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do produto que deseja excluir:");
        int escolhaProduto = scanner.nextInt();
        if (escolhaProduto < 1 || escolhaProduto > produtos.size()) {
            System.out.println("Escolha inválida.");
            return;
        }
        Produto produtoSelecionado = produtos.remove(escolhaProduto - 1);
        System.out.println("Produto excluído com sucesso:");
        System.out.println(produtoSelecionado);
    }

    private static void salvarParaCSV(List<Produto> produtos, String arquivoCSV) {
        try (FileWriter writer = new FileWriter(arquivoCSV)) {
            writer.append("Nome,Preco,Quantidade\n");
            for (Produto produto : produtos) {
                writer.append(produto.getNome()).append(",");
                writer.append(String.valueOf(produto.getPreco())).append(",");
                writer.append(String.valueOf(produto.getQuantidade())).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
