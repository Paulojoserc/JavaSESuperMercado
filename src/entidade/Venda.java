package entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidade.enus.Pago;
import entidade.enus.StatusVenda;
import entidade.enus.TipoPagamneto;

public class Venda {
private List<ItensVenda> item = new ArrayList<>();
private Cliente cliente;
private Pago pago;
private StatusVenda status;
private TipoPagamneto tipoPagamento;
private Date agora = new Date();
private Integer number =null;
private Integer parcelas =null;
private Double desconto =null;
}
