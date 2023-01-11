 package entidade;

public class ItensVenda {
private Integer numero=null;
private String nomeProduto=null;
private Double valorUnitario =null;
private Integer quantidade =null;

public ItensVenda() {
	
}

public ItensVenda(Integer numero, String nomeProduto, Double valorUnitario, Integer quantidade) {
	this.numero = numero;
	this.nomeProduto = nomeProduto;
	this.valorUnitario = valorUnitario;
	this.quantidade = quantidade;
}

public Integer getNumero() {
	return numero;
}

public void setNumero(Integer numero) {
	this.numero = numero;
}

public String getNome() {
	return nomeProduto;
}

public void setNome(String nome) {
	this.nomeProduto = nome;
}

public Double getValor() {
	return valorUnitario;
}

public void setValor(Double valor) {
	this.valorUnitario = valor;
}

public Integer getQuantidade() {
	return quantidade;
}

public void setQuantidade(Integer quantidade) {
	this.quantidade = quantidade;
}
public double SubTotal() {
	return quantidade+valorUnitario;
}

@Override
public String toString() {
	return " Codigo:" + numero + " Descrição: " + nomeProduto + " R$" + valorUnitario +" x "+ " QuantidadeItens: " + quantidade+ "= R$: "+SubTotal();
}

}
