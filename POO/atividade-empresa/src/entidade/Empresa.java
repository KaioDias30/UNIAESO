package entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empresa {

    private String nome;
    private String cnpj;
    private List<DepartamentoEmpresa> departamentos = new ArrayList<>();

    public Empresa() {
    }

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public void adicionarDepartamento(DepartamentoEmpresa novoDepartamento){
        if(departamentos.size() < 10)
            this.departamentos.add(novoDepartamento);
    }

    public void removerDepartamento(DepartamentoEmpresa departamentoRemovido){
        this.departamentos.remove(departamentoRemovido);
    }

    public void transferirFuncionarioDeDepartamento(DepartamentoEmpresa antigo, DepartamentoEmpresa novo, Funcionario funcionario){
        antigo.removerFuncionario(funcionario);
        novo.adicionarFuncionario(funcionario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(nome, empresa.nome) && Objects.equals(cnpj, empresa.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cnpj);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", departamentos=" + departamentos +
                '}';
    }
}
