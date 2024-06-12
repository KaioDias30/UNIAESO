package entidade;

import java.util.Date;
import java.util.Objects;

public class Funcionario {

    private String nome;
    private Double salario;
    private Date dataAdmissao;

    public Funcionario(String nome, Double salario, Date dataAdmissao) {
        this.nome = nome;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void adicionarAumento(Integer percentual){
        double aumento = salario * (percentual / 100);
        double novoSalario = salario + aumento;
        this.salario = novoSalario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(nome, that.nome) && Objects.equals(salario, that.salario) && Objects.equals(dataAdmissao, that.dataAdmissao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, salario, dataAdmissao);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                ", dataAdmissao=" + dataAdmissao +
                '}';
    }
}
