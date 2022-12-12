package org.example;

public class Departamento {
	
	private String nome;
	private Funcionario[] funcionarios = new Funcionario[3];
	private int quantidadeTrabalhadores = 0;
	
	
	public Departamento(String nome) {
		super();
		this.nome = nome;
	}

	public void alocar(Funcionario f) {
		this.funcionarios[this.quantidadeTrabalhadores] = f;
		f.setTrabalhaEm(this);
		quantidadeTrabalhadores++;
		System.out.println(String.format("Funcionario %s vinculado ao departamento %s", f.getMatricula(), this.nome));
	}
	
	public String getNome() {
		return nome;
	}
	
	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}
	

}
