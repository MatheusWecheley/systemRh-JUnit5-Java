package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Funcionario {
	private String nome;
	private String sobrenome;
	private String cpf;
	private LocalDate dataContratacao;
	private BigDecimal salario;
	private Cargo cargo;
	private Departamento trabalhaEm;
	private Dependente[] dependetentes = new Dependente[2];
	private int quantidadeDependentes = 0;
	private int matricula = 0;
	private static int contador = 0;

	public Funcionario(String nome, String sobrenome, String cpf, LocalDate dataContratacao, BigDecimal salario,
			Cargo cargo) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataContratacao = dataContratacao;
		this.salario = salario;
		this.cargo = cargo;
		contador++;
		this.matricula = contador;
	}
	
	public int getMatricula() {
		return matricula;
	}

	public boolean adicionarDependente(Dependente d) {
		LocalDate hoje = LocalDate.now();
		int idade = Period.between(d.getDataNascimento(), hoje).getYears();
		if (d.getGrauDependencia().equals(GrauDependencia.FILHO)) {
			if (idade <= 18) {
				this.dependetentes[quantidadeDependentes] = d;
				quantidadeDependentes++;
				return true;
			} else {
				throw new RuntimeException("Não é possivel adicionar filhos maiores de 18 anos");
			}
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public void setTrabalhaEm(Departamento trabalhaEm) {
		this.trabalhaEm = trabalhaEm;
	}

	public Departamento getTrabalhaEm() {
		return trabalhaEm;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Dependente[] getDependetentes() {
		return dependetentes;
	}

	public int getQuantidadeDependentes() {
		return quantidadeDependentes;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", dataContratacao="
				+ dataContratacao + ", salario=" + salario + ", cargo=" + cargo + ", trabalhaEm=" + trabalhaEm
				+ ", dependetentes=" + Arrays.toString(dependetentes) + ", quantidadeDependentes="
				+ quantidadeDependentes + ", matricula=" + matricula + "]";
	}
	
	
}
