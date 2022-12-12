package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
;import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FolhaPagamentoTest {

    @Test
    @DisplayName("Gerar pagamento com um dependente!")
    public void TesteDeAcrescimentoUmDependente() {
        String dataContratacao = "10/10/2012";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = formatter.parse(dataContratacao, LocalDate::from);
        BigDecimal salario = BigDecimal.valueOf(1000);

        Funcionario func = new Funcionario("Matheus", "Teste", "123", data, salario, Cargo.valueOf("GERENTE"));
        Dependente dep1 = new Dependente("joao", GrauDependencia.valueOf("FILHO"), data);
        func.adicionarDependente(dep1);

        BigDecimal resultado = FolhaPagamento.calcularValorAcrescimoPorDependentes(func);
        Assertions.assertEquals(new BigDecimal("105.99"), resultado);
    }

    @Test
    @DisplayName("Gerar pagamento com dois dependentes!")
    public void TesteDeAcrescimentoDoisDependente() {
        String dataContratacao = "10/10/2012";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = formatter.parse(dataContratacao, LocalDate::from);
        BigDecimal salario = BigDecimal.valueOf(1000);

        Funcionario func = new Funcionario("Matheus", "Teste", "123", data, salario, Cargo.valueOf("GERENTE"));
        Dependente dep1 = new Dependente("joao", GrauDependencia.valueOf("FILHO"), data);
        Dependente dep2 = new Dependente("joao", GrauDependencia.valueOf("FILHO"), data);
        func.adicionarDependente(dep1);
        func.adicionarDependente(dep2);

        BigDecimal resultado = FolhaPagamento.calcularValorAcrescimoPorDependentes(func);
        Assertions.assertEquals(new BigDecimal("211.98"), resultado);
    }

    @Test
    @DisplayName("Gerar pagamento com somatorio dos anos trabalhados!")
    public void VerificarAcrescimoTempoTrabalho() {
        String dataContratacao = "10/10/2014";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = formatter.parse(dataContratacao, LocalDate::from);
        BigDecimal salario = BigDecimal.valueOf(1000);

        Funcionario func = new Funcionario("Matheus", "Teste", "123", data, salario, Cargo.valueOf("GERENTE"));

        BigDecimal resultado = FolhaPagamento.calcularValorAcrescimoPorTempo(func);
        Assertions.assertEquals(new BigDecimal("800"), resultado);
    }

    @Test
    @DisplayName("Gerar pagamento com descontos para funcionario NÃO engenheiro !")
    public void VerificarPercentualImpostos() {
        String dataContratacao = "10/10/2012";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = formatter.parse(dataContratacao, LocalDate::from);
        BigDecimal salario = BigDecimal.valueOf(1000);

        Funcionario func = new Funcionario("Matheus", "Teste", "123", data, salario, Cargo.valueOf("GERENTE"));

        BigDecimal resultado = FolhaPagamento.calcularValorPagar(func);
        Assertions.assertEquals(new BigDecimal("1700"), resultado);
    }

    @Test
    @DisplayName("Gerar pagamento com descontos para funcionario engenheiro!")
    public void VerificarPercentualImpostosEngenheiro() {
        String dataContratacao = "10/10/2012";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = formatter.parse(dataContratacao, LocalDate::from);
        BigDecimal salario = BigDecimal.valueOf(1000);

        Funcionario func = new Funcionario("Matheus", "Teste", "123", data, salario, Cargo.valueOf("ENGENHEIRO"));

        BigDecimal resultado = FolhaPagamento.calcularValorPagar(func);
        Assertions.assertEquals(new BigDecimal("1600"), resultado);
    }

}