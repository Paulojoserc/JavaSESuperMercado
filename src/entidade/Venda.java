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

	public double descontos() {
		if (cliente != null && total() >= 130) {
			return total() - 20;
		} else {
			return total();
		}
	}

	public double pagamento() {
		if (getTipoPagamento() == TipoPagamneto.CARTAO) {
			if (parcelas < 2) {
				return total();
			} else {
				return total() / parcelas;
			}
		} else {
			return total();
		}
	}

	public void parcelamento() throws Personalizado {
		if (parcelas > 3) {
			throw new Personalizado("Desculpe parcelamento maximo é 3x");
		}if(parcelas<1) {
			throw new Personalizado("Quantidade de parcelas inválidas");
		}
	}
	public String recibo() {
		StringBuilder bd = new StringBuilder();
		setStatus(StatusVenda.INICIANDO);
		setStatus(StatusVenda.PROCESSANDO);
		bd.append("==================\n");
		bd.append("DADOS DA VENDA : \n");
		bd.append("==================\n");
		if(cliente!=null) {
			bd.append("Cliente : "+cliente+"\n");
		}else {
			bd.append("Cliente : não cadastrado \n");
		}
		bd.append("Número do pedido do pedido : "+numero+"\n");
		bd.append("Data da Compra : "+sdf.format(agora)+"\n" );
		setStatus(StatusVenda.IMPRIMINDO);
		bd.append("Status : "+getStatus()+"\n");
		bd.append("Forma de Pagamento : "+getTipoPagamento());
		bd.append("ITENS DA VENDA : ");
		int contador=1;
		for (ItemVenda list : item) {
			list.setNumero(contador);
			bd.append(list+"\n");
			contador++;
		}
		if (getTipoPagamento()==TipoPagamneto.CARTAO) {
			for (int i=0; i<datas.size();i++) {
				bd.append((i)+"parcela : "+datas.get(i)+"valor : R$"+String.format("%.2f", pagamento()));
			}
			bd.append("Valor Total : "+pagamento()+"\n");
		}else {
			bd.append("Valor Total : "+pagamento()+"\n");
		}
		bd.append("Situação : "+getPago()+"\n");
		setStatus(StatusVenda.FINALIZANDO);
		
		return bd.toString();
	}
}

