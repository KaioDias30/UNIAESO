import entidade.DepartamentoEmpresa;
import entidade.Empresa;
import entidade.Funcionario;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //Criando empresa
        Empresa kaioTecnologyEmpresa = new Empresa("Kaio Tecnology", "00.000.000.000/0000-00");
        System.out.println(kaioTecnologyEmpresa);

        //Criando departamentos
        System.out.println("Criando departamentos");
        DepartamentoEmpresa departamentoEmpresa0 = new DepartamentoEmpresa("Departamento 1");
        DepartamentoEmpresa departamentoEmpresa1 = new DepartamentoEmpresa("Departamento 2");
        DepartamentoEmpresa departamentoEmpresa2 = new DepartamentoEmpresa("Departamento 3");
        DepartamentoEmpresa departamentoEmpresa3 = new DepartamentoEmpresa("Departamento 4");
        DepartamentoEmpresa departamentoEmpresa4 = new DepartamentoEmpresa("Departamento 5");
        DepartamentoEmpresa departamentoEmpresa5 = new DepartamentoEmpresa("Departamento 6");

        //Adicionando departamentos na empresa
        kaioTecnologyEmpresa.adicionarDepartamento(departamentoEmpresa0);
        kaioTecnologyEmpresa.adicionarDepartamento(departamentoEmpresa1);
        kaioTecnologyEmpresa.adicionarDepartamento(departamentoEmpresa2);
        kaioTecnologyEmpresa.adicionarDepartamento(departamentoEmpresa3);
        kaioTecnologyEmpresa.adicionarDepartamento(departamentoEmpresa4);
        kaioTecnologyEmpresa.adicionarDepartamento(departamentoEmpresa5);

        System.out.println("===============================");
        System.out.println(kaioTecnologyEmpresa);

        //Criando funcionarios e adicionando no departamento da empresa
        Funcionario funcionario = new Funcionario("Joaquim", 1000.00, new Date());
        Funcionario funcionario1 = new Funcionario("Lucia", 1000.00, new Date());
        departamentoEmpresa0.adicionarFuncionario(funcionario);
        departamentoEmpresa0.adicionarFuncionario(funcionario1);

        System.out.println("============= DEPARTAMENTO 0 ==================");
        System.out.println(departamentoEmpresa0);

        Funcionario funcionario2 = new Funcionario("Manoela", 1000.00, new Date());
        Funcionario funcionario3 = new Funcionario("Kaio", 1000.00, new Date());
        departamentoEmpresa1.adicionarFuncionario(funcionario2);
        departamentoEmpresa1.adicionarFuncionario(funcionario3);

        System.out.println("============= DEPARTAMENTO 1 ==================");
        System.out.println(departamentoEmpresa1);

        Funcionario funcionario4 = new Funcionario("Kevin", 1000.00, new Date());
        Funcionario funcionario5 = new Funcionario("Keila", 1000.00, new Date());
        departamentoEmpresa2.adicionarFuncionario(funcionario4);
        departamentoEmpresa2.adicionarFuncionario(funcionario5);

        System.out.println("============= DEPARTAMENTO 2 ==================");
        System.out.println(departamentoEmpresa2);

        Funcionario funcionario6 = new Funcionario("Pietra", 1000.00, new Date());
        departamentoEmpresa3.adicionarFuncionario(funcionario6);

        System.out.println("============= DEPARTAMENTO 3 ==================");
        System.out.println(departamentoEmpresa3);

        Funcionario funcionario7 = new Funcionario("Alfredo", 1000.00, new Date());
        departamentoEmpresa4.adicionarFuncionario(funcionario7);

        System.out.println("============= DEPARTAMENTO 4 ==================");
        System.out.println(departamentoEmpresa4);

        Funcionario funcionario8 = new Funcionario("Harry", 1000.00, new Date());
        departamentoEmpresa5.adicionarFuncionario(funcionario8);

        System.out.println("============= DEPARTAMENTO 5 ==================");
        System.out.println(departamentoEmpresa5);

        //Concedendo aumento de 10% aos funcionarios do departamento 0 ( primeiro )
        System.out.println("============= DEPARTAMENTO ANTES DO AUMENTO ==================");
        System.out.println(departamentoEmpresa0);

        departamentoEmpresa0.adicionarAumentoATodosFuncionarios(10);
        System.out.println("============= DEPARTAMENTO APOS AUMENTO ==================");
        System.out.println(departamentoEmpresa0);

        //Tranferindo Funcionario de um departamento para outro
        System.out.println("============= DEPARTAMENTO ANTES DA TRANSFERENCIA ==================");
        System.out.println(String.format("Departamento antigo: %s", departamentoEmpresa0));
        System.out.println(String.format("Departamento destino: %s", departamentoEmpresa2));

        //Transferencia
        kaioTecnologyEmpresa.transferirFuncionarioDeDepartamento(departamentoEmpresa0, departamentoEmpresa2, funcionario);

        System.out.println("============= DEPARTAMENTO APOS A TRANSFERENCIA ==================");
        System.out.println(String.format("Departamento antigo: %s", departamentoEmpresa0));
        System.out.println(String.format("Departamento destino: %s", departamentoEmpresa2));
    }
}