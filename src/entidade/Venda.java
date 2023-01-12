package entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entidade.enus.Pago;
import entidade.enus.StatusVenda;
import entidade.enus.TipoPagamneto;
import erro.Personalizado;

public class Venda {
	private List<ItemVenda> item = new ArrayList<>();
	private Cliente cliente;
	private Pago pago;
	private StatusVenda status;
	private TipoPagamneto tipoPagamento;
	private Date agora = new Date();
	private Integer numero = null;
	private Integer parcelas = null;

	public Venda() {
	}

	public Venda(Integer numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public StatusVenda getStatus() {
		return status;
	}

	public void setStatus(StatusVenda status) {
		this.status = status;
	}

	public TipoPagamneto getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamneto tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public List<ItemVenda> getItem() {
		return item;
	}

	public Date getAgora() {
		return agora;
	}

	public double total() {
		double soma = 0;
		for (ItemVenda list : item) {
			soma = soma + list.subTotal();
		}
		return soma;
	}

	public void validacao() {

	}

	private List<String> datas = new ArrayList<>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public void validacaoTempo() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(agora);
		for (int i = 1; i < parcelas; i++) {
			// Vai add na lista datas o mês atual +1
			cal.add(Calendar.MONTH, i);
			Date data = cal.getTime();
			String dataFOrmatada = sdf.format(data);
			datas.add(dataFOrmatada);
		}
	}
	
	public void adicionarItem(ItemVenda itens) {
		item.add(itens);
	}
	
	public void removerItem(ItemVenda itens) {
		item.remove(itens);
	}
	public void parcelamento() throws Personalizado {
		if(parcelas>3) {
			throw new Personalizado("Desculpe parcelamento maximo é 3x");
		}
	}
}
