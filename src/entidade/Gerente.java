package entidade;

public class Gerente extends Funcionario {
	private Double comiss�o = null;

	public Gerente() {

	}

	public Gerente(String nome, Double salario, Double desconto, Double comiss�o) {
		super(nome, salario, desconto);
		this.comiss�o = comiss�o;
	}

	public Double getComiss�o() {
		return comiss�o;
	}

	public void setComiss�o(Double comiss�o) {
		this.comiss�o = comiss�o;
	}

	@Override
	public double calcularSalario() {

		return (getSalario() - getDesconto() + comiss�o);
	}

	@Override
	public String formatado() {

		return "Nome: " + getNome() + " Sal�rio base : " + getSalario() + " Sal�rio Final : " + calcularSalario();
	}

	@Override
	public void verificacao() {
		// TODO Auto-generated method stub

	}
}
