package entidade;

public class Gerente extends Funcionario {
	private Double comissão = null;

	public Gerente() {

	}

	public Gerente(String nome, Double salario, Double desconto, Double comissão) {
		super(nome, salario, desconto);
		this.comissão = comissão;
	}

	public Double getComissão() {
		return comissão;
	}

	public void setComissão(Double comissão) {
		this.comissão = comissão;
	}

	@Override
	public double calcularSalario() {

		return (getSalario() - getDesconto() + comissão);
	}

	@Override
	public String formatado() {

		return "Nome: " + getNome() + " Salário base : " + getSalario() + " Salário Final : " + calcularSalario();
	}

	@Override
	public void verificacao() {
		// TODO Auto-generated method stub

	}
}
