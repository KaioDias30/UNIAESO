package entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartamentoEmpresa {

    private String nome;
    private List<Funcionario> funcionarios = new ArrayList<>();

    public DepartamentoEmpresa() {
    }

    public DepartamentoEmpresa(String nome) {
        this.nome = nome;
    }

    public void adicionarFuncionario(Funcionario novoFuncionario){
        this.funcionarios.add(novoFuncionario);
    }

    public void removerFuncionario(Funcionario funcionarioRemovido){
        this.funcionarios.remove(funcionarioRemovido);
    }

    public void adicionarAumentoATodosFuncionarios(int percentual){
        funcionarios.stream().forEach(f -> f.adicionarAumento(percentual));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartamentoEmpresa that = (DepartamentoEmpresa) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return "DepartamentoEmpresa{" +
                "nome='" + nome + '\'' +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
