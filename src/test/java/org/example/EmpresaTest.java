package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class EmpresaTest  {

    @Test
    @DisplayName("Cadastrando os departamentos obrigatoriamente: Gerencia, Operações, Pesquisa e Desenvolvimento!")
    public void CadastrarDepartamentoCorreto() {
        Empresa empresa = new Empresa();
        int index = 0;
        empresa.cadastrarDepartamento(new Departamento("Gerencia"));
        empresa.cadastrarDepartamento(new Departamento("Operações"));
        empresa.cadastrarDepartamento(new Departamento("Pesquisa e Desenvolvimento"));
        String[] dep = new String[3];
        for (Departamento departamento : empresa.getDepartamentos()) {
            dep[index] = departamento.getNome();
            index++;
        }
        String[] comparativo = new String[3];
        comparativo[0] = "Gerencia";
        comparativo[1] = "Operações";
        comparativo[2] = "Pesquisa e Desenvolvimento";
        Assertions.assertArrayEquals(comparativo, dep);
    }

    @Test
    @DisplayName("Cadastrando os departamentos erronemante: Gerencia, Operações, Pesquisa e Desenvolvimento!")
    public void CadastrarDepartamentoIncorreto() {
        Empresa empresa = new Empresa();
        int index = 0;
        empresa.cadastrarDepartamento(new Departamento("Operacional"));
        empresa.cadastrarDepartamento(new Departamento("Vendas"));
        empresa.cadastrarDepartamento(new Departamento("Pesquisa e Desenvolvimento"));
        String[] dep = new String[3];
        for (Departamento departamento : empresa.getDepartamentos()) {
            dep[index] = departamento.getNome();
            index++;
        }
        String[] comparativo = new String[3];
        comparativo[0] = "Gerencia";
        comparativo[1] = "Operações";
        comparativo[2] = "Pesquisa e Desenvolvimento";
        Assertions.assertNotEquals(comparativo, dep);
    }


}