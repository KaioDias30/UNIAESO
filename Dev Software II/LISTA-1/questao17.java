import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario implements Serializable {
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

public class questao17 {
    private static final String ARQUIVO_FUNCIONARIOS = "funcionarios.dat";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Funcionario> funcionarios = carregarFuncionarios();

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarFuncionario(funcionarios);
                    break;
                case 2:
                    listarFuncionarios(funcionarios);
                    break;
                case 3:
                    atualizarFuncionario(funcionarios);
                    break;
                case 4:
                    excluirFuncionario(funcionarios);
                    break;
                case 5:
                    salvarFuncionarios(funcionarios);
                    System.out.println("Encerrando o programa.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Funcionario> carregarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        File arquivo = new File(ARQUIVO_FUNCIONARIOS);
        if (arquivo.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ARQUIVO_FUNCIONARIOS))) {
                funcionarios = (List<Funcionario>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return funcionarios;
    }

    private static void salvarFuncionarios(List<Funcionario> funcionarios) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ARQUIVO_FUNCIONARIOS))) {
            outputStream.writeObject(funcionarios);
            System.out.println("Funcionários salvos com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void adicionarFuncionario(List<Funcionario> funcionarios) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        funcionarios.add(new Funcionario(nome, idade, salario));
        System.out.println("Funcionário adicionado com sucesso.");
    }

    private static void listarFuncionarios(List<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            for (int i = 0; i < funcionarios.size(); i++) {
                System.out.println((i + 1) + ". " + funcionarios.get(i));
            }
        }
    }

    private static void atualizarFuncionario(List<Funcionario> funcionarios) {
        listarFuncionarios(funcionarios);
        System.out.print("Digite o número do funcionário que deseja atualizar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); 
        if (indice >= 0 && indice < funcionarios.size()) {
            Funcionario funcionario = funcionarios.get(indice);
            System.out.print("Novo nome: ");
            funcionario.setNome(scanner.nextLine());
            System.out.print("Nova idade: ");
            funcionario.setIdade(scanner.nextInt());
            System.out.print("Novo salário: ");
            funcionario.setSalario(scanner.nextDouble());
            scanner.nextLine(); // Consumir quebra de linha após o nextDouble()
            System.out.println("Funcionário atualizado com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void excluirFuncionario(List<Funcionario> funcionarios) {
        listarFuncionarios(funcionarios);
        System.out.print("Digite o número do funcionário que deseja excluir: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); 
        if (indice >= 0 && indice < funcionarios.size()) {
            funcionarios.remove(indice);
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void exibirMenu() {
        System.out.println("\n### Menu ###");
        System.out.println("1. Adicionar funcionário");
        System.out.println("2. Listar funcionários");
        System.out.println("3. Atualizar funcionário");
        System.out.println("4. Excluir funcionário");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }
}