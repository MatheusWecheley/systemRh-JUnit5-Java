package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class FuncionarioTest {

    @Test
    @DisplayName("Simular adicionar 2 dependentes")
    public void VerificarTem2Dependentes() {
        String dataContratacao = "10/10/2012";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = formatter.parse(dataContratacao, LocalDate::from);

        Funcionario func = new Funcionario("Matheus", "Teste", "123", data, new BigDecimal(1000), Cargo.valueOf("GERENTE"));

        Dependente dep1 = new Dependente("joao", GrauDependencia.valueOf("FILHO"), data);
        Dependente dep2 = new Dependente("joao", GrauDependencia.valueOf("FILHO"), data);
        func.adicionarDependente(dep1);
        func.adicionarDependente(dep2);
        Assertions.assertEquals(2, func.getQuantidadeDependentes());
    }

    @Test
    @DisplayName("Simular adicionar mais do que 2 dependentes")
    public void VerificarMaisQue2Dependentes() {
        String dataContratacao = "10/10/2012";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = formatter.parse(dataContratacao, LocalDate::from);

        Funcionario func = new Funcionario("Matheus", "Teste", "123", data, new BigDecimal(1000), Cargo.valueOf("GERENTE"));

        Dependente dep1 = new Dependente("joao", GrauDependencia.valueOf("FILHO"), data);
        Dependente dep2 = new Dependente("joao", GrauDependencia.valueOf("FILHO"), data);
        func.adicionarDependente(dep1);
        func.adicionarDependente(dep2);
        func.adicionarDependente(dep2);
        Assertions.assertEquals(3, func.getQuantidadeDependentes());
    }

    @Test
    @DisplayName("Simular adicionar um dependente maior do que 18 anos")
    public void VerificarDependenteMaior18() {

        String dataContratacao = "10/10/2001";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = formatter.parse(dataContratacao, LocalDate::from);

        Funcionario func = new Funcionario("Matheus", "Teste", "123", data, new BigDecimal(1000), Cargo.valueOf("GERENTE"));
        Dependente dep1 = new Dependente("joao", GrauDependencia.valueOf("FILHO"), data);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> func.adicionarDependente(dep1));
        Assertions.assertEquals("Não é possivel adicionar filhos maiores de 18 anos", exception.getMessage());
    }

    @Test
    @DisplayName("Simular adicionar um dependente menor do que 18 anos")
    public void VerificarDependenteMenor18() {
        String dataContratacao = "10/10/2018";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = formatter.parse(dataContratacao, LocalDate::from);

        Funcionario func = new Funcionario("Matheus", "Teste", "123", data, new BigDecimal(1000), Cargo.valueOf("GERENTE"));
        Dependente dep1 = new Dependente("joao", GrauDependencia.valueOf("FILHO"), data);

        Assertions.assertEquals(true, func.adicionarDependente(dep1));
    }

    @Test
    @DisplayName("Criar um funcionario com departamento!")
    public void VerificarTemDepartamento() {
        Empresa empresa = new Empresa();
        empresa.cadastrarDepartamento(new Departamento("Gerencia"));
        empresa.cadastrarDepartamento(new Departamento("Operações"));
        empresa.cadastrarDepartamento(new Departamento("Pesquisa e Desenvolvimento"));


        String dataContratacao = "10/10/2018";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = formatter.parse(dataContratacao, LocalDate::from);

        Funcionario func = new Funcionario("Matheus", "Teste", "123", data, new BigDecimal(1000), Cargo.valueOf("GERENTE"));
        empresa.getDepartamentos()[0].alocar(func);

        Assertions.assertNotEquals(null, func.getTrabalhaEm());
    }

    @Test
    @DisplayName("Criar um funcionario sem departamento!")
    public void VerificarSemDepartamento() {
        String dataContratacao = "10/10/2018";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = formatter.parse(dataContratacao, LocalDate::from);

        Funcionario func = new Funcionario("Matheus", "Teste", "123", data, new BigDecimal(1000), Cargo.valueOf("GERENTE"));

        Assertions.assertEquals(null, func.getTrabalhaEm());
    }


}
