package entidade;

import erro.Personalizado;

public abstract class Funcionario {
private String Nome =null;
private Double salario =null;
private Double desconto =null;

public Funcionario() {
	
}


public Funcionario(String nome, Double salario, Double desconto) {
	Nome = nome;
	this.salario = salario;
	this.desconto = desconto;
}





public String getNome() {
	return Nome;
}


public void setNome(String nome) {
	Nome = nome;
}


public Double getSalario() {
	return salario;
}


public void setSalario(Double salario) {
	this.salario = salario;
}


public Double getDesconto() {
	return desconto;
}


public void setDesconto(Double desconto) {
	this.desconto = desconto;
}


public abstract double calcularSalario();


public abstract String formatado(); 
	

public abstract void verificacao() throws Personalizado; 
	

}
