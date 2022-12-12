package org.example;

public class Empresa {
	private Departamento[] departamentos = new Departamento[3];
	private int index = 0;

	public void cadastrarDepartamento(Departamento d) {
		this.departamentos[index] = d;
		index++;
	}

	public Departamento[] getDepartamentos() {
		return departamentos;
	}

	public Funcionario procurarFuncionario(int matricula) {
		Funcionario f = null;
		for (Departamento departamento : departamentos) {
			Funcionario[] funcionarios = departamento.getFuncionarios();
			for (Funcionario funcionario : funcionarios) {
				if (funcionario != null && funcionario.getMatricula() == matricula) {
					f = funcionario;
					break;
				}
			}
		}
		return f;
	}

}
